package com.thzhima.base;

import java.util.Arrays;

public class Bubber {

	public static void main(String[] args) {
		int[] a = {6,7,5,8,4,9,2,10,1};
		
		// ȷ��Ҫ�������������������������鳤�ȼ�1��
		for(int i=0; i<a.length-1; i++) {
			
			// ���Ѿ�������ɵ�����£��Ͳ����ٲ���Ԫ�صĽ�����
			// ���Ϊfalse��û��ͨ��
			boolean pass = true;
			
			// ��ǰ�����һ���бȽϡ�����������Ƶ����档
			// j�Ǳ������ݵ��α��������0���Ƶ������һ��Ԫ�ص�ǰһ����
			// ÿ��������j�������ּ�1��
			for(int j=0; j<a.length-1-i; j++) {
				if(a[j]>a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					pass = false;  // �������н�������û��ͨ��
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
