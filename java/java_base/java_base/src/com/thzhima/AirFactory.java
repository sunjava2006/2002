package com.thzhima;

public class AirFactory {

	public static int pay(float capacity) {
		int sum = 0;
		if(capacity>=8) {//5-8
			int t = (int)(capacity/8);
			sum += t*500;
			capacity = capacity-t*8;
		}
		
		if(capacity<=5) {//1-5
			int t = (int)(capacity/5);
			sum += t*200;
			capacity = capacity-t*5;
		}
		
		if(capacity>=1) {//0.5-1
			int t = (int)(capacity/1);
			sum += t*50;
			capacity = capacity-t*1;
		}
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		System.out.println(AirFactory.pay(22));
	}
	
}
