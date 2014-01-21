package com.test.poker;

public class PokerColor {
	public static enum COLOR{
		SPADE ,HEART ,CLUB ,DIAMOND
	}
	public static String show(PokerColor.COLOR color){
		switch(color){
		case SPADE: return "黑桃";
		case HEART: return "红心";
		case CLUB: return "梅花";
		case DIAMOND: return "方片";
		default: return "-1";
		}
	}
//	public static final int SPADE = 1;//����
//	public static final int HEART = 2;//����
//	public static final int CLUB = 3;//÷��
//	public static final int DIAMOND = 4;//��Ƭ
}
