package com.thzhima.usualy;

public class StringSBTest {

	static final int count = 1000000;
	
	static void f1() {
		long start = System.currentTimeMillis();
		String s = "";
		for(int i=0;i<count;i++) {
			s+=i;
		}
		long end = System.currentTimeMillis();
		System.out.println("f1: "+ (end-start));
	}
	
	static void f2() {
		long start = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<count;i++) {
			sb.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("f2: "+ (end-start));
	}
	
	public static void main(String[] args) {
		f1();
//		f2();
	}
}
