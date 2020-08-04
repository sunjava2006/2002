package com.thzhima.except;

public class MyException extends Exception{

	MyException(String msg){
		super(msg);
	}
	
	
	public void todo()throws MyException{
		
	}
	
	public void to() {
		try {
			this.todo();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
