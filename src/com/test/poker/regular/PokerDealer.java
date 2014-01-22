package com.test.poker.regular;

import java.util.ArrayList;
import java.util.List;

import com.test.poker.Poker;
/**
 * 发牌器
 * @author 1207264
 *
 */
public class PokerDealer {
	
	public static List<Poker> getPokers(){
 		List<Poker> yourPokers = new ArrayList<Poker>();
		for(int i = 0 ; i < 18 ; i ++){
			yourPokers.add(new PokerCentre().get());
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
//	public boolean validate(List<Poker> pokers){
//		if(pokers == null || pokers.size() ==0){return false;}
//		int size = pokers.size();
//		switch(size){
//			case 1:return true;
//			case 2:x
//				if(pokers.get(0).getPoint()==pokers.get(1).getPoint()) return true;
//				if(pokers.get(0).getPoint()==PokerPoint.Joker0 && pokers.get(1).getPoint()==PokerPoint.Joker1) return true;
//				return true;
//			default :return false;
//		}
//	}
}
