package com.thzhima.advance.util;

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
	
	public static void main(String[] args) {
		MyLinkedBlockingQueue<String> lbq = new MyLinkedBlockingQueue<>(6);
		
		System.out.println(lbq.offer("a"));
		System.out.println(lbq.offer("b"));
		System.out.println(lbq.offer("c"));
		System.out.println(lbq.offer("d"));
		System.out.println(lbq.offer("e"));
		System.out.println(lbq.offer("f"));
		System.out.println(lbq.offer("g"));
		
		System.out.println(lbq.size());
		
		System.out.println(lbq.peek());
		System.out.println(lbq.peek());
		System.out.println(lbq.peek());
		System.out.println(lbq.size());
		
		System.out.println("----------------------------------");
		System.out.println(lbq.poll());
		System.out.println(lbq.size());
		System.out.println(lbq.poll());
		System.out.println(lbq.size());
		System.out.println(lbq.poll());
		System.out.println(lbq.size());
		System.out.println(lbq.poll());
		System.out.println(lbq.size());
		System.out.println(lbq.poll());
		System.out.println(lbq.size());
		System.out.println(lbq.poll());
		System.out.println(lbq.size());
		System.out.println(lbq.poll());
		System.out.println(lbq.size());
		
	}
	
	
}
