package com.thzhima.advance.collframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.thzhima.advance.base.People;

public class SortedDemo {

	public static void main(String[] args) {
		
		People[] arr = new People[] {
		
		new People("Marry", 2, "female"),
		
		 new People("Marry", 2, "female"),
	
		new People("Marry", 23, "female"),
		
		new People("Tim", 2, "male"),
		
		new People("Smith", 6, "male"),
		
		new People("Peter", 9, "female")};
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
//		List<String> list = new ArrayList<>();
//		list.add("c");
//		list.add("b");
//		list.add("a");
//		
////		list.sort((a,b)->a.compareTo(b));
////		System.out.println(list);
//		
//		Collections.sort(list, (a,b)->b.compareTo(a));
//		System.out.println(list);
//		
//		Collections.reverse(list);
//		System.out.println(list);
		
		
	}
}
