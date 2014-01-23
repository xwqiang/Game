package com.test.poker.game;

import com.test.poker.PokerPoint;
import com.test.poker.regular.Player;
import com.test.poker.regular.PlayerFactory;

public class GameCentre {
	public static void main(String[] args){
		Player jack = null;
		Player john = null;
		try {
			jack = PlayerFactory.get("jack");
			john = PlayerFactory.get("john");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		//jack.showPokers();
		jack.play(PokerPoint.THREE);
		jack.play(PokerPoint.THREE);
		jack.play(PokerPoint.THREE);
		jack.play(PokerPoint.FOUR);
		jack.play(PokerPoint.FOUR);
		jack.play(PokerPoint.FOUR);
//		jack.play(PokerPoint.SIX);
		jack.play(PokerPoint.FIVE);
		jack.play(PokerPoint.FIVE);
		jack.play(PokerPoint.FIVE);
		jack.send(john);
//		//jack.showPokers();
		
		System.out.println();
		
//		john.showPokers();
		john.play(PokerPoint.FOUR);
		john.play(PokerPoint.FOUR);
		john.play(PokerPoint.FOUR);
		john.play(PokerPoint.FIVE);
		john.play(PokerPoint.FIVE);
		john.play(PokerPoint.FIVE);
		john.play(PokerPoint.SIX);
		john.play(PokerPoint.SIX);
		john.play(PokerPoint.SIX);
		john.send(jack);
//		john.showPokers();
		
		System.out.println();
		
		//jack.showPokers();
		jack.play(PokerPoint.Joker0);
		jack.play(PokerPoint.Joker1);
		jack.send(john);
		//jack.showPokers();
		
		System.out.println();
	}
}
