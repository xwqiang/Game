package com.test.poker;

public class Poker {
	private int[] pt = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	private String[] _pt = {"A","2","3","4","5","6","7","8","9","10","J","Q","K","Joker0","Joker1"};
	private PokerColor.COLOR color;
	private int point;
	private int status;//0 未发牌 1 已发 2 弃牌
	public Poker(int point, PokerColor.COLOR color) {
		for(int i :pt){
			if(point == i){
				this.point = point;
				break;
			}
		}
		if(this.point ==0 ){
			try {
				throw new Exception("no such point " + point);
			} catch (Exception e) {
				System.exit(0);
				e.printStackTrace();
			}
		}
		this.color = color;
	}
	public PokerColor.COLOR getColor() {
		return color;
	}
	public void setColor(PokerColor.COLOR color) {
		this.color = color;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String toString(){
		return PokerColor.show(color) + _pt[point-1];
	}
	
}
