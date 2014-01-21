package com.test.poker.type;

import java.util.List;

import com.test.poker.Poker;

public class Single extends Type {
	@Override
	public boolean bigger(List<Poker> list) {
		if(this.list.get(0).getPoint()>list.get(0).getPoint()){
			return true;
		}
		return false;
	}

	@Override
	public boolean validate(List<Poker> list) {
		// TODO Auto-generated method stub
		return false;
	}
}
