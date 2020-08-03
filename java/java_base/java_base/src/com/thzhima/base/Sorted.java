package com.thzhima.base;

import java.util.Arrays;

public class Sorted {

	public static void main(String[] args) {
		int[] a = {2,5,8,17,9,6,5};
		
		
		Arrays.sort(a); // 排序
		
		for(int i: a) {
			System.out.println(i);
		}
		System.out.println("------------------");
		
		int at = Arrays.binarySearch(a, 6); // 二分查找法。
		System.out.println(at);
		System.out.println("-----------------------");
		//===================================
		String[] s = {"e","d", "a", "b", "c","f"};
		Arrays.sort(s, (i,j)->j.compareTo(i) );
		
	    for(String i : s) {
	    	System.out.println(i);
	    }
	    
	    System.out.println(s);
	    System.out.println(Arrays.toString(s));
	}
}
