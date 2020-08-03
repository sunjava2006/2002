package com.thzhima.oop;

public class ParamTransform {

	void f(int arg) {
		System.out.println("-----------"+ arg);
		arg = 100;
		System.out.println("==========="+arg);
	}
	
	void f2(final People p) {
		System.out.println("--------------"+p.age);
		p.age = 100;
//		p = null;
		System.out.println("=============="+p.age);
	}
	
	
	long sum(long a, long b, long...c) {
		long sum = a+b;
		for(long i : c) {
			sum+=i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ParamTransform p = new ParamTransform();
		int a = 1;
		p.f(a);
		
		System.out.println(a);
		//==========================
		
		People people = new People("1990-2-2", "F", "Wang", 178,90,20);
		
		p.f2(people);
		
		System.out.println(people.age);
		
		long c = p.sum(1, 2, 3, 4,5);
		System.out.println(c);
		
		
	}
}
