package com.thzhima.collection;

public class MyLinkedList {
	
	private long size = 0;
	private Node first = null;
	private Node last = null;
	
	public long add(int v) {
		if(0 == size) {// ��ӵ�һ���ڵ�
			Node newNode  = new Node(v, null, null);
			this.first = newNode;
			this.last = newNode;
		}else {
			Node newNode = new Node(v, this.last, null);// �½ڵ��ǰ��ָ�룬ָ��ǰ���һ���ڵ㡣
			this.last.next = newNode; // ��ǰ���һ���ڵ�ĺ���ָ�룬ָ������ӵĽڵ㡣
			this.last = newNode; // ��β�ڵ�ָ�룬ָ������ӵĽڵ㡣ʹ����ӵĽڵ㣬��Ϊ���������һ���ڵ㡣
		}
		return ++size;
	}
	
	// ���ص�ǰ�б�Ĵ�С�����б����ж��ٸ�Ԫ�ء�
	public long size() {
		return this.size;
	}
	
    // �����±꣬ȡ�б��е�Ԫ�ء�
	public int get(int idx) {
		/*�Ե�һ��Ԫ�أ�Ϊ��ǰԪ�ء�
		 * ȡ�ڼ���Ԫ�أ������ź���ָ���ƶ����Ρ�Ϊ��ǰҪ�ҵ�Ԫ�ء�
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
