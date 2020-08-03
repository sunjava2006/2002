package com.thzhima.base;

public class Operation {

	boolean aa;
	
	static boolean a() {
		System.out.println("a");
		return true;
	}
	
	static boolean b() {
		System.out.println("b");
		return false;
	}
	
	public static void main(String[] args) {
		if(Operation.b() && Operation.a()) {
			
		}
		
		char a = 1>0?'ÊÇ':'·ñ';
		System.out.println(a);
		System.out.println(Math.pow(2, 3));
		
		System.out.println("china" instanceof String);
		System.out.println(new Integer(1) instanceof Integer);
//		int a = 1;
		System.out.println(+1/4*4%2>>2&1);
	}
}
