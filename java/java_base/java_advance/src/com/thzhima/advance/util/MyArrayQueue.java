package com.thzhima.advance.util;

public class MyArrayQueue<E> extends MyArrayList<E> implements MyQueue<E>{

	public MyArrayQueue() {
		super();
	}
	
	public MyArrayQueue(int capacity, int increment) {
		super(capacity, increment);
	}
	
	public MyArrayQueue(int capacity) {
		super(capacity);
	}
	
	public boolean hasElement() {
		return this.size()>0? true : false;
	}
	
	@Override
	public boolean offer(E e) {
		return this.add(e);
		
	}

	@Override
	public E poll() {
		E e = this.peek();
		if(null != e) {
			this.remove(0);
		}
		return e;
	}

	@Override
	public E peek() {
		if(this.hasElement()) {
			E e = this.get(0);
			return e;
		}else {
			return null;
		}
		
	}

}
