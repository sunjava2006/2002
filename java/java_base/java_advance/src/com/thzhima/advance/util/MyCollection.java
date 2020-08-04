package com.thzhima.advance.util;

/**
 * 集合接口, 定义一个集合类型，可以在集合中存储多个数据元素
 * 
 * @param <E> 所在存储的数据元素类型
 * 
 * @author wangrui
 * @version 1.0
 * @date 2020-8-4
 * 
 */
public interface MyCollection<E> {

	/**
	  *  向集合中添加元素
	 * @param e 添加的元素
	 * @return 添加成功返回true,否则返回false.
	 */
	boolean add(E e);

	/**
	  * 从集合中删除指定元素。
	 * @param e 所要删除的元素
	 * @return 当集合中有指定元素并删除返回true，否则返回false。
	 */
	boolean remove(E e);

	/**
	  * 返回集合的大小，即集合中有多少个元素。
	 * @return 集合的大小。
	 */
	int size();
}
