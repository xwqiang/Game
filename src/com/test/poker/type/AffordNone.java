package com.test.poker.type;

import java.util.List;

import com.test.poker.Poker;
import com.test.poker.regular.Player;
/**
 * 要不起
 * @author 1207264
 *
 */
public class AffordNone extends Type {
	public AffordNone(Player player){
		this.player = player.getPlayerName();
		name = Type.affordNone;
	}
	public AffordNone(){
		name = Type.affordNone;
	}
	@Override
	public boolean bigger(Type type) {
		return this.time > type.time;
	}

	@Override
	public boolean validate(List<Poker> list) {
		if(list != null && list.size() == 0){return true;}
		return false;
	}
}
