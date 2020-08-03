package com.thzhima.base;

import java.util.Arrays;

public class Bubber {

	public static void main(String[] args) {
		int[] a = {6,7,5,8,4,9,2,10,1};
		
		// 确定要遍历整理的轮数。这个数是数组长度减1。
		for(int i=0; i<a.length-1; i++) {
			
			// 当已经排序完成的情况下，就不会再产生元素的交换。
			// 如果为false则没有通。
			boolean pass = true;
			
			// 从前向后，逐一进行比较。将大的数，推到后面。
			// j是遍历数据的游标变量。从0，移到到最后一个元素的前一个。
			// 每轮下来，j可以逐轮减1。
			for(int j=0; j<a.length-1-i; j++) {
				if(a[j]>a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					pass = false;  // 设置仍有交换，还没有通。
				}
			}
			if(pass) {
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	// 1,2,3,4,5,6,7,8,9,10
}
