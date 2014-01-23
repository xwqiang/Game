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
	private List<Poker> list = new ArrayList<Poker>();
	public PokerDealer(List<Poker> handslist) {
		this.list = handslist;
	}
	
	public List<Poker> landLord() throws Exception{
		List<Poker> list = PokerCentre.getPokerLeft();
		if(list.size() != 3){
			throw new Exception("pokers haven't sended");
		}
		return PokerCentre.getPokerLeft();
	}
	
	/**
	 * 出牌结束后更改状态
	 * @param list
	 */
	public void confirmSending(){
		for(Poker p : this.list){
			if(p.getStatus() == Poker.beforeSend){
				p.setStatus(Poker.afterSend);
			}
		}
	}
	
	public  void cancelSending(){
		for(Poker p : this.list){
			if(p.getStatus() == Poker.beforeSend){
				p.setStatus(Poker.ready);
			}
		}
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
