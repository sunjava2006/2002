package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyLinkedBlockingQueue<E> extends MyAbstractLinkedBlockingQueue<E>{
	
	private int capacity;// ���еĳ��ȡ�
	
	public MyLinkedBlockingQueue(int length) {
		this.capacity = length;
		
		for(int i=1; i<=length; i++) {
			Node newNode = new Node();
			if(i==1) {
				this.first = newNode;
				this.last = newNode;
			}else {
				last.next = newNode;
				newNode.previous=last;
				last = newNode;
			}
		}
	}

	@Override
	public boolean offer(E e) {
		// ���������ˡ�ֱ�ӷ���
		if(this.capacity==this.size) {
			return false;
		}else {
			/**
			  * ͨ��size��ȷ����ǰ�ռ�Ľڵ㡣
			 */
			Node curr = first;
			for(int i=0; i<size; i++) {
				curr = curr.next;
			}
			curr.value = e;
			size++;
			return true;
		}
	}

	@Override
	public E poll() {
		if(size==0) {
			return null;
		}else {
			E value = (E) this.first.value;
			/*
			  * �� �׽ڵ㣬�ƶ��������β����
			 */
			this.first = this.first.next;
			first.previous.previous = last;
			last.next = first.previous;
			first.previous=null;
			last = last.next;
			last.next = null;
			
			size--;
			return value;
		}
	}

	@Override
	public E peek() {
		if(this.size==0) {
			return null;
		}
		return (E) this.first.value;
	}
	
	
	
	
	/**
	 *��������ӷ�������������û�пռ�ʱ��������ֱ��֪ͨ�пռ�Ϊֹ��
	 */
	@Override
	public void put(E e) throws InterruptedException {
		synchronized (this) {
			if(this.size==this.capacity) {
				
					this.wait();
					this.offer(e);
					
				
			}else {
				this.offer(e);
			}
		    this.notifyAll();
		}
	}
	
	

	@Override
	public E take() throws InterruptedException {
		E e = null;
		synchronized (this) {
			if(this.size()==0) {
				this.wait();
				e = this.peek();
				
			}else {
				e = this.poll();
			}
			this.notifyAll();
		}
		return e;
	}
	
	

	@Override
	public boolean offer(E e, long time, TimeUnit unit) throws InterruptedException {
		boolean ok = false;
		synchronized (this) {
			if(this.size==this.capacity) {
				long timeout = time;
				if(TimeUnit.SECONDS==unit) {
					timeout = time*1000;
				}
				this.wait(timeout);
				if(this.size<this.capacity) {
					this.offer(e);
					ok = true;
				}
			}else {
				this.offer(e);
				ok = true;
			}
			this.notifyAll();
		}
		return ok;
	}

	@Override
	public E poll(long time, TimeUnit unit) throws InterruptedException {
		E e = null;
		synchronized (this) {
			if(this.size>0) {
				e = this.poll();
			}
			else {
				long timeout = time;
				if(unit==TimeUnit.SECONDS) {
					timeout = time*1000;
				}
				this.wait(timeout);
				if(this.size>0) {
					e = this.poll();
				}
			}
			this.notifyAll();
		}
		return e;
	}

	public static void main(String[] args)   {
		MyLinkedBlockingQueue<String> lbq = new MyLinkedBlockingQueue<>(3);
	
		
		
		try {
			lbq.offer("a", 100, TimeUnit.MICROSECONDS);
			lbq.offer("b", 100, TimeUnit.MICROSECONDS);
			lbq.offer("c", 100, TimeUnit.MICROSECONDS);
			
			Thread t = new Thread(()->{
				try {
					Thread.sleep(50);
					String e = lbq.poll(100, TimeUnit.MICROSECONDS);
					System.out.println("take:" + e);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			t.start();
			
			lbq.offer("d", 100, TimeUnit.MICROSECONDS);
			
			t.join();
			
			Thread.sleep(1000);
			
			System.out.println(lbq.size());
			System.out.println(Arrays.toString(lbq.toArray()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
