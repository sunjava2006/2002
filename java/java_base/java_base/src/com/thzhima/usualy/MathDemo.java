package com.thzhima.usualy;

import java.util.Random;

public class MathDemo {
	public static void main(String[] args) {
		System.out.println(Math.E);
		System.out.println(Math.PI);
		System.out.println(Math.abs(-23333));
		
		
		System.out.println(Math.random());
		System.out.println("================================");
		Random r = new Random(); //伪随机数类。 采用随机算法。只要种子一定。每次产生的随机数列是一样的。
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		
	}
}
