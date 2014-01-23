package com.test.poker.type;


public class TypeWrapper {
	private Type pokerType ; 
	public TypeWrapper(Type type){
		this.pokerType = type;
	}
	public boolean biggerThan(Type inType){
		if(this.pokerType.getClass() != inType.getClass()){
			return diffTypeCompare(inType);
		}else{
			return this.pokerType.bigger(inType.getList());
		}
	}
	private boolean diffTypeCompare(Type inType){
		if(isBomb(this.pokerType) || isBomb(inType)){
			return this.pokerType.getWeight() > inType.getWeight();
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
