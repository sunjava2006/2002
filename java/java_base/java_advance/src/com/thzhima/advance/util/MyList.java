package com.thzhima.advance.util;

import java.util.ListIterator;

/**
  *  �б�ӿڣ��и���������ݼ��ϡ����������Ƶ�������������������Ԫ�ء�
  *  ��ӵ�����Ԫ���������С�
 * @author wangrui
 *
 * @param <E>
 */
public interface MyList<E> extends MyCollection<E>{
	
	/**
	  * �����Ԫ�ص�ָ���±�֮ǰ�����idx����size��ֻ��ӵ����
	 * @param e
	 * @param idx
	 * @return
	 */
	boolean add(E e, int idx);
	
	
	/**
	  * ��ȡ�б���ָ��������Ԫ�ء�
	 * @param idx
	 * @return ���ص�Ԫ�ء�ָ�����������ڷ���null��
	 */
	E get(int idx);
	
	/**
	 * ɾ��ָ��������Ԫ�ء�
	 * @param idx
	 * @return �ɹ�ɾ������true,���򷵻�false��
	 */
	boolean remove(int idx);
	
//	ListIterator<E> listIterator();
	

}
