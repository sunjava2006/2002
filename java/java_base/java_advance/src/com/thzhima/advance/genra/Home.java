package com.thzhima.advance.genra;
 
// �����޷���
public class Home<T extends Number, P> {

	T pet;
	P pet2;
	
	public P todo() {
		return null;
	}
	
	// ���ͷ���
	public <F> F  todo(F f) {
		return f;
	}
	
	public static void main(String[] args) {
		Home<Number, Integer> home = new Home<>();
		
		home.todo("ss");
	}
	
	

}
