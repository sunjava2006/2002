package com.thzhima.advance.util;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
	
	private E[] values;  // 存储数据元素的数组
	private int size = 0; // 当前元素个数
	private int increment ;
	
	public MyArrayList() {
		this(16, 16);
	}
	
	public MyArrayList(int capacity) {
		this(capacity, 16);
	}
	
	public MyArrayList(int capacity, int increment) {
		values = (E[]) new Object[capacity]; 
		this.increment = increment;
	}

	E[] toArray() {
		return Arrays.copyOfRange(this.values, 0, size);
	}

	@Override
	public boolean add(E e) {
		// 数组中没有空余空间
		if(!(this.values.length>this.size)) {
			E[] newArray = (E[])new Object[this.values.length+this.increment];
			System.arraycopy(this.values, 0, newArray, 0, this.values.length);
			this.values = newArray;
		}
		this.values[this.size] = e;
		this.size++;
		return true;
	}

	@Override
	public boolean remove(E e) {
		boolean have = false;
		int idx = 0;
		for(; idx<this.size; idx++) {
			if(e==this.values[idx]) {
				have = true;
				break;
			}
		}
		if(have) {
			this.values[idx]=null;
			for(int i=idx+1; i<this.size;i++) {
				this.values[i-1]=this.values[i];
			}
			size--;
		}
			
		return have;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean add(E e, int idx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(int idx) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		MyArrayList<String> li = new MyArrayList<>(4,4);
		
		li.add("a");
		li.add("b");
		li.add("c");
		li.add("d");
		li.add("e");
		System.out.println(Arrays.toString(li.toArray()));
		li.remove("a");
		System.out.println(Arrays.toString(li.toArray()));
		li.remove("e");
		System.out.println(Arrays.toString(li.toArray()));
		li.remove("c");
		System.out.println(Arrays.toString(li.toArray()));
		
		
	}
}
