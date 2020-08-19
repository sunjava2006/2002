package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Iterator;


public class MyLinkedList<E> implements MyList<E> {
	
	protected Node first;
	protected Node<E> last;
	protected int size; // 存储列表中元素的个数。只提供了读取的方法。使之成为只读属性。
	
	protected  class Node<E>{
		E value;
		Node<E> previous;
		Node<E> next;
		
		Node(){
			
		}
		
		Node(E value, Node previous, Node next){
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
	}
	

	Object[] toArray() {
		Object[] array = new Object[this.size];
		Node<E> curr = first;
		for(int i=0;i<size; i++) {
			array[i]=curr.value;
			curr = curr.next;
		}
		return array;
	}
	
	@Override
	public boolean add(E e) {
		if(this.size==0) { // 当为列表中添加第一个元素时
			/*
			 *这个节点没有前节点，没有后节点。节点的previous、next都为null。
			 *这个节点是链表中唯一节点。因此first、last指针都指向它。 
			 */
			Node newNode = new Node(e, null, null);
			this.first = newNode;
			this.last = newNode;
		}else {// 向链表中尾节点之后添加新节点。
			/*
			 * 1、这个新添加节点，previous要指向当前的尾节点。next为null。
			 * 2、当前尾节点的next指针，指向这个新节点。 通过1、2两步将新节点与链表实现双向挂载。
			 * 3、使新添加节点，为链表中的尾节点。
			 */
			Node newNode = new Node(e, last, null);
			this.last.next = newNode;
			this.last = newNode;
		}
		
		size++;
		return true;
	}

	@Override
	public boolean remove(E e) {
		/*
		 * 从头遍历链表，找到与参数相等的节点。获取该节点的索引。
		 */
		Node<E> curr = first;
		int i=0;
		for(; i<size; i++) {
			if(curr.value.equals(e)) {
				break;
			}
			curr = curr.next;
		}
		// 通过索引删除节点。
		return this.remove(i);
		
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean add(E e, int idx) {
		if(idx<=0) {
			Node newNode = new Node(e, null, first);
			first.previous = newNode;
			first = newNode;
		}else if(idx >= size) {
			Node newNode = new Node(e, last, null);
			this.last.next = newNode;
			this.last = newNode;
			
		}else {
			Node current = first;
			for(int i=0;i<idx; i++) {
				current = current.next;
			}
			Node newNode = new Node(e, current.previous, current);
			current.previous.next = newNode;
			current.previous = newNode;
		}
		
		size++;
		return true;
	}

	@Override
	public E get(int idx) {
		// 如果下标超出了链表范围，直接返回null。
		if(idx>=size || idx<0) {
			return null;
		}else {
			/**
			 * 查找到指定下标的节点。current是一个从首节点向后移动的游标。
			 * 要第n个节点，就向后移动n次。返回这个节点中元素的值。
			 */
			Node<E> current = first;
			for(int i=0; i<idx; i++) {
				current = current.next;
			}
			return current.value;
		}
		
	}

	@Override
	public boolean remove(int idx) {
		if(idx>=size || idx<0) {
			return false;
		}else {
			if(0 == idx) {//删除首节点
				if(this.first.next!=null) {
					this.first = this.first.next;
					this.first.previous.next = null;
					this.first.previous = null;
				}else {//只有唯一一个首节点时
					this.first=null;
					this.last = null;
				}
				
			}else if(this.size-1 == idx) {//删除尾节点
					this.last = this.last.previous;
					this.last.next.previous = null;
					this.last.next = null;

			}
			else { // 删除中间节点
				Node curr = this.first;
				for(int i=0; i<idx; i++) {
					curr = curr.next;
				}
				curr.previous.next = curr.next; //当前节点前的节点，指向了后一个节点。
				curr.next.previous = curr.previous; // 当前节点后的节点，指向了前一个节点。
				curr.next = null; // 摘除的节点。必须将对其它节点的引用去除。
				curr.previous = null;
				curr = null;
			}
			size--;
			return true;
		}
		
	}
	
	

	@Override
	public Iterator<E> iterator() {
		
		return new Iterator() {
			private Node<E> currNode = null;
			private int idx = -1;
			
			@Override
			public boolean hasNext() {
				if(currNode!=null) {
					return this.currNode!= MyLinkedList.this.last? true : false;
				}else {
					return size>0? true: false;
				}
				
			}

			@Override
			public E next() {
				E e  = null;
				if(currNode==null) {
					currNode = first;
				}else {
					currNode = currNode.next;
				}
				e = (E) currNode.value;
				idx++;
				return e;
			}
			
			@Override
			public void remove() {
				currNode = currNode.previous;
				MyLinkedList.this.remove(idx);
				idx--;
			}
			
		};
	}
	
public static void main(String[] args) {
		
		
		MyLinkedList<Integer> list = new MyLinkedList<>();
		for(int i=1;i<=10;i++) {
			list.add(i*10);
		}
		
		for(int i : list) {
			System.out.println(i);
		}
	    System.out.println("---------------------");
	    
		Iterator<Integer> itor = list.iterator();		
		while(itor.hasNext()) {
			Integer i = itor.next();
			System.out.println(i);
			if(i==100) {
				itor.remove();
				System.out.println("100被删除");
			}
			
		}
		
		System.out.println("===========================");
		System.out.println(Arrays.toString(list.toArray()));
		
	}

}
