package com.thzhima.advance.thread.notifywait;

import java.util.ArrayList;
import java.util.List;

public class ProductConsumer {

	public static void main(String[] args) {
		final List<Integer> list = new ArrayList<>();
		
		
		Thread productor = new Thread(()->{
			int count = 1;
			try {
				while(true) {
					synchronized (list) {
						for(int i=0;i<10;i++) {
							System.out.format("生产了%d产品\n", count);
							list.add(count++);
							Thread.sleep(500);
						}
						list.notifyAll();
						list.wait();
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		productor.start();
		
		Thread consumer = new Thread(()->{
			try {
				while(true) {
					synchronized (list) {
						while(list.size()>0) {
							Integer i = list.remove(list.size()-1);
							System.out.println("消费了"+i+"产品");
							Thread.sleep(500);
						}
						list.notifyAll();
						list.wait();
					}
					
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		});
		
		consumer.start();
	}
}
