package com.test.poker.regular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.PokerColor;
import com.test.poker.methodRequest.ISendMethodReQ;
import com.test.poker.methodRequest.SendMethodReQ;
import com.test.poker.type.Type;

public class Player {
	private String playerName;
	
	public List<Poker> handslist ;
	public List<Poker> outlist = new ArrayList<Poker>();
	public List<Poker> inlist = new ArrayList<Poker>();
	public Type outType ;
	public Type inType ;
	
	public Type getOutType() {
		return outType;
	}
	public void setOutType(Type outType) {
		this.outType = outType;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Player(String playerName) {
		this.handslist = PokerDealer.getPokers();
		Collections.sort(handslist,new SequenceSort());
		this.playerName = playerName;
	}
	public void pointSort(){
		Collections.sort(handslist,new SequenceSort());
	}
	public void showPokers(){
		if(handslist == null || handslist.size() == 0){return ;}
		System.out.print("------->"+this.playerName+" [");
		for(Poker p : handslist){
			if(p.getStatus() == Poker.ready){
				System.out.print(p + "  ");
			}else{
				System.err.print(p + "  ");
			}
		}
		System.out.print("]");
		System.out.println();
	}
	
	public List<Poker> getOutlist() {
		return outlist;
	}
	public void setOutlist(List<Poker> outlist) {
		this.outlist = outlist;
	}
	public Type getInType() {
		return inType;
	}
	public void setInType(Type inType) {
		this.inType = inType;
	}
	private void play(Poker p){
		outlist.add(p);
		p.setStatus(Poker.beforeSend);
	}
	public void play(int point){
		for(Poker p : handslist){
			if(p.getPoint() == point && p.getStatus() ==Poker.ready){
				play(p);
				break;
			}
		}
	}
	public boolean send(Player reciever){
		ISendMethodReQ sendMR = new SendMethodReQ(this);
		return sendMR.send(reciever);
	}
	public boolean revieve(Type outType){
		this.setInType(outType);
		return true;
	}
	public static void main(String[] ar){
		List<Poker> ll = new ArrayList<Poker>();
		Poker p = new Poker(4,PokerColor.COLOR.CLUB);
		ll.add(p);
		System.out.println(ll);
		p.setPoint(5);
		p = null;
		try {
			Thread.sleep(1333);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(ll);
	}
}
