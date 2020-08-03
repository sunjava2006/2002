package com.thzhima.base;

public class Array {

	public static void main(String[] args) {
		
		int[] a = new int[5];// 创建int数组对象。并缺省初始化。
		System.out.println(a.length);
		
		a[0] = 10;
		a[1] = 20;
		a[4] = 50;
		System.out.println("a[1]+a[0]=" + (a[1]+a[0]));
		for(int i : a) {
			System.out.println(i);
		}
		
		String[] sarr = null;
		sarr = new String[] {"java", "c", "c++"};// 有初始值。
		
		float[] farr = {3.2F, 1.1F, 2.3F}; // 初始化，但中人能申明同时。
		
		System.out.println("sarr.length:" + sarr[-1]);
		
		int b = 90;
		
		
	}

}
