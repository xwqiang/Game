package com.test.poker;

public class PokerPoint {
	public static final int A = 14 ;
	public static final int TWO = 16 ;
	public static final int  THREE = 3 ;
	public static final int  FOUR = 4 ;
	public static final int  FIVE = 5 ;
	public static final int  SIX = 6 ;
	public static final int  SEVEN = 7 ;
	public static final int  EIGHT = 8 ;
	public static final int  NINE = 9 ;
	public static final int  TEN  = 10 ;
	public static final int  J  = 11 ;
	public static final int  Q  = 12 ;
	public static final int  K  = 13 ;
	public static final int  Joker0  = 17 ;
	public static final int  Joker1 =18;
	
	public static String show(int point){
		switch(point){
			case A : return "A ";
			case TWO : return "2 ";
			case THREE : return "3 ";
			case FOUR : return "4 ";
			case FIVE : return "5 ";
			case SIX : return "6 ";
			case SEVEN : return "7 ";
			case EIGHT : return "8 ";
			case NINE : return "9 ";
			case TEN : return "10";
			case J : return "J ";
			case Q : return "Q ";
			case K : return "K ";
			case Joker0 : return "Joker0";
			case Joker1 : return "Joker1";
			default : return "-1";
		}
	}
}
