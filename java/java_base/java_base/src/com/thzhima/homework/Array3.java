package com.thzhima.homework;

import java.util.Arrays;

public class Array3 {

	public static void main(String[] args) {
		int[][][] a = new int[2][2][8];
		int count=1;
		int x1=0,y1=0, z1=0, x2=0,y2=1, z2=1,x3=1,y3=1,z3=2,x4=1,y4=0,z4=3; 
		for(int i=0; i<2; i++) {
			
			
			a[x1][y1][z1]=count++;
			a[x2][y2][z2]=count++;
			a[x3][y3][z3]=count++;
			a[x4][y4][z4]=count++;
			
			
			z1+=4;
			z2+=4;
			z3+=4;
			z4+=4;
		}
		
		for(int[][] i: a) {
			for(int[] j : i) {
				System.out.println(Arrays.toString(j));
			}
		}
	}
}
