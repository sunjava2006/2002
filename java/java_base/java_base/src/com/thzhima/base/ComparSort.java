package com.thzhima.base;

import java.util.Arrays;

public class ComparSort {

	public static void main(String[] args) {
		
		int[] a = {6,7,5,4,8,9,3,1,2};
		
		for(int i=0; i<a.length-1; i++) {
			
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
					
				}
			}
		}
		System.out.println(Arrays.toString(a));
		
	}
	
	// 1,2,3,4,5,11,7,8,9,10
}
