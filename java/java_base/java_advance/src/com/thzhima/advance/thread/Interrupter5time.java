package com.thzhima.advance.thread;

public class Interrupter5time {
	
   volatile	int i = 1;

	public static void main(String[] args) {
		final Interrupter5time i5 = new Interrupter5time();
		
		Runnable target = ()->{
			for(;i5.i<=10;i5.i++) {
				System.out.println("run+"+ i5.i +"itmes");
				if(Thread.interrupted()) {
					break;
				}
			}
		};
		Thread t = new Thread(target);
		t.start();
		
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					if(i5.i>=5) {
						t.interrupt();
						break;
					}
				}
			}
		};
		t2.start();
	}
}

abstract class  A extends Interrupter5time{
	
}