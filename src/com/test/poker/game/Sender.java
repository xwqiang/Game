package com.test.poker.game;

import java.util.Scanner;

import com.test.poker.Poker;
import com.test.poker.regular.Player;

public class Sender {
	private Player player ;
	public void setPlayer(Player player){
		this.player = player;
	}
	public void send(Player reciever){
		Scanner sc = new Scanner(System.in);
		System.out.println(player.getPlayerName()+"的牌 【"+player.handSize()+"张】 为：\r\n"+player.showPokers());
		System.out.println(" [1]\t[2]\t[3]\t[4]\t[5]\t[6]\t[7]\t[8]\t[9]\t[10]\t[11]\t[12]\t[13]\t[14]\t[15]\t[16]\t[17]\t[18]\t[19]\t[20]\t[21]");
		System.out.println("按0出牌，9放弃出牌");
		int input=sc.nextInt();
		if(input != 0 && input!=9){
			System.out.println("不合法输入,请重新输入：");
		}
		switch(input){
			case 0 : 
				System.out.println("请选择您出牌的位置，用  , 号隔开,回车结束");
				String pokers = sc.next();
				System.out.println(pokers);
				for(String s : pokers.trim().split(",")){
					if(s != null && !s.equals("")){
						Poker poker = player.handslist.get(Integer.parseInt(s)-1);
						player.play(poker);
					}
				}
				player.send(reciever);
				break;
			case 9 :
				player.play(null);
				player.send(reciever);
				break;
		}
	}
//	private boolean isContinue(int i ){
//		if(i==1){ return true;}
//		return false;
//	}
	public void show(){
		System.out.println(player.getPlayerName()+"的牌为：\r\n"+player.showPokers());
		System.out.println(" [1]\t[2]\t[3]\t[4]\t[5]\t[6]\t[7]\t[8]\t[9]\t[10]\t[11]\t[12]\t[13]\t[14]\t[15]\t[16]\t[17]\t[18]\t[19]\t[20]\t[21]");
	}
}
