package com.thzhima.advance.util;

/**
 * 定义一个队列接口。
 * @author wangrui
 *
 * @param <E>
 */
public interface MyQueue<E> {

	/**
	 * 向队列尾部添加元素。
	 * @param e
	 * @return 添加成功返回true，否则返回fasle。
	 */
	boolean offer(E e);
	
	/**
	 * 返回并移除队列头的元素。
	 * @return 队列为空，返回null。
	 */
	E poll();
	
	/**
	 * 返回队列头的元素，但不移除。
	 * @return 队列为空，返回null。
	 */
	E peek();
}
