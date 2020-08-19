package com.thzhima.advance.collframework;

import java.util.Hashtable;
import java.util.Map;

public class HashtableMap {

	public static void main(String[] args) {
		Map<Integer, String> map = new Hashtable<>(); //new HashMap<>();
		
		map.put(1, "python");
		map.put(2, "java");
		map.put(3, "js");
		map.put(4, "c");
		
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		map.put(5, null);
	}
}
