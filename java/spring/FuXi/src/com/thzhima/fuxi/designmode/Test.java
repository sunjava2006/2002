package com.thzhima.fuxi.designmode;

public class Test {

	public static void main(String[] args) {
		Sun sun = Sun.getInstance();
		Sun sun2 = Sun.getInstance();
		Sun sun3 = Sun.getInstance();
		System.out.println(sun==sun2 && sun2==sun3);
		
	}
}
