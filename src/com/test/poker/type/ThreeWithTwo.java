
package com.test.poker.type;
import java.util.Collections;
import java.util.List;

import com.test.poker.Poker;
import com.test.poker.util.SequenceSort;

public class ThreeWithTwo extends Type {
	public ThreeWithTwo(){
		name = Type.threeWithTwo;
	}
	@Override
	public boolean bigger(Type type) {
		List<Poker> inList = type.getList();
		if(getMain(this.list) > getMain(inList)){
			return true;
		}
		return false;
	}
	
	public int getMain(List<Poker> list) {
		Collections.sort(list,new SequenceSort());
		return list.get(2).getPoint();
	}

	@Override
	public boolean validate(List<Poker> list) {
		Collections.sort(list,new SequenceSort());
		if(list.size()==5 && list.get(0).getPoint()==list.get(1).getPoint()&&list.get(3).getPoint()==list.get(4).getPoint()){
			if(list.get(2).getPoint()==list.get(0).getPoint()||list.get(2).getPoint()==list.get(4).getPoint()){
				return true;
			}
		}
		return false;
	}
}
