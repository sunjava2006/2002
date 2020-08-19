package com.thzhima.advance.base;

@FunctionalInterface
public interface Flyable {

	public int a = 20;
	
	public abstract void todo();

	
	static void doing() {
		
	}
	
	default void a() {
		
	}
}
