package com.thzhima.usualy;

import java.util.Random;

public class MathDemo {
	public static void main(String[] args) {
		System.out.println(Math.E);
		System.out.println(Math.PI);
		System.out.println(Math.abs(-23333));
		
		
		System.out.println(Math.random());
		System.out.println("================================");
		Random r = new Random(); //α������ࡣ ��������㷨��ֻҪ����һ����ÿ�β��������������һ���ġ�
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		
	}
}
