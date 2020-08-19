package com.thzhima.advance.util;

import java.util.ListIterator;

/**
  *  列表接口，有个有序的数据集合。可以无限制的向这个集合中添加数据元素。
  *  添加的数据元素有序排列。
 * @author wangrui
 *
 * @param <E>
 */
public interface MyList<E> extends MyCollection<E>{
	
	/**
	  * 添加新元素到指定下标之前。如果idx大于size，只添加到最后。
	 * @param e
	 * @param idx
	 * @return
	 */
	boolean add(E e, int idx);
	
	
	/**
	  * 获取列表中指定索引的元素。
	 * @param idx
	 * @return 返回的元素。指定索引不存在返回null。
	 */
	E get(int idx);
	
	/**
	 * 删除指定索引的元素。
	 * @param idx
	 * @return 成功删除返回true,否则返回false。
	 */
	boolean remove(int idx);
	
//	ListIterator<E> listIterator();
	

}
