package com.thzhima.advance.thread;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()->{System.out.println("hello");});
		
		t.start();
		
		
		Thread.sleep(3000);
		System.out.println("主线程结束");

	}

}
