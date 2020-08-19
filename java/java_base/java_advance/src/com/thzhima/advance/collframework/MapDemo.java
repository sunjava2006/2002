package com.thzhima.advance.collframework;

import java.util.HashMap;
import java.util.Map;

import com.thzhima.advance.base.People;

public class MapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		
		map.put("python", 1);
		map.put("java", 2);
		map.put("c", 3);
		
		System.out.println(map.get("python"));
		System.out.println(map.get("c"));
		map.put("c", 5);
		System.out.println(map.get("c"));
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());
		
		map.put(null, 100);
		System.out.println(map.get(null));
		
		map.put("c--", null);
		System.out.println(map.get("c--"));
		
		
		Map<People, Integer> m = new HashMap<>();
		People p = new People("wang", 20, "male");
		People p1 = new People("wang", 30, "male");
		People p2 = new People("wang", 40, "male");
		People p3 = new People("wang", 20, "male");
		m.put(p, 1);
		m.put(p1, 2);
		m.put(p2, 3);
		m.put(p3, 4);
		
		System.out.println(m.size());
	}
}
