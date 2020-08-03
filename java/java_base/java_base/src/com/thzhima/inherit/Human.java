package com.thzhima.inherit;

import java.util.Date;

public class Human extends Animal{
	
	public String name;
	public String food="米";
//	public String food = "肉";
	
	{
		System.out.println();
	}
	
	public void work() {
		System.out.println(this.name+"工作中..........");
	}
	
	@Override
	public void eat() {
		System.out.println("煮熟食物");
		super.eat();
	}
	
	public void eat(String name) {
		System.out.println("eat"+ name+".....");
	}
	
	public void run(String arg) {
		System.out.println("run"+arg+"..........");
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}
	
	public void like() {
		System.out.println(this.food+ super.food);
	}
	
	public static void main(String[] args) {
		
		Human man = new Human();
		man.gender = "Male";
		man.birthDate = new Date(95,2,3);
		man.name = "小红";
		man.weight = 90;
		
		man.run();
		man.eat();
		man.work();
		
		man.like();
		
		System.out.println(man.food);
		System.out.println(((Animal)man).food);
		
	}
	
}
