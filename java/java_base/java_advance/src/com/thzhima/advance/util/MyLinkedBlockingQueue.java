package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyLinkedBlockingQueue<E> extends MyAbstractLinkedBlockingQueue<E>{
	
	private int capacity;// 队列的长度。
	
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
		// 当队列满了。直接返回
		if(this.capacity==this.size) {
			return false;
		}else {
			/**
			  * 通过size来确定当前空间的节点。
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
			  * 把 首节点，移动到链表的尾部。
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
	 *阻塞的添加方法，当链表中没有空间时，阻塞。直到通知有空间为止。
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
