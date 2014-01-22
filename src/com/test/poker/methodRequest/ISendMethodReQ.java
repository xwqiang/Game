package com.test.poker.methodRequest;

import com.test.poker.regular.Player;

public interface ISendMethodReQ {

	public abstract boolean beforeSend(Player reciever);

	public abstract boolean afterSend();

	public abstract boolean send(Player reciever);

}