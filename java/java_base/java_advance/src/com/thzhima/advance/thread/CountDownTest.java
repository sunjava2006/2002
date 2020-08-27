package com.thzhima.advance.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownTest {

	public static void main(String[] args) {
		
		CountDownLatch latch = new CountDownLatch(2);
		
		Thread t = new Thread(()->{
			System.out.println("1---------------------");
			latch.countDown();
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("1=====================");
		});
		
		Thread t2 = new Thread(()->{
			System.out.println("2---------------------");
			latch.countDown();
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("2=====================");
		});
		
		t.start();
		t2.start();
	}
}
