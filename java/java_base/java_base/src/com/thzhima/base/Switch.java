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
			System.out.println("����֪");
		
		}
		
		Season spring = Season.SPRING;
		Season summer = Season.SUMMER;
		
		switch(Season.SPRING) {
		case SPRING:
			System.out.println("��������");
			break;
		case SUMMER:
			System.out.println("���ӷɻ����ˡ� ");
			break;
		case AUTUMN:
			System.out.println("���ӷ�����.");
			break;
		default:
			System.out.println("���Ӷ������ˡ�");
		}
		
		
	}
}
