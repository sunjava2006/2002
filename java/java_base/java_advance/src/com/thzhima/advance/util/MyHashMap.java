package com.thzhima.advance.util;

import java.util.Arrays;

public class MyHashMap<K,V> implements MyMap<K,V>{

	private static final int LENGTG= 16;
	private int size;
	private Node[] values = new Node[LENGTG];
	
	private int hash(Object o) {
		if(o==null) {
			return 0;
		}
		int hashCode = Math.abs(o.hashCode());
		return hashCode%LENGTG;
	}

	
	protected class Node<K,V>{
		MyMap.Entry<K, V> entry;
		Node next;
		
		Node(K key, V value, Node next){
			this.entry = new MyMap.Entry(key, value);
			this.next = next;
		}
	}
	
	/**
	 * 查询与指定key相同的节点
	 * @param key
	 * @return 节点，找不到返回null.
	 */
	private Node<K,V> getNode(K key){
		int idx = this.hash(key);
		Node first = this.values[idx];
		if(first==null) {
			return null;
		}else {
			Node is = null;
			Node curr = first;
			
			while(true){
				if(curr.entry.key.equals(key)) {
					is = curr;
					break;
				}
				if(curr.next!=null) {
					curr = curr.next;
				}else {
					break;
				}
			}
			
			return is;
		}
		
	}
	
	@Override
	public V put(K key, V val) {
		V v = null;
		int idx = this.hash(key);
		
		Node<K,V> first = this.values[idx];
		if(first==null) {// 添加的是头节点
			Node<K,V> newNode = new Node<>(key, val, null); 
			this.values[idx] = newNode;
		}else {
			Node<K,V> curr = first;
			
			while(true) {
				if(curr.entry.key.equals(key)) {
					/*
					 * 如果当前节点的key,与指定的key相等。
					 * 将原有的value替换。并返回原来的值。
					 */
					v = curr.entry.value;
					curr.entry.value = val;
					break;
				}
				if(curr.next!=null) {// 没有链表尾
					curr = curr.next;
				}else { // 当前节点已经是尾节点
					Node<K,V> newNode = new Node<>(key, val, null);
					curr.next = newNode;
					
					break;
				}
				
			}
		}
		
		size++;
		return v;
	}

	@Override
	public V get(K key) {
		Node<K, V> n = this.getNode(key);
		return n!=null? n.entry.value: null;
	}

	@Override
	public int size() {
		
		return this.size;
	}

	@Override
	public V remove(K key) {
		V v = null;
		int idx = this.hash(key);
		Node<K,V> first = this.values[idx];
		if(first!=null) {
			if(first.entry.key.equals(key) && first.next==null) {
				v = first.entry.value;
				this.values[idx]=null;
			}else if(first.entry.key.equals(key)){
				Node<K,V> t = first;
				this.values[idx]=first.next;
				t.next=null;
				
				v = t.entry.value;
				t = null;
						
			}else {
				Node<K,V> pre = first;
				Node<K,V> curr = first.next;
				while(!curr.entry.key.equals(key)) {
					pre = curr;
					curr = curr.next;
				}
				if(curr!=null) { // curr为当前节点
					if(curr.next==null) {// 是最后一个节点
						v = curr.entry.value;
						curr=null;
						pre.next = null;
					}else {
						v = curr.entry.value;
						pre.next = curr.next;
						curr.next = null;
						curr = null;
					}
				}
			}
			
		}
		size--;
		return v;
	}

	private MyCollection<Node<K,V>> getNodes(Node<K,V> first) {
		MyCollection<Node<K,V>> col = new MyArrayList<>();
		Node<K,V> curr = first;
		col.add(curr);
		while(curr.next!=null) {
			curr = curr.next;
			col.add(curr);
		}
		return col;
	}
	
	private MyCollection<Node<K,V>> allNodes(){
		MyCollection<Node<K,V>> col = new MyArrayList<>();
		for(int i=0; i<this.values.length; i++) {
			Node<K,V> first = this.values[i];
			if(first!=null) {
				MyCollection<Node<K,V>> itemCol = this.getNodes(first);
				for(Node<K,V> node : itemCol) {
					col.add(node);
				}
			}
			
		}
		return col;
	}
	
	@Override
	public MyCollection<K> keys() {
		
		MyCollection<K> col = new MyArrayList<>();
		for(Node<K,V> node : allNodes()) {
			col.add(node.entry.key);
		}
		return col;
	}

	@Override
	public MyCollection<V> values() {
		MyCollection<V> col = new MyArrayList<>();
		for(Node<K,V> node : allNodes()) {
			col.add(node.entry.value);
		}
		return col;
	}

	@Override
	public MyCollection<Entry<K, V>> entries() {
		MyCollection<Entry<K,V>> col = new MyArrayList<>();
		for(Node<K,V> node : allNodes()) {
			col.add(node.entry);
		}
		return col;
	}

	@Override
	public boolean containsKey(Object o) {
		
		Node n = getNode((K)o);
 		return n==null? false: true;
	}
	
	public static void main(String[] args) {
		MyHashMap<A, String> map = new MyHashMap<>();
		A a = new A(10,"china");
		A a2 = new A(10,"english");
		A a3 = new A(10,"java");
		A a4 = new A(10,"python");
		A a5= new A(10,"oracle");
		
		
		map.put(a, "CHINA");
		map.put(a2, "ENGLISH");
		map.put(a3, "JAVA");
		map.put(a4, "PYTHON");
		map.put(a5, "ORACLE");
		
//		System.out.println(map.get(a));
//		System.out.println(map.get(a5));
//		System.out.println(map.get(a3));
		
		System.out.println(map.remove(a));
		System.out.println(map.remove(a5));
		System.out.println(map.remove(a3));
		
		System.out.println(map.containsKey(a));
		System.out.println(map.containsKey(a2));
		
		Object[] array = ((MyArrayList)(map.keys())).toArray();
		System.out.println(Arrays.toString(array));
		
		map.put(null, null);
	}

}

class A {
	int hashCode;
	String key;
	
	A(int hashCode, String key){
		this.hashCode = hashCode();
		this.key = key;
	}
	
	public int hashCode() {
		return this.hashCode;
	}

	@Override
	public String toString() {
		return "A [hashCode=" + hashCode + ", key=" + key + "]";
	}
	
	
}

