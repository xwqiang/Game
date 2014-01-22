package com.test.poker.regular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.methodRequest.SendMethodReQ;
import com.test.poker.type.Type;
import com.test.poker.validate.TypeValidation;

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
		this.playerName = playerName;
	}
	public void pointSort(){
		Collections.sort(handslist,new SequenceSort());
	}
	public void showPokers(){
		if(handslist == null || handslist.size() == 0){return ;}
		System.out.println(handslist);
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
		outlist.add(p);
		handslist.remove(p);
	}
	public boolean send(Player reciever){
		this.outType = TypeValidation.validate(outlist);
		SendMethodReQ sendMR = new SendMethodReQ(this);
		return sendMR.send(reciever);
	}
	public boolean revieve(Type outType){
		this.setInType(outType);
		System.out.println(this.playerName+" 接到牌:"+ outType);
		return true;
	}
	
}
