package com.thzhima.base;
//     ������  ����
public class BaseType {
	
	//������ڷ������̶�д��.
	//�����ɷ��� ��̬������Ҫnew���������� ��������������
	public static void main(String[] args) {
		boolean a = true;
		char c = 'c';
		byte b = 127; // 1�ֽ�
		short s = -32768; // 2�ֽ�
		int i = 2147483647; // 4 �ֽ�
		
		long l = 200L; // 8�ֽ� L��ʾ long���͡�
		long ll = 200; // int���͵�200���ŵ�long���͵Ŀռ���ȥ��
		
		float f = 3.14F; // F��ʾ float���͡�32λ
		float ff = (float)3.14; // 64λdouble���ͷ���float��
		
		double d = 3.14;
		
		
		short ss = b;
		int ii = ss;
		long lll = ii;
		
		double dd = 3.2F;
		
		float fff = (float)dd;
		
		byte bb = (byte)ii; // ǿ������ת��
		
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
