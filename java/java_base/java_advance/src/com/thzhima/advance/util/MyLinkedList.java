package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.Iterator;


public class MyLinkedList<E> implements MyList<E> {
	
	protected Node first;
	protected Node<E> last;
	protected int size; // �洢�б���Ԫ�صĸ�����ֻ�ṩ�˶�ȡ�ķ�����ʹ֮��Ϊֻ�����ԡ�
	
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
		if(this.size==0) { // ��Ϊ�б�����ӵ�һ��Ԫ��ʱ
			/*
			 *����ڵ�û��ǰ�ڵ㣬û�к�ڵ㡣�ڵ��previous��next��Ϊnull��
			 *����ڵ���������Ψһ�ڵ㡣���first��lastָ�붼ָ������ 
			 */
			Node newNode = new Node(e, null, null);
			this.first = newNode;
			this.last = newNode;
		}else {// ��������β�ڵ�֮������½ڵ㡣
			/*
			 * 1���������ӽڵ㣬previousҪָ��ǰ��β�ڵ㡣nextΪnull��
			 * 2����ǰβ�ڵ��nextָ�룬ָ������½ڵ㡣 ͨ��1��2�������½ڵ�������ʵ��˫����ء�
			 * 3��ʹ����ӽڵ㣬Ϊ�����е�β�ڵ㡣
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
		 * ��ͷ���������ҵ��������ȵĽڵ㡣��ȡ�ýڵ��������
		 */
		Node<E> curr = first;
		int i=0;
		for(; i<size; i++) {
			if(curr.value.equals(e)) {
				break;
			}
			curr = curr.next;
		}
		// ͨ������ɾ���ڵ㡣
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
		// ����±곬��������Χ��ֱ�ӷ���null��
		if(idx>=size || idx<0) {
			return null;
		}else {
			/**
			 * ���ҵ�ָ���±�Ľڵ㡣current��һ�����׽ڵ�����ƶ����αꡣ
			 * Ҫ��n���ڵ㣬������ƶ�n�Ρ���������ڵ���Ԫ�ص�ֵ��
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
			if(0 == idx) {//ɾ���׽ڵ�
				if(this.first.next!=null) {
					this.first = this.first.next;
					this.first.previous.next = null;
					this.first.previous = null;
				}else {//ֻ��Ψһһ���׽ڵ�ʱ
					this.first=null;
					this.last = null;
				}
				
			}else if(this.size-1 == idx) {//ɾ��β�ڵ�
					this.last = this.last.previous;
					this.last.next.previous = null;
					this.last.next = null;

			}
			else { // ɾ���м�ڵ�
				Node curr = this.first;
				for(int i=0; i<idx; i++) {
					curr = curr.next;
				}
				curr.previous.next = curr.next; //��ǰ�ڵ�ǰ�Ľڵ㣬ָ���˺�һ���ڵ㡣
				curr.next.previous = curr.previous; // ��ǰ�ڵ��Ľڵ㣬ָ����ǰһ���ڵ㡣
				curr.next = null; // ժ���Ľڵ㡣���뽫�������ڵ������ȥ����
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
				System.out.println("100��ɾ��");
			}
			
		}
		
		System.out.println("===========================");
		System.out.println(Arrays.toString(list.toArray()));
		
	}

}
