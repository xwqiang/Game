package com.test.poker.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.test.poker.Poker;
import com.test.poker.util.ListUtils;

public class Plane extends Type {
	public Plane(){
		name =Type.bomb;
	}
	@Override
	public boolean bigger(List<Poker> inList) {
		if(this.list.size() == inList.size() && validateType(this.list) == validateType(inList)){
			if(getSortedTrebleList(this.list).get(0) > getSortedTrebleList(inList).get(0)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean validate(List<Poker> list) {
		List<Integer> ll = getSortedTrebleList(list);
		Collections.sort(ll);
		return validateType(list) > 0 && ListUtils.isSequence(ll);
	}
	
	
	private List<Integer> getSortedTrebleList(List<Poker> list) {
		List<Integer> sortList = new ArrayList<Integer>();
		Map<Integer,Integer> map = ListUtils.toMap(list);
		for(int point : map.keySet()){
			if(map.get(point) >= 3){
				sortList.add(point);
			}
		}
		Collections.sort(sortList);//升序排列
		return sortList;
	}
	
	/**
	 * 校验牌的类型 百位数位3的个数 十位数位2的个数 各位位单的个数
	 * @param result
	 * @return
	 */
	private int validateType(List<Poker> list){
		int result = 0 ;
		Map<Integer,Integer> map = ListUtils.toMap(list);
		for(int times :map.values()){
			result += Math.pow(10, (times > 3 ? 3 : times) - 1);
		}
		
		if(result == 200){return 2;}//3带0								6张牌
		if(result == 220){return 2;}//3带两对								10张牌
		if(result == 202){return 2;}//3带两单								8张牌
		if(result == 210){return 2;}//3带两单		（一对）					8张牌
		//三连飞机
		if(result == 330){return 3;}//3带两单		（一对）					15张牌
		if(result == 303){return 3;}//3带两单		（一对）					12张牌
		if(result == 300){return 3;}//3带两单		（一对）					9张牌
		
		//四连飞机
		if(result == 440){return 4;}//4带4对 		（一对）					20张牌
		if(result == 404){return 4;}//4带4单		（一对）					16张牌
		if(result == 400){return 4;}//4带0		（一对）					12张牌
		
		//五连飞机
		if(result == 550){return 5;}//4带4对 		（一对）					25张牌
		if(result == 505){return 5;}//4带4单		（一对）					20张牌
		if(result == 500){return 5;}//4带0		（一对）					15张牌
		
		//6连飞机
		if(result == 600){return 6;}//4带4对 		（一对）					18张牌
		
		//7连飞机
		if(result == 700){return 7;}//4带4对 		（一对）					21张牌
		return -1;
	}
	
	public static void main(String[] a){
		List<Integer> sortList = new ArrayList<Integer>();
		sortList.add(123);
		sortList.add(12);
		sortList.add(1233);
		Collections.sort(sortList);
		System.out.println(sortList);
	}
}
