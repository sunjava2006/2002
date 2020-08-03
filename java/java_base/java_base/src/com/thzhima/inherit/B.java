package com.thzhima.inherit;

public class B extends A {
	int b = 10;
	int b2;
	static int b3 = 90;
	
//	 void todo2() {
//			
//	}
	
//	@Override
	static void to() {
		System.out.println("B----static ----to");
	}
	
	
	static{
		System.out.println();
	}
	
	{
		System.out.println();
	}
	
	B(){
		super(); 
		b2 = 20;
	}
	
	B(int a2, int b2){
		super(a2);
		this.b2 = b2;
	}
	
	@Override
	void todo(){
		System.out.println("--------todo------");
	}
	
	public static void main(String[] args) {
		B bobj = new B();
		
		bobj.todo();
		
		A a = bobj;
//		a.todo();
		
	}
}
