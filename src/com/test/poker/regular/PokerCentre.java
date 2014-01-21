package com.test.poker.regular;

import java.util.ArrayList;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.PokerColor;
import com.test.poker.PokerPoint;

public class PokerCentre {
	private static List<Poker> pokers = new ArrayList<Poker>(){{
		add(new Poker(PokerPoint.A,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.A,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.A,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.A,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.TWO,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.TWO,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.TWO,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.TWO,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.THREE,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.THREE,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.THREE,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.THREE,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.FOUR,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.THREE,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.THREE,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.THREE,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.FIVE,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.FIVE,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.FIVE,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.FIVE,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.SIX,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.SIX,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.SIX,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.SIX,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.SEVEN,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.SEVEN,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.SEVEN,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.SEVEN,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.EIGHT,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.EIGHT,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.EIGHT,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.EIGHT,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.NINE,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.NINE,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.NINE,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.NINE,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.TEN,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.TEN,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.TEN,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.TEN,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.J,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.J,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.J,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.J,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.Q,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.Q,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.Q,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.Q,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.K,PokerColor.COLOR.HEART));
		add(new Poker(PokerPoint.K,PokerColor.COLOR.SPADE));
		add(new Poker(PokerPoint.K,PokerColor.COLOR.DIAMOND));
		add(new Poker(PokerPoint.K,PokerColor.COLOR.CLUB));
		
		add(new Poker(PokerPoint.Joker0,PokerColor.COLOR.CLUB));
		add(new Poker(PokerPoint.Joker1,PokerColor.COLOR.CLUB));
	}};
	private static List<Poker> pokerLeft = new ArrayList<Poker>();
	static{
		pokerLeft.addAll(pokers);
	};
	

	public static List<Poker> getPokerLeft() {
		return pokerLeft;
	}

	public static void setPokerLeft(List<Poker> pokerLeft) {
		PokerCentre.pokerLeft = pokerLeft;
	}

	public static Poker get(){
		int i = (int) (Math.random()*pokerLeft.size());
		return pokerLeft.remove(i);
	}
}
