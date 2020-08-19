package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Iterator;

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

	
	/**
	 * 判断是否需要存储空间。如需要则扩展。
	 */
	private void increment() {
		if(!(this.values.length>this.size)) {
			E[] newArray = (E[])new Object[this.values.length+this.increment];
			System.arraycopy(this.values, 0, newArray, 0, this.values.length);
			this.values = newArray;
		}
	}
	
	
	@Override
	public boolean add(E e) {
		// 数组中没有空余空间
		this.increment();
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
		return this.size;
	}

	@Override
	public boolean add(E e, int idx) {
		if(idx > this.size) {
			this.add(e);
		}else {
			this.increment();
			for(int i=this.size-1; i>=idx; i--) {
				this.values[i+1] = this.values[i];
			}
			this.values[idx] = e;
			this.size++;
		}

		return true;
	}

	@Override
	public E get(int idx) {
		return this.values[idx];
	}

	@Override
	public boolean remove(int idx) {
		for(int i=idx+1; i<this.size; i++) {
			this.values[i-1] = this.values[i];
		}
		this.size--;
		return true;
	}
	
	

	@Override
	public Iterator<E> iterator() {
		
		return new Iterator() {
			private int idx = -1;
			
			@Override
			public boolean hasNext() {
				if(size==0) {
					return false;
				}else {
					return idx<size-1? true : false;
				}
				
			}

			@Override
			public Object next() {
				
				return MyArrayList.this.values[++idx];
			}
			
			@Override
			public void remove() {
				MyArrayList.this.remove(idx--);
			}
			
		};
	}
	
	
	public static void main(String[] args) {
		MyArrayList<Integer> li = new MyArrayList<>();
		for(int i=1;i<=10;i++) {
			li.add(i*10);
		}
		System.out.println(Arrays.toString(li.toArray()));
		
		for(int i : li) {
			System.out.print(i + ", ");
		}
		System.out.println("\n------------------------------");
		
		Iterator<Integer> itor = li.iterator();
		while(itor.hasNext()) {
			int i = itor.next();
			if(i==50) {
				itor.remove();
				System.out.println("50被删除。");
			}
		}
		
		System.out.println(Arrays.toString(li.toArray()));
	}
}
