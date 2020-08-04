package com.thzhima.advance.gen;

// ·ºÐÍ
public class Home<T> {

	T pet;
	
	Home(T pet){
		this.pet = pet;
	}
	
	T getPet() {
		return this.pet;
	}
	
	public static void main(String[] args) {
		Dog d = new Dog();
		Home<Dog> h = new Home<Dog>(d);
		
		Dog pet = h.getPet();
		
		
		//--------------------------------
		
		Home<Cat> h2 = new Home<>(new Cat());
		Cat c = h2.getPet();
		
		
		Home h3 = new Home(new Object());
		
		
	}
	
}
