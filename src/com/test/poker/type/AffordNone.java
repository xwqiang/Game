package com.test.poker.type;

import java.util.List;

import com.test.poker.Poker;
/**
 * 要不起
 * @author 1207264
 *
 */
public class AffordNone extends Type {
	public AffordNone(){
		name = Type.affordNone;
	}
	@Override
	public boolean bigger(List<Poker> inList) {
		return false;
	}

	@Override
	public boolean validate(List<Poker> list) {
		if(list != null && list.size() == 0){return true;}
		return false;
	}
}
