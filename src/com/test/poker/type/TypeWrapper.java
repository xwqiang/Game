package com.test.poker.type;


public class TypeWrapper {
	private Type type ; 
	public TypeWrapper(Type type){
		this.type = type;
	}
	public boolean biggerThan(Type type){
		if(!isSameType(type)){
			return this.type.getWeight() > type.getWeight();
		}else{
			return type.bigger(type.getList());
		}
	}
	private boolean isSameType(Type type){
		return this.type.getClass()==type.getClass();
	}
}
