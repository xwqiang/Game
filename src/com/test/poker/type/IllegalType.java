package com.test.poker.type;

import java.util.List;

import com.test.poker.Poker;
import com.test.poker.type.exception.IllegalTypeException;
/**
 * 不合法出牌
 * @author 1207264
 *
 */
public class IllegalType extends Type {
	public IllegalType(){
		name = Type.illegal;
	}
	@Deprecated
	@Override
	public boolean bigger(Type type) throws IllegalTypeException {
		throw new IllegalTypeException("不合法出牌");
	}

	@Override
	public boolean validate(List<Poker> list) {
		return false;
	}
}
