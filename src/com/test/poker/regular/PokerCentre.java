package com.test.poker.regular;

import java.util.ArrayList;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.PokerColor;
import com.test.poker.PokerPoint;

public class PokerCentre {
	private static List<Poker> pokers = new ArrayList<Poker>();
	private static List<Poker> pokerLeft = new ArrayList<Poker>();
	
	public PokerCentre(){
		pokers.add(new Poker(PokerPoint.A,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.A,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.A,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.A,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.TWO,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.TWO,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.TWO,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.TWO,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.THREE,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.THREE,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.THREE,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.THREE,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.FOUR,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.THREE,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.THREE,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.THREE,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.FIVE,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.FIVE,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.FIVE,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.FIVE,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.SIX,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.SIX,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.SIX,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.SIX,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.SEVEN,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.SEVEN,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.SEVEN,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.SEVEN,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.EIGHT,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.EIGHT,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.EIGHT,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.EIGHT,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.NINE,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.NINE,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.NINE,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.NINE,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.TEN,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.TEN,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.TEN,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.TEN,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.J,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.J,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.J,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.J,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.Q,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.Q,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.Q,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.Q,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.K,PokerColor.COLOR.HEART));
		pokers.add(new Poker(PokerPoint.K,PokerColor.COLOR.SPADE));
		pokers.add(new Poker(PokerPoint.K,PokerColor.COLOR.DIAMOND));
		pokers.add(new Poker(PokerPoint.K,PokerColor.COLOR.CLUB));
		
		pokers.add(new Poker(PokerPoint.Joker0,PokerColor.COLOR.NONE));
		pokers.add(new Poker(PokerPoint.Joker1,PokerColor.COLOR.NONE));
		
		pokerLeft.addAll(pokers);
	};
	

	public static List<Poker> getPokerLeft() {
		return pokerLeft;
	}

	public static void setPokerLeft(List<Poker> pokerLeft) {
		PokerCentre.pokerLeft = pokerLeft;
	}

	public Poker get(){
		int i = (int) (Math.random()*pokerLeft.size());
		return pokerLeft.remove(i);
	}
	public static void main(String[] a){
		PokerCentre c = new PokerCentre();
		Poker p = c.get();
		System.out.println(p+"....");
	}
}
