package com.thzhima.advance.thread.notifywait;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
		List<Object> list = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException {
		
		Demo1 demo = new Demo1();
		
		
		Thread t = new Thread(()->{
			try {synchronized (demo.list) {
				System.out.println("等");
				demo.list.wait(); // 解锁list.并进入休眠。
				
				System.out.println("买");
				
				Object o = demo.list.remove(demo.list.size()-1);
				System.out.println(o);
				
			}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t.start();
		
		Thread.sleep(3000);
		synchronized (demo.list) {
			demo.list.add(new Object());
			System.out.println("有货了");
			demo.list.notifyAll();
		}
		
	}
}
