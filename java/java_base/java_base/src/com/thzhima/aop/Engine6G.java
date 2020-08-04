package com.thzhima.aop;


// 含有抽象方法的类，必须申明为抽象类。
public abstract class Engine6G {
	
	private int maxLoad;

	public  void fire() {
		System.out.println("发动机点火成功........");
	}
	
	public abstract void run() ; // 抽象方法。没有方法体，必须用abstract修饰。
	
	public abstract void runPlus();
}