package com.thzhima.advance.util;

public class Hash<E> {
	E[] values = (E[])new Object[16];
	
	private int hash(int hashCode) {
		return hashCode%16;
	}
	
	public void put(E e) {
		int idx = hash(Math.abs(e.hashCode()));
		this.values[idx] = e;
	}
	
	public E get(int hashCode) {
		int idx = hash(Math.abs(hashCode));
		return this.values[idx];
	}
	
	public static void main(String[] args) {
		Hash<String> h = new Hash<>();
		
		String s = "china";
		
		h.put(s);
		
		String s2 = h.get(s.hashCode());
		System.out.println(s2);
		
		h.put("Python");
		System.out.println(h.get("Python".hashCode()));
		
	}
}
