package com.test.poker.game;

import com.test.poker.regular.Player;
import com.test.poker.regular.PlayerFactory;

public class GameCentre {
	public static void main(String[] args){
		Player jack = null;
		Player john = null;
		Player yalin = null;
		try {
			jack = PlayerFactory.get("jack");
			jack.setLandLord(true);
			john = PlayerFactory.get("john");
			yalin = PlayerFactory.get("yalin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sender sender = new Sender();
		while(PlayerFactory.now().handSize() > 0){
			sender.setPlayer(PlayerFactory.now());
			sender.send(PlayerFactory.next());
		}
		System.out.println(PlayerFactory.now()+"win!!");
//		System.out.println(PlayerFactory.now().getPlayerName());
//		for(int i = 0 ; i< 13; i++){
//			System.out.println(PlayerFactory.next().getPlayerName());
//		}
		
		
		
		
		System.out.println();
	}
	
}
