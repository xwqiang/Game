package com.test.poker.game;

import com.test.poker.Poker;
import com.test.poker.PokerColor.COLOR;
import com.test.poker.regular.Player;
import com.test.poker.regular.PlayerFactory;

public class GameCentre {
	public static void main(String[] args){
		Player p1 = null;
		Player p2 = null;
		Player p3 = null;
		try {
			p1 = PlayerFactory.get("jack");
			p2 = PlayerFactory.get("john");
			p3 = PlayerFactory.get("miss");
		} catch (Exception e) {
			e.printStackTrace();
		}
		p1.play(new Poker(1,COLOR.CLUB));
		p1.play(new Poker(1,COLOR.HEART));
		p1.send(p2);
		p1.afterSend();
		
		p2.play(new Poker(2,COLOR.CLUB));
		p2.play(new Poker(2,COLOR.CLUB));
		p2.send(p1);
		p2.afterSend();
	}
}
