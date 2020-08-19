package com.thzhima.advance.base;

public class ForEach {

	public static void main(String[] args) {
		int[] array = {5,10, 15, 20};
		
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
		
		for(int i : array) {
			System.out.println(i);
		}
	}
}
