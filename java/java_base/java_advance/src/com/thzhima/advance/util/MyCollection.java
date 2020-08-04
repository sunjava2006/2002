package com.thzhima.advance.util;

/**
 * ���Ͻӿ�, ����һ���������ͣ������ڼ����д洢�������Ԫ��
 * 
 * @param <E> ���ڴ洢������Ԫ������
 * 
 * @author wangrui
 * @version 1.0
 * @date 2020-8-4
 * 
 */
public interface MyCollection<E> {

	/**
	  *  �򼯺������Ԫ��
	 * @param e ��ӵ�Ԫ��
	 * @return ��ӳɹ�����true,���򷵻�false.
	 */
	boolean add(E e);

	/**
	  * �Ӽ�����ɾ��ָ��Ԫ�ء�
	 * @param e ��Ҫɾ����Ԫ��
	 * @return ����������ָ��Ԫ�ز�ɾ������true�����򷵻�false��
	 */
	boolean remove(E e);

	/**
	  * ���ؼ��ϵĴ�С�����������ж��ٸ�Ԫ�ء�
	 * @return ���ϵĴ�С��
	 */
	int size();
}
