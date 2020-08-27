package com.thzhima.advance.thread;

public class DemonThread {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread(()->{
			for(int i=0;i<10;i++) {
				System.out.println("---------------"+Thread.currentThread().getName());
				try {
					Thread.sleep(100); // �õ�ǰ�߳�����100���롣
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}) ;
		
		Thread mont = new Thread(()->{
			for(;;) {
				System.out.println(t.getState());
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
		}) ;
		mont.setDaemon(true); // ���ø��߳�Ϊ�ػ��߳�
		mont.start();
		
		Thread.sleep(10);
		
		t.start();
		
	}

}
