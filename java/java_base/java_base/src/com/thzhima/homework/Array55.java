package com.thzhima.homework;

import java.util.Arrays;

public class Array55 {

	public static void main(String[] args) {
		int[][] a = new int[5][5];
		
		int count = 1;
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j]=count++;
			}
			System.out.println(Arrays.toString(a[i]));
		}
		
		int sum = 0;
		for(int i=0;i<a.length;i++) {
			sum += a[i][i];
		}
		System.out.println(sum);
		sum = 0;
		
		for(int i=0;i<a.length;i++) {
//			System.out.println(a[i][a.length-1-i]);
			sum += a[i][a.length-1-i];
		}
		System.out.println(sum);
	}
}
