package com.test.poker;

public class Poker {
	private int[] ptInt = {
			PokerPoint.A ,PokerPoint.TWO,PokerPoint.THREE ,PokerPoint.FOUR,
			PokerPoint.FIVE,PokerPoint.SIX ,PokerPoint.SEVEN,PokerPoint.EIGHT,
			PokerPoint.NINE,PokerPoint.TEN,PokerPoint.J ,PokerPoint.Q ,PokerPoint.K ,
			PokerPoint.Joker0 ,PokerPoint.Joker1 
			};
	public static final int ready = 0;
	public static final int beforeSend = 2;
	private PokerColor.COLOR color;
	private int point;
	private int status;//0 已发牌 2 准备出牌 3 弃牌 
	public Poker(int point, PokerColor.COLOR color) {
		for(int i = 0 ; i < ptInt.length ; i++){
			if(point == ptInt[i]){
				this.point = point;
				break;
			}
		}
		if(this.point ==0 ){
			try {
				throw new Exception("no such point " + point);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
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
		return PokerColor.show(color) + PokerPoint.show(point);
	}
	
}
