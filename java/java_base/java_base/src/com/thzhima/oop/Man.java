package com.thzhima.oop;

public class Man {
	static String firstName;
	final String gender; 
	static String country;
	static int a = 20;
	static int b = a;
	
	static{ // ��̬����
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
		
		Man.firstName = "��";
		
		Man m = new Man();
		System.out.println(m.firstName); // ������
		Man.firstName = "��";
		
		Man m2 = new Man();
		System.out.println(m2.firstName);
		System.out.println(m.firstName); // ������
	}
}
