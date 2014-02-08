package com.test.poker.type;

import java.util.List;

import com.test.poker.Poker;

public class Double extends Type{
	public Double(){
		name =Type.pair;
	}
	@Override
	public boolean bigger(Type type) {
		List<Poker> inList = type.getList();
		if(this.list.get(0).getPoint() > inList.get(0).getPoint()){
			return true;
		}
		return false;
	}

	@Override
	public boolean validate(List<Poker> list) {
		if(list.size() ==2 && list.get(0).getPoint()==list.get(1).getPoint()){
			return true;
		}
		return false;
	}
}

