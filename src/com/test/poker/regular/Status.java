package com.test.poker.regular;

public class Status {
	private final int intValue;
	private final String name;
	public static final Status begin = new Status(0,"begin");
	public static final Status end = new Status(1,"end");
	private Status(int intValue, String name) {
        this.name = name;
        this.intValue = intValue;
    }
	public String toString() {
        return name+"status code "+intValue;
    }
}
