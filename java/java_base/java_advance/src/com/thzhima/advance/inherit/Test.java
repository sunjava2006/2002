package com.thzhima.advance.inherit;

public class Test {

	public static void main(String[] args) {
		A.print();
		B.print();
		
		System.out.println(A.value);
		System.out.println(B.value);
		
		A a = new A();
		a.print();
		System.out.println(a.value);
		
		a = new B();
		a.print();
		System.out.println(a.value);
		System.out.println(a.value2);
		
		B b = new B();
		b.print();
		System.out.println(b.value);
		System.out.println(b.value2);
		
	}

}
