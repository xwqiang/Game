package com.test.poker.regular;

import java.util.Comparator;

import com.test.poker.Poker;

public class SequenceSort implements Comparator<Poker>{

	@Override
	public int compare(Poker p1, Poker p2) {
		return p1.getPoint() > p2.getPoint() ? 1 : (p1.getPoint() < p2.getPoint() ? -1 : 0);
	}



}
