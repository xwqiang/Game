package com.test.poker.type;

import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.util.SequenceSort;

public class SequenceDouble extends Type {
	public SequenceDouble(){
		name = Type.sequence;
	}
	@Override
	public boolean bigger(Type type) {
		List<Poker> inList = type.getList();
		if(this.list.size() == inList.size() && this.list.get(0).getPoint()>inList.get(0).getPoint()){
			return true;
		}
		return false;
	}

	@Override
	public boolean validate(List<Poker> list) {
		Collections.sort(list,new SequenceSort());
		return isSequence(list);
	}
	private boolean isSequence(List<Poker> list) {
		if(list.size() < 6 || list.size() % 2 == 1){return false;}
		for(int i = 0 ; i < list.size() -2; i=i+2){
			if(list.get(i).getPoint()+1 != list.get(i+2).getPoint()){
				return false;
			}
			if(list.get(i).getPoint() != list.get(i+1).getPoint()){
				return false;
			}
		}
		return true;
	}
}
