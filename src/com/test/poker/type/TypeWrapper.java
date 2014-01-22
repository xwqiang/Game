package com.test.poker.type;


public class TypeWrapper {
	private Type type ; 
	public TypeWrapper(Type type){
		this.type = type;
	}
	public boolean biggerThan(Type inType){
		if(this.type.getClass() != inType.getClass()){
			return diffTypeCompare(inType);
		}else{
			return this.type.bigger(inType.getList());
		}
	}
	private boolean diffTypeCompare(Type inType){
		if(isBomb(this.type) || isBomb(inType)){
			return this.type.getWeight() > inType.getWeight();
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
