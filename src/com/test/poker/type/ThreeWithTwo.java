package com.test.poker.type;

import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.regular.SequenceSort;

public class ThreeWithTwo extends Type {
	@Override
	public boolean bigger(List<Poker> list) {
		if(this.list.size() ==2 ){return true;}
		if(list.size() ==2 ){return false;}
		if(getMain(this.list) > getMain(list)){
			return true;
		}
		return false;
	}
	
	public int getMain(List<Poker> list) {
		Collections.sort(list,new SequenceSort());
		return list.get(2).getPoint();
	}

	@Override
	public boolean validate(List<Poker> list) {
		// TODO Auto-generated method stub
		return false;
	}
}
