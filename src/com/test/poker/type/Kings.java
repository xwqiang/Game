package com.test.poker.type;

import java.util.List;

import com.test.poker.Poker;
import com.test.poker.PokerPoint;

public class Kings extends Type {
	public Kings(){
		name =Type.kings;
	}
	@Override
	public boolean bigger(Type type) {
		return true;
	}

	@Override
	public boolean validate(List<Poker> list) {
		if(list.size()==2 && list.get(0).getPoint()+list.get(1).getPoint()== PokerPoint.Joker0+PokerPoint.Joker1){return true;}
		return false;
	}
}
