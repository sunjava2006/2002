package com.thzhima.base;

import java.util.Date;

public class ArrayClone {

	public static void main(String[] args) {
		
		int[] a = {10,20,30};
		
		int[] b = a.clone(); // Ç³¸´ÖÆ
		
		a[0] = 90;
		
		System.out.println(a==b);
		for(int i: a) {
			System.out.print(i + ",");
		}
		System.out.println();
		for(int i: b) {
			System.out.print(i + ",");
		}
		System.out.println();
		//===========================================
		String[] s = {"Java", "Python", "C"};
		String[] ss = s.clone();
		s[0] = "C#";
		for(String i : s) {
			System.out.print(i+",");
		}
		System.out.println();
		for(String i : ss) {
			System.out.print(i+",");
		}
		System.out.println();
		//===============================================
		Date[] d = {new Date(90,4,3), new Date(90,4,3)};
		Date[] dd = d.clone();
		d[0].setYear(80);
		for(Date i : d) {
			System.out.print(i + ",");
		}
		System.out.println();
		for(Date i : dd) {
			System.out.print(i + ",");
		}
	}
}
