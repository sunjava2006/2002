package com.thzhima.interfaces;

public interface MyList {
	
	public static final int size = 0; // final公平 static公正 public公开
	

	
	public abstract void add() ; // public abstract 
	
	void remove();
	
	//--JDK8中新特性，默认方法
	default int size() {
		return size;
	}
	
	// JDK8中新特性，静态方法。
	static int a() {
		return 20;
	}
	
}
