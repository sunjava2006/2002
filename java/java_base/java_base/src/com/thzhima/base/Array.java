package com.thzhima.base;

public class Array {

	public static void main(String[] args) {
		
		int[] a = new int[5];// ����int������󡣲�ȱʡ��ʼ����
		System.out.println(a.length);
		
		a[0] = 10;
		a[1] = 20;
		a[4] = 50;
		System.out.println("a[1]+a[0]=" + (a[1]+a[0]));
		for(int i : a) {
			System.out.println(i);
		}
		
		String[] sarr = null;
		sarr = new String[] {"java", "c", "c++"};// �г�ʼֵ��
		
		float[] farr = {3.2F, 1.1F, 2.3F}; // ��ʼ����������������ͬʱ��
		
		System.out.println("sarr.length:" + sarr[-1]);
		
		int b = 90;
		
		
	}

}
