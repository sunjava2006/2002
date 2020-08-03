package com.thzhima.inner;

public class A {

	static int a = C.c;
	B b = new B();
	static int a2 = C.c;

	class B {
		int b = a;
	}

	static class C {
		static int c = 9;
		int c2 = a;
		static int c3 = a;

		static {
			System.out.println();
		}

		static void to() {

		}
	}
	
	void to() {
		class D{
			
		}
		
		D d = new D();
		C c = new C();
	}
	
//	A.to.D d = new D();
	
	
	//================================================

	public static void main(String[] args) {
		A.C c = new A.C();
		System.out.println(A.C.c);

		A a = new A();
		B b = a.new B();
	}
}
