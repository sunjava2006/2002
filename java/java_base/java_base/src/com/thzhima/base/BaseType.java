package com.thzhima.base;
//     申明类  类名
public class BaseType {
	
	//程序入口方法，固定写法.
	//公共可访问 静态（不需要new）返回类型 方法名（参数）
	public static void main(String[] args) {
		boolean a = true;
		char c = 'c';
		byte b = 127; // 1字节
		short s = -32768; // 2字节
		int i = 2147483647; // 4 字节
		
		long l = 200L; // 8字节 L表示 long类型。
		long ll = 200; // int类型的200，放到long类型的空间中去。
		
		float f = 3.14F; // F表示 float类型。32位
		float ff = (float)3.14; // 64位double类型放入float。
		
		double d = 3.14;
		
		
		short ss = b;
		int ii = ss;
		long lll = ii;
		
		double dd = 3.2F;
		
		float fff = (float)dd;
		
		byte bb = (byte)ii; // 强制类型转换
		
		float fa = 2222L;
		int inta = (int)222L;
		
		float fb = (float)2.8E20;
		
		float ffb = 0.00000000001F;
		System.out.println(ffb);
		
		final int aa;
//		aa = 99;
		
		if(a) {
			
		}else if(true) {
			
		}
	}
}
