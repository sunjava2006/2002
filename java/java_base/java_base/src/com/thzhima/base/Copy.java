package com.thzhima.base;

import java.util.Arrays;

public class Copy {

	public static void main(String[] args) {
		int[] a = {10,20,30};
		int[] b = new int[10];
		System.arraycopy(a, 0, b, 3, 2);
		for(int i : b) {
			System.out.println(i);
		}
		
		System.out.println("----------------------------");
		int[] c = new int[a.length];
		System.arraycopy(a, 0, c, 0, a.length);
		
		for(int i : c) {
			System.out.println(i);
		}
		
		//=======================================
		
//		int[] d = Arrays.copyOf(a, 1);
		int[] d = Arrays.copyOfRange(a, 1, 3);
		System.out.println("---------------------");
		for(int i : d) {
			System.out.println(i);
		}
		System.out.println("-----------------------------");
		
		int[] e = new int[5];
		Arrays.fill(e, 10);
		for(int i : e) {
			System.out.println(i);
		}
	}

}
