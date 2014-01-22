package com.test.poker.game;

import com.test.poker.Poker;
import com.test.poker.PokerPoint;
import com.test.poker.PokerColor.COLOR;
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
		jack.play(new Poker(PokerPoint.A,COLOR.CLUB));
		jack.play(new Poker(PokerPoint.A,COLOR.HEART));
		jack.play(new Poker(PokerPoint.A,COLOR.HEART));
		jack.send(john);
		
		john.play(new Poker(PokerPoint.TWO,COLOR.CLUB));
		john.play(new Poker(PokerPoint.TWO,COLOR.CLUB));
		john.play(new Poker(PokerPoint.TWO,COLOR.CLUB));
		john.send(jack);
	}
}
