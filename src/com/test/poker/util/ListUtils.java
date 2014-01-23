package com.test.poker.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.poker.Poker;

public class ListUtils {
	/**
	 * key：点数 
	 * value：出现的次数 
	 * @param list
	 * @return
	 */
	public static Map<Integer,Integer> toMap(List<Poker> list) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(Poker p : list){
			int point = p.getPoint();
			if(map.containsKey(point)){
				map.put( point , map.get(point)+1);
			}else{
				map.put(point, 1);
			}
		}
		return map;
	}
	
	public static List<Integer> toListInt(List<Poker> list){
		if(list == null) {return null;}
		List<Integer> l = new ArrayList<Integer>();
		for(Poker p : list){
			l.add(p.getPoint());
		}
		return l;
	}
	
	public static boolean isSequence(List<Integer> list) {
		for(int i = 0 ; i < list.size() -1; i++){
			if(list.get(i)+1 != list.get(i+1)){
				return false;
			}
		}
		return true;
	}
}
