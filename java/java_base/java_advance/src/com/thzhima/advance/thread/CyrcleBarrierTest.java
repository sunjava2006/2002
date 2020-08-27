package com.thzhima.advance.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyrcleBarrierTest {

	public static void main(String[] args) throws InterruptedException {
		
		CyclicBarrier cb = new CyclicBarrier(2 , ()->{System.out.println("-------");}) ;
		
		Runnable target = ()->{
			System.out.println(Thread.currentThread().getName()+"-----------------");
			try {
				cb.await();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			System.out.println(Thread.currentThread().getName()+"=================");
		};
		
		for(int i=0;i<2;i++) {
			Thread t = new Thread(target);
			Thread t2 = new Thread(target);
			t.start();
			t2.start();
			t.join();
			t2.join();
		}
		
	}
}
