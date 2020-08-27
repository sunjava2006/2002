package com.thzhima.advance.thread;

public class InterruptThread {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread() {
			
			public void run() {

				try {
					for (;;) {
						System.out.println(Thread.currentThread().getState());
//						Thread.sleep(1000);
						if(this.isInterrupted()) {// 用来检查当前线程是否被设置了中断标记。
							System.out.println("-------------"+this.interrupted());
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(Thread.currentThread().getName()+"将要结束");
				}

			}
		};
		
		t.start();
		
		Thread.sleep(3000);
		
		t.interrupt(); // 就是打断线程
	}

}
