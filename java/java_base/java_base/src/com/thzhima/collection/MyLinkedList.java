package com.thzhima.collection;

public class MyLinkedList {
	
	private long size = 0;
	private Node first = null;
	private Node last = null;
	
	public long add(int v) {
		if(0 == size) {// 添加第一个节点
			Node newNode  = new Node(v, null, null);
			this.first = newNode;
			this.last = newNode;
		}else {
			Node newNode = new Node(v, this.last, null);// 新节点的前向指针，指向当前最后一个节点。
			this.last.next = newNode; // 当前最后一个节点的后面指针，指向新添加的节点。
			this.last = newNode; // 当尾节点指针，指向新添加的节点。使新添加的节点，成为链表中最后一个节点。
		}
		return ++size;
	}
	
	// 返回当前列表的大小。即列表中有多少个元素。
	public long size() {
		return this.size;
	}
	
    // 根据下标，取列表中的元素。
	public int get(int idx) {
		/*以第一个元素，为当前元素。
		 * 取第几人元素，就沿着后面指针移动几次。为当前要找的元素。
		 */
		Node curr = this.first;
		for(int i=0; i<idx ; i++) {
			curr = curr.next;
		}
		return curr.value;
	}

	private class Node{
		int value;
		Node next;
		Node previous;
		
		Node(int value, Node previous, Node next){
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		list.add(25);
		
		for(int i=0; i<list.size(); i++) {
			int v = list.get(i);
			System.out.println(v);
		}
	}
	
}
