package com.thzhima.interfaces;

public interface MyList {
	
	public static final int size = 0; // final��ƽ static���� public����
	

	
	public abstract void add() ; // public abstract 
	
	void remove();
	
	//--JDK8�������ԣ�Ĭ�Ϸ���
	default int size() {
		return size;
	}
	
	// JDK8�������ԣ���̬������
	static int a() {
		return 20;
	}
	
}
