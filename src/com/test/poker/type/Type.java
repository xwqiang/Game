package com.test.poker.type;

import java.util.ArrayList;
import java.util.List;

import com.test.poker.Poker;

public abstract class Type {
	/**
	 * 定义了类型的权值 用于不同类型的牌进行比较
	 */
	public static final int illegal = -1;// 单
	public static final int affordNone = 0;// 单
	public static final int single = 10;// 单
	public static final int pair = 20;// 双
	public static final int treble = 30;// 三
	public static final int bomb = 1000;// 炸弹
	public static final int kings = 2000;// 双王
	public static final int sequence = 80;// 单顺
	public static final int sequenceDouble = 90;// 双顺
	public static final int threeWithOne = 100;// 3 - 1
	public static final int threeWithTwo = 110;// 3 - 1
	public static final int planeWith = 120; // 飞机 - 1
	
	public int name = Type.illegal;
	public String player;
	List<Poker> list = new ArrayList<Poker>();

	public abstract boolean bigger(List<Poker> list) ;

	public abstract boolean validate(List<Poker> list);

	public List<Poker> getList() {
		return list;
	}

	public void cloneList(List<Poker> list) {
		this.list.addAll(list);
	}
	public int getWeight(){
		return name;
	}
	public String toString() {
		return this.list.toString();
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
}
