package com.thzhima.inherit;

public class Test {

	public static void main(String[] args) {
		
//		Animal a = new Animal();
//		a.eat();
//		
//		Human h =  new Human();
//		h.eat();
//		
//		a = h;
//		a.eat();
		
		Animal a = null;
		int r = (int)(Math.random()*10);
		
		if(r%2==0) {
			a = new Human();
		}
		else {
			a = new Dog();
		}
		
		a.eat();
		
		
	}

}
