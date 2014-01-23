package com.test.poker.type;

import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.util.SequenceSort;

public class Bomb extends Type {
	public Bomb(){
		name =Type.bomb;
	}
	@Override
	public boolean bigger(List<Poker> inList) {
		if(this.list.get(0).getPoint()>inList.get(0).getPoint()){
			return true;
		}
		return false;
	}

	@Override
	public boolean validate(List<Poker> list) {
		Collections.sort(list,new SequenceSort());
		if(list.size() == 4 && list.get(0).getPoint() == list.get(3).getPoint()){return true;}
		return false;
	}
}
