package com.thzhima.advance.util;

import java.util.concurrent.TimeUnit;

public abstract class MyAbstractLinkedBlockingQueue<E> extends MyLinkedList implements MyBlockingQueue<E>{

	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(E e) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E take() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(E e, long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E poll(long time, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}


