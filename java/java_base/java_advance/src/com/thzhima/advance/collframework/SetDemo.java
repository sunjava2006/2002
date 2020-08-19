package com.thzhima.advance.collframework;

import java.util.HashSet;
import java.util.Set;

import com.thzhima.advance.base.People;

public class SetDemo {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("java");
		set.add("python");
		set.add("c");
		set.add("C++");
		set.add("c");
		set.add("java");
		
		System.out.println(set.size());
		System.out.println(set);
	
		Set<People> setp = new HashSet<>();
		People p = new People("wang", 20, "male");
		People p1 = new People("wang", 30, "male");
		People p2 = new People("wang", 40, "male");
		People p3 = new People("wang", 20, "male");
		setp.add(p);
		setp.add(p2);
		setp.add(p3);
		setp.add(p1);
		
		System.out.println(setp.size());
	}
}
