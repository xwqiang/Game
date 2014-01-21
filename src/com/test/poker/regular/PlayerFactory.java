package com.test.poker.regular;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {
	private static final int PLAYMAXNUM = 3;
	private static List<Player> playlist = new ArrayList<Player>();
	public static Player get(String playerName) throws Exception{
		for(Player p : playlist){
			if(p.getPlayerName().equals(playerName)){
				return p;
			}
		}
		if(playlist.size()>= PLAYMAXNUM){
			throw new Exception("players is limited to "+ PLAYMAXNUM);
		}
		Player player = new Player(playerName);
		playlist.add(player);
		return player;
	}
	public static Player getTurn(){
		for(Player p : playlist){
			if(p.isMyturn()){
				return p;
			}
		}
		return null;
	}
}
