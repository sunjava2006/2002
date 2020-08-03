package com.thzhima.homework;

import java.util.Arrays;

public class Array32 {

	public static void main(String[] args) {
		int[][][] a = new int[2][2][8];
		
		int[][] b = new int[4][8];
		
		int c = 1;
		for(int count=1, j=0;count<=2; count++) {
			
			for(int i=0;i<4; i++,j++) {
				
				b[i][j] = c++;
				System.out.println(i+","+j);
			}
		}
		
		
		for(int i[] : b) {
			System.out.println(Arrays.toString(i));
		}
		
		System.arraycopy(b[0], 0, a[0][0], 0, b[0].length);
		System.arraycopy(b[1], 0, a[0][1], 0, b[0].length);
		System.arraycopy(b[2], 0, a[1][1], 0, b[0].length);
		System.arraycopy(b[3], 0, a[1][0], 0, b[0].length);
		
	}
}
