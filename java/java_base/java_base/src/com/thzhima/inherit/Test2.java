package com.thzhima.inherit;

public class Test2 {

	public static void main(String[] args) {
		
		Animal a = new Human();
		a.run();
		
		Human h = (Human) a ;
		h.work();
		
		h.run();
		h.run("С·");
	}

}
