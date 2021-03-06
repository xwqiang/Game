package com.test.poker.type;

import java.util.List;

import com.test.poker.Poker;

public class Single extends Type {
	public Single(){
		name  = Type.single;
	}
	@Override
	public boolean bigger(Type type) {
		List<Poker> inList = type.getList();
		if(this.list.get(0).getPoint()>inList.get(0).getPoint()){
			return true;
		}
		return false;
	}

	@Override
	public boolean validate(List<Poker> list) {
		if(list.size()==1){return true;}
		return false;
	}
}
