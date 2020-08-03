package com.thzhima.oop.acc;

public class People {

	public String gender = "男"; // 公共的
	protected String name = "小张"; // 受保护的
	int age = 20;
	private int money = 5000; // 私有的
	
	public void todo() {
		System.out.println(this.age);
		System.out.println(this.name);
		System.out.println(this.gender);
		System.out.println(this.money);
	}
	
	
	
}
