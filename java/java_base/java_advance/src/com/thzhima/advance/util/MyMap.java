package com.thzhima.advance.util;

public interface MyMap<K,V> {

	/**
	 * ���Key-Value��Map�С�
	 * @param key
	 * @param val
	 * @return
	 */
	V put(K key, V val);
	
	/**
	 * ����key����ȡvalueֵ��
	 * @param key
	 * @return ���key�����ڷ���null��
	 */
	V get(K key);
	
	/**
	 * ��ȡMap�Ĵ�С��
	 * @return
	 */
	int size();
	
	/**
	 * ����key����ȡvalueֵ������map��ɾ����һ�����ݡ�
	 * @param key
	 * @return
	 */
	V remove(K key);
	
	/**
	 * ����map������key����ļ���
	 * @return
	 */
	MyCollection<K> keys();
	
	/**
	 * ����map������value����ļ���
	 * @return
	 */
	MyCollection<V> values();
	
	/**
	 * ����map������key-value�Եļ���
	 * @return
	 */
	MyCollection<Entry<K,V>> entries();
	
	/**
	 * �ж�map���Ƿ���o������Ϊkey.
	 * @param o
	 * @return �з���true,���򷵻�false��
	 */
	boolean containsKey(Object o);
	
	public static class Entry<K,V>{
		K key;
		V value;
		
		Entry(){
			
		}
		Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
	}
}
