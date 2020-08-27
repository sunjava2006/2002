package com.thzhima.advance.thread;

public class MainThread {

	public static void main(String[] args) {
		Thread curr = Thread.currentThread();
		System.out.println(curr.getName());
		
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		};
		
		Runnable target = ()->System.out.print(Thread.currentThread().getName());
		Runnable target2 = ()->{for(int i=0;i<3;i++) 
		                       {System.out.println(Thread.currentThread().getThreadGroup().getName());}};
		
		ThreadGroup gp = new ThreadGroup("rescouceGp");
		
		Thread t2 = new Thread(gp, target2, "resourceThread");
		
		t.start();
		t2.start();
//		t2.stop();
//		gp.stop();
		
	}
}
