package com.thzhima.oop;

public class Man {
	static String firstName;
	final String gender; 
	static String country;
	static int a = 20;
	static int b = a;
	
	static{ // 静态语句块
		System.out.println();
	}
	
	{
		System.out.println();
	}
	
	Man(){
		this.gender = "F";
	}
	
	static void sayFirstName() {
		System.out.println(country);
	}
	
	public static void main(String[] args) {
		
		Man.firstName = "黄";
		
		Man m = new Man();
		System.out.println(m.firstName); // 不建议
		Man.firstName = "王";
		
		Man m2 = new Man();
		System.out.println(m2.firstName);
		System.out.println(m.firstName); // 不建议
	}
}
