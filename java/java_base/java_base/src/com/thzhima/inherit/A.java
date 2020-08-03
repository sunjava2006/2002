package com.thzhima.inherit;

public  class A {

	int a = 90;
	int a2;
	static int a3 = 90;
	
	final void todo2() {
		
	}
	
	static void to() {
		System.out.println("A----static ----to");
	}
	
	static{
		System.out.println();
	}
	
	{
		System.out.println();
	}
	
	public A() {
		System.out.println();
	}
	
	public A(int a2) {
		a2 = a2;
	}
	
	  void todo() {
		System.out.println("--to------do------");
	}
	
	public static void main(String[] args) {
		A  a = new B();
		a.todo();
		
		a.to();
	}
	
	
}
