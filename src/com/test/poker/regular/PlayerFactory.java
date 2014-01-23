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
	
	public static Player next(){
		PlayerIterator it = new PlayerIterator();
		return it.next();
	}
	public static Player now(){
		PlayerIterator it = new PlayerIterator();
		return it.now();
	}
	static class PlayerIterator{
		private Integer index = 0;
		private int MAX = playlist.size();
		
		public PlayerIterator(){
			for(int i = 0 ;i < playlist.size() ;i++){
				if(playlist.get(i).isLandLord()){
					index = i;
				}
			}
		}
		public Player next(){
			synchronized(index){
				index ++ ;
				if(index > MAX){index = 0;}
				
				return playlist.get(index);
			}
		}
		
		
		public Player previous(){
			synchronized(index){
				index--;
				if(index < 0) {index = MAX;};
				return playlist.get(index);
			}
		}
		public Player now(){
			return playlist.get(index);
		}
	}
}
