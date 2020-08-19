package com.thzhima.advance.collframework;

import java.util.List;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = new Vector<>();
		
		Thread t = new Thread() {
			public void run() {
				for(int i=1;i<=10000;i++) {
					list.add(i);
				}
				System.out.println("t添加完成");
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for(int i=1;i<=10000;i++) {
					list.add(i);
				}
				System.out.println("t2添加完成");
			}
		};
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println("list size :  "+list.size());
	}
}
