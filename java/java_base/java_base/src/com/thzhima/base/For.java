package com.thzhima.base;

public class For {

	public static void main(String[] args) {
		int[] array = {10, 20, 30, 40, 50};
		
		for(int i =0;i<array.length;i++) {
			System.out.println(i+":"+array[i]);
		}
		
		for(int i : array) {
			System.out.println(i);
		}
	   
	
	}
}
