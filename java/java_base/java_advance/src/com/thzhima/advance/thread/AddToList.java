package com.thzhima.advance.thread;

import java.util.ArrayList;

public class AddToList {

	ArrayList<Object> list = new ArrayList();
	
	public synchronized void add(Object o) {
		list.add(o);
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		AddToList adl = new AddToList();
		
		
		Runnable target = ()->{
			for(int i=1;i<=100000;i++) {
				Object o = new Object();
				adl.add(o);
			}
		};
		
		Thread t = new Thread(target);
		Thread t2 = new Thread(target);
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		System.out.println(adl.list.size());
		
	}
}
