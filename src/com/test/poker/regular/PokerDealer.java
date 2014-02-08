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
	
}
