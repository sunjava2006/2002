package com.thzhima.aop;


// ���г��󷽷����࣬��������Ϊ�����ࡣ
public abstract class Engine6G {
	
	private int maxLoad;

	public  void fire() {
		System.out.println("���������ɹ�........");
	}
	
	public abstract void run() ; // ���󷽷���û�з����壬������abstract���Ρ�
	
	public abstract void runPlus();
}