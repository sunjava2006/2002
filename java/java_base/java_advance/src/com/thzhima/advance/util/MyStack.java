package com.thzhima.advance.util;

import java.util.Arrays;

public class MyStack<E> extends MyLinkedList<E>{

	public boolean empty() {
		return this.size!=0 ? false: true;
	}
	
	public E push(E e) {
		this.add(e);
		return e;
	}
	
	public E peek() {
		return this.get(size-1);
	}
	
	public E pop() {
		E e = this.get(size-1);
		this.remove(size-1);
		return e;
	}
	
	int search(Object o) {
		int at = -1;
		int count = 1;
		Node curr = last;
		while(count<=size) {
			if(curr.value.equals(o)) {
				at = count;
				break;
			}
			curr = curr.previous;
			count++;
		}
		return at;
	}
	
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println(Arrays.toString(stack.toArray()));
		System.out.println(stack.search(50));
		System.out.println(stack.search(10));
		System.out.println(stack.search(40));
		System.out.println(stack.search(30));
		
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println("-----------------------------");
		while(!stack.empty()) {
			int v = stack.pop();
			System.out.println(v);
		}
	}
}
