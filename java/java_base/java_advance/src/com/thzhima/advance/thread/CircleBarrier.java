package com.thzhima.advance.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CircleBarrier {

	static int count = 1;
	public static void main(String[] args) throws InterruptedException {
		
		CyclicBarrier barrier = new CyclicBarrier(2, ()->{System.out.println("----");count++;});
		
		Runnable target = ()->{
			System.out.println(Thread.currentThread().getName()+"----------------------");
			try {
				barrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.println(Thread.currentThread().getName()+"======================");
		};
		
		for(;count<3;) {
			Thread t = new Thread(target);
			Thread t2 = new Thread(target);
			
			t.start();
			t2.start();
			t.join();
			t2.join();
		}
		
		
	}
}
