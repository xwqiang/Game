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
		
		jack.showPokers();
		jack.play(PokerPoint.THREE);
		jack.play(PokerPoint.THREE);
		jack.play(PokerPoint.THREE);
		jack.send(john);
		jack.showPokers();
		
		System.out.println();
		
		john.showPokers();
		john.play(PokerPoint.TWO);
		john.play(PokerPoint.TWO);
		john.play(PokerPoint.TWO);
		john.send(jack);
		john.showPokers();
		
		System.out.println();
		
		jack.showPokers();
		jack.play(PokerPoint.SIX);
		jack.play(PokerPoint.SIX);
		jack.play(PokerPoint.SIX);
		jack.send(john);
		jack.showPokers();
		
		System.out.println();
	}
}
