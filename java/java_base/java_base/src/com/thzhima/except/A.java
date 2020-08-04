package com.thzhima.except;

public class A {
	
	
	

	public static void main(String[] args) {
		
		try {
			int ran =(int)(Math.random()*10);
			
			int a = 2/ran;
			System.out.println(ran);
			
			System.out.println(a);
			
			
			
		}catch(ArithmeticException ex) {
			System.out.println(ex.getMessage());
			throw ex;
		}finally {
			System.out.println("--------------");
		}
		
		
	}
}
