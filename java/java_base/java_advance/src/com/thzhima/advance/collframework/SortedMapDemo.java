package com.thzhima.advance.collframework;

import java.util.Comparator;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		Comparator cpr = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareToIgnoreCase(o1);
			}
		};
		TreeMap<String, Integer> map = new TreeMap<>(cpr);
		
		map.put("Js", 1);
		map.put("Python", 2);
		map.put("MySQL", 3);
		map.put("Java", 4);
		map.put("Redis", 5);
		map.put("python", 200);
		
		System.out.println(map);
		
		System.out.println(map.values());
	}
}
