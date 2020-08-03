package com.thzhima.oop;

public class A {

	 int a = 80;
	
	 void todo() {
		int a = 90;
		System.out.println(a);
		System.out.println(this.a);
	}
	 
	void todo2() {
		int a = 100;
		if(true) {
			int b = 200;
			System.out.println(a+b);
		}
//		System.out.println(a+b);
		
		int c;
//		System.out.println(c);
	}
	
	public static void main(String[] args) {
		A a1 = new A();
		a1.todo();
			
	}
	
}
