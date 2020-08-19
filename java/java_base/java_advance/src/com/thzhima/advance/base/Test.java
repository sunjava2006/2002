package com.thzhima.advance.base;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Test {
	
	public static void sort(int[] a) {
		for(int i=0;i<a.length-1;i++) {
			boolean ok = true;
			for(int j=0;j <a.length-i-1; j++) {
				if(a[j]>a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					ok = false;
				}
			}
			if(ok) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {1,7,9,2,5,8,12,78,3};
		sort(a);
		System.out.println(Arrays.toString(a));
		
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’");
		Date date = new Date(90, 2, 13);
		String s = fmt.format(date);
		System.out.println(s);

	}

}
