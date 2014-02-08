package com.test.poker.type;

import com.test.poker.type.exception.IllegalTypeException;


public class TypeWrapper {
	private Type pokerType ; 
	public TypeWrapper(Type type){
		this.pokerType = type;
	}
	public boolean biggerThan(Type inType) throws IllegalTypeException{
		if(inType.name == Type.illegal || pokerType.name == Type.illegal){
			throw new IllegalTypeException("不合法出牌");
		}
		//没人要的起
		if(pokerType.getPlayer().equals(inType.getPlayer())){System.out.println("继续出牌。。");return true;}
		
		if(this.pokerType.getClass() != inType.getClass()){	//不同类型的比较
			return diffTypeCompare(inType);
		}else{	//同类型的比较
			return this.pokerType.bigger(inType);
		}
	}
	private boolean diffTypeCompare(Type inType){
		if(isBomb(this.pokerType) || isBomb(inType)){
			return this.pokerType.getWeight() > inType.getWeight();
		}
		if(inType.name == Type.affordNone){
			return true;
		}
		if(this.pokerType.name == Type.affordNone){
			return false;
		}
		return false;
	}
	private boolean isBomb(Type t){
		if(t.getWeight() == Type.kings || t.getWeight() == Type.bomb){
			return true;
		}
		return false;
	}
}
