package com.thzhima.base;

import java.util.Arrays;

public class MulArray {

	public static void main(String[] args) {
		
		int[][] a = new int[2][3];
		System.out.println(a.length);
		int[] a0 = a[0];
		System.out.println(a0.length);
		a0[0]=10;
		a0[1]=20;
		a0[2]=30;
		
		int[] a1= a[1];
		a1[0] = 40;
		a1[1] = 50;
		a1[2] = 60;
		
		a[0][0] = 100;
		a[0][1] = 200;
		
		System.out.println(Arrays.toString(a[0]));
		System.out.println(Arrays.toString(a[1]));
		
		//==================================
		int[][] b = new int[2][] ;
		b[0] = new int[3];
		b[1] = new int[]{20,30};
		/**
		 *  0, 0, 0,
		 *  20, 30
		 */
		int[][] c = new int[][] {{1,2},{3,4,5},{7}};
		System.out.println(c[1][1]);
		//====================================
		int[][][] d = new int[][][] {{{1,2},{3,4}},{{4,5}},{{6},{7,8},{9,10}}};
		System.out.println(d[1][0][1]);
		
		
		
	}
}


