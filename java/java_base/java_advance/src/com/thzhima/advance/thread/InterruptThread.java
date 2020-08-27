package com.thzhima.advance.thread;

public class InterruptThread {

	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread() {
			
			public void run() {

				try {
					for (;;) {
						System.out.println(Thread.currentThread().getState());
//						Thread.sleep(1000);
						if(this.isInterrupted()) {// ������鵱ǰ�߳��Ƿ��������жϱ�ǡ�
							System.out.println("-------------"+this.interrupted());
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(Thread.currentThread().getName()+"��Ҫ����");
				}

			}
		};
		
		t.start();
		
		Thread.sleep(3000);
		
		t.interrupt(); // ���Ǵ���߳�
	}

}
