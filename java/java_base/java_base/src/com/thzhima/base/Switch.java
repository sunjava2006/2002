package com.thzhima.base;

public class Switch {

	public static void main(String[] args) {
		
		int ran = (int)(Math.random()*10);
		
		switch(ran%2) {
		case 0:
			System.out.println("even");
			break;
		case 1:
			System.out.println("odd");
			break;
		default:
			System.out.println("不可知");
		
		}
		
		Season spring = Season.SPRING;
		Season summer = Season.SUMMER;
		
		switch(Season.SPRING) {
		case SPRING:
			System.out.println("春天来了");
			break;
		case SUMMER:
			System.out.println("蚊子飞回来了。 ");
			break;
		case AUTUMN:
			System.out.println("蚊子飞走了.");
			break;
		default:
			System.out.println("蚊子躲起来了。");
		}
		
		
	}
}
