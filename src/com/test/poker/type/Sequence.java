package com.test.poker.type;

import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.util.ListUtils;

public class Sequence extends Type {
	public Sequence(){
		name = Type.sequence;
	}
	@Override
	public boolean bigger(List<Poker> inList) {
		if(this.list.size() == inList.size() && this.list.get(0).getPoint()>inList.get(0).getPoint()){
			return true;
		}
		return false;
	}

	@Override
	public boolean validate(List<Poker> list) {
		List<Integer> l = ListUtils.toListInt(list);
		Collections.sort(l);
		return list.size() >= 5 && ListUtils.isSequence(l);
	}
	
}
