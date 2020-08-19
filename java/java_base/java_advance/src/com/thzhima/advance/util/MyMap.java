package com.thzhima.advance.util;

public interface MyMap<K,V> {

	/**
	 * 添加Key-Value到Map中。
	 * @param key
	 * @param val
	 * @return
	 */
	V put(K key, V val);
	
	/**
	 * 根据key，获取value值。
	 * @param key
	 * @return 如果key不存在返回null。
	 */
	V get(K key);
	
	/**
	 * 获取Map的大小。
	 * @return
	 */
	int size();
	
	/**
	 * 根据key，获取value值，并从map中删除这一对数据。
	 * @param key
	 * @return
	 */
	V remove(K key);
	
	/**
	 * 返回map中所有key对象的集合
	 * @return
	 */
	MyCollection<K> keys();
	
	/**
	 * 返回map中所有value对象的集合
	 * @return
	 */
	MyCollection<V> values();
	
	/**
	 * 返回map中所有key-value对的集合
	 * @return
	 */
	MyCollection<Entry<K,V>> entries();
	
	/**
	 * 判断map中是否有o对象做为key.
	 * @param o
	 * @return 有返回true,否则返回false。
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
