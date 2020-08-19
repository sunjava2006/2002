package com.thzhima.advance.inherit;

public class S {
	
	private int money = 10000;
	
	public int getMoney(int a ) {
		
		this.money-=a;
		return a;
	}
	
}

class BB extends S{
	
	
	void buy(int m) {
		
		this.getMoney(m);
	}
	
}