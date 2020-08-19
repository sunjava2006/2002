package com.thzhima.advance.util;

/**
 * ����һ�����нӿڡ�
 * @author wangrui
 *
 * @param <E>
 */
public interface MyQueue<E> {

	/**
	 * �����β�����Ԫ�ء�
	 * @param e
	 * @return ��ӳɹ�����true�����򷵻�fasle��
	 */
	boolean offer(E e);
	
	/**
	 * ���ز��Ƴ�����ͷ��Ԫ�ء�
	 * @return ����Ϊ�գ�����null��
	 */
	E poll();
	
	/**
	 * ���ض���ͷ��Ԫ�أ������Ƴ���
	 * @return ����Ϊ�գ�����null��
	 */
	E peek();
}
