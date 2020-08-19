package com.thzhima.advance.util;

import java.util.concurrent.TimeUnit;

/**
 * �Ǹ��������У����д洢������Ԫ����һ���ġ�
 * @author wangrui
 *
 * @param <E>
 */
public interface MyBlockingQueue<E> extends MyQueue<E>{

	/**
	 * ��������������������Ԫ�ء���������û�пռ�ʱ������
	 * @param e
	 */
	void put(E e)throws InterruptedException;
	
	/**
	 * �����������Ӷ���ͷ��ȡ��Ԫ�ء�������Ϊ��ʱ������
	 * @return
	 */
	E take()throws InterruptedException;
	
	
	/**
	 * ��������������������Ԫ�ء���������û�пռ�ʱ������ֱ����ʱ��
	 * @param e
	 * @param time
	 * @param unit
	 * @return
	 */
	boolean offer(E e, long time, TimeUnit unit)throws InterruptedException;
	
	/**
	 * �����������Ӷ�����ȡ����ͷԪ�ء�������Ϊ�ռ�ʱ������ֱ����ʱ��
	 * @param time
	 * @param unit
	 * @return
	 */
	E poll(long time, TimeUnit unit)throws InterruptedException;
	
}
