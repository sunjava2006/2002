package com.thzhima.advance.thread;

import java.util.concurrent.CountDownLatch;

public class CountDown {

	public static void main(String[] args) {
		CountDownLatch cdl = new CountDownLatch(2);
		
		Runnable target = ()->{
			System.out.println("1------------------");
			try {
				cdl.countDown();
				cdl.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("1===================");
		};
		Runnable target2 = ()->{
			System.out.println("2------------------");
			try {
				cdl.countDown();
				cdl.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("2===================");
		};
		
		Thread t = new Thread(target);
		Thread t2 = new Thread(target2);
		t.start();
		t2.start();
	}
}
