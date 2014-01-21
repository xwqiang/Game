package com.test.poker.regular;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.type.Type;
import com.test.poker.validate.TypeValidation;

public class Player {
	private String playerName;
	private int isReady;
	private int isLandLord;
	private boolean myturn;
	
	public List<Poker> handslist ;
	public List<Poker> outlist = new ArrayList<Poker>();
	public List<Poker> inlist = new ArrayList<Poker>();
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getIsReady() {
		return isReady;
	}
	public void setIsReady(int isReady) {
		this.isReady = isReady;
	}
	public int getIsLandLord() {
		return isLandLord;
	}
	public void setIsLandLord(int isLandLord) {
		this.isLandLord = isLandLord;
	}
	public Player(String playerName) {
		this.handslist = LandlordReg.getPokers();
		this.playerName = playerName;
	}
	public void pointSort(){
		Collections.sort(handslist,new SequenceSort());
	}
	public void showPokers(){
		if(handslist == null || handslist.size() == 0){return ;}
		System.out.println(handslist);
	}
	
	public boolean isMyturn() {
		return myturn;
	}
	public void setMyturn(boolean myturn) {
		this.myturn = myturn;
	}
	public boolean isVictory(){
		if(handslist != null && handslist.size() ==0){
			return true;
		}
		return false;
	}
	public void play(Poker p){
		outlist.add(p);
		handslist.remove(p);
		
//		isVictory();
	}
	public boolean send(Player player){
		if(inlist.size()==0){
			Type type = TypeValidation.validate(outlist);
			if(type==null){System.out.println("illegal cards:"+outlist); return false; }
			System.out.println(this.playerName+" send cards:"+outlist.toString());
			player.revieve(outlist);
		}else{
			Type type = TypeValidation.validate(inlist);
			if(!type.validate(outlist)){System.out.println("illegal cards:"+outlist.toString());return false;}
			type.setList(outlist);
			if(!type.bigger(inlist)){
				System.out.println("not bigger enough!");
				return false; 
			}
			player.revieve(outlist);
		}
		return true;
	}
	public boolean revieve(List<Poker> list){
		this.inlist.addAll(list);
		this.setMyturn(true);
		System.out.println(this.playerName+" recieve list:"+ list);
		return true;
	}
	public boolean afterSend(){
		this.myturn = false;
		outlist.clear();
		return true;
	}
}
