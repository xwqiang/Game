package com.test.poker.regular;

import java.util.ArrayList;
import java.util.List;

import com.test.poker.Poker;

public class LandlordReg {
	
	public static List<Poker> getPokers(){
		List<Poker> yourPokers = new ArrayList<Poker>();
		for(int i = 0 ; i < 18 ; i ++){
			yourPokers.add(PokerCentre.get());
		}
		return yourPokers;
	}
	public List<Poker> landLord() throws Exception{
		List<Poker> list = PokerCentre.getPokerLeft();
		if(list.size() != 3){
			throw new Exception("pokers haven't sended");
		}
		return PokerCentre.getPokerLeft();
	}
	public boolean validate(List<Poker> pokers){
		if(pokers == null || pokers.size() ==0){return false;}
		int size = pokers.size();
		switch(size){
			case 1:return true;
			case 2:
				if(pokers.get(0).getPoint()==pokers.get(1).getPoint()) return true;
				if(pokers.get(0).getPoint()==14 && pokers.get(1).getPoint()==15) return true;
				return true;
			default :return false;
		}
	}
}
