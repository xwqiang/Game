package com.test.poker.type;

import java.util.List;

import com.test.poker.Poker;

public abstract class Type {
//	public static final int SINGLE = 1;//单
//	public static final int PAIR = 2;//双
//	public static final int TREBLE = 3;//三
//	public static final int BOMB = 4;//炸弹
//	public static final int fourWithTwo = 5;//四带二
//	public static final int SEQUENCE = 6;//单顺
//	public static final int SEQUENCE_DOUBLE = 6;//双顺
//	public static final int threeWith= 6;// 3 - 1
//	public static final int planeWith= 6; // 飞机 - 1
	
	List<Poker> list;
	public abstract boolean bigger(List<Poker> list);
	public abstract boolean validate(List<Poker> list);
	public List<Poker> getList() {
		return list;
	}
	public void setList(List<Poker> list) {
		this.list = list;
	}
	
}
