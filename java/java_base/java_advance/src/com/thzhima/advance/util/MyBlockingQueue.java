package com.thzhima.advance.util;

import java.util.concurrent.TimeUnit;

/**
 * 是个阻塞队列，其中存储的数据元素是一定的。
 * @author wangrui
 *
 * @param <E>
 */
public interface MyBlockingQueue<E> extends MyQueue<E>{

	/**
	 * 阻塞方法，向队列中添加元素。当队列中没有空间时阻塞。
	 * @param e
	 */
	void put(E e)throws InterruptedException;
	
	/**
	 * 阻塞方法，从队列头中取出元素。当队列为空时阻塞。
	 * @return
	 */
	E take()throws InterruptedException;
	
	
	/**
	 * 阻塞方法，向队列中添加元素。当队列中没有空间时阻塞。直到超时。
	 * @param e
	 * @param time
	 * @param unit
	 * @return
	 */
	boolean offer(E e, long time, TimeUnit unit)throws InterruptedException;
	
	/**
	 * 阻塞方法，从队列中取队列头元素。当队列为空间时阻塞。直到超时。
	 * @param time
	 * @param unit
	 * @return
	 */
	E poll(long time, TimeUnit unit)throws InterruptedException;
	
}
