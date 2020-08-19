package com.thzhima.advance.inherit;

public class C {

	int a = 90;
	
	int add(int a, int b) {
		
		return a+b;
	}
	
	public static void main(String[] args) {
		C c = new C();
		System.out.println(c.a);

		int result = c.add(1,4);
		int value = result<<2;
		
	}
}
