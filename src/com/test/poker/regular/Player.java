package com.test.poker.regular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.PokerColor;
import com.test.poker.methodRequest.ISendMethodReQ;
import com.test.poker.methodRequest.SendMethodReQ;
import com.test.poker.type.AffordNone;
import com.test.poker.type.Type;
import com.test.poker.util.SequenceSort;

public class Player {
	private String playerName;
	private PokerDealer pokerDealer;
	
	private boolean isLandLord;
	public List<Poker> handslist ;
	public List<Poker> outlist = new ArrayList<Poker>();
	public List<Poker> inlist = new ArrayList<Poker>();
	public Type outType ;
	public Type inType ;
	public Status status = Status.begin;
	
	public int handSize(){
		int i = 0 ;
		for(Poker poker : handslist){
			if(poker.getStatus() == Poker.ready){
				i++;
			}
		}
		return i;
	}
	public boolean isLandLord() {
		return isLandLord;
	}
	public void setLandLord(boolean isLandLord) {
		this.isLandLord = isLandLord;
	}
	public PokerDealer getPokerDealer() {
		return pokerDealer;
	}
	public void setPokerDealer(PokerDealer pokerDealer) {
		this.pokerDealer = pokerDealer;
	}
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
		this.handslist = PokerCentre.getPokers();
		Collections.sort(handslist,new SequenceSort());
		this.playerName = playerName;
		pokerDealer = new PokerDealer(handslist);
	}
	public void pointSort(){
		Collections.sort(handslist,new SequenceSort());
	}
	public String showPokers(){
		String show = "";
		if(handslist == null || handslist.size() == 0){return "";}
		show +=" [";
		for(Poker p : handslist){
			if(p.getStatus() != Poker.afterSend){
				show +=p + "\t";
			}else{
				show +="---" + "\t";
			}
		}
		show +="]";
		System.out.println();
		return show;
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
	public void play(Poker p){
		if(p == null){return ;}
		outlist.add(p);
		p.setStatus(Poker.beforeSend);
	}
	
//	public boolean cancel(){
//		this.status = Status.end;
//		return true;
//	}
	public boolean send(Player reciever){
		boolean flag = false;
		try {
			ISendMethodReQ sendMR = new SendMethodReQ(this);
			flag = sendMR.send(reciever);
		} catch (Exception e) {
			pokerDealer.cancelSending();
			e.printStackTrace();
		}
		return flag;
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
