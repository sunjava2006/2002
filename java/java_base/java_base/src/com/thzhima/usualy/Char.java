package com.thzhima.usualy;

public class Char {

	public static void main(String[] args) {
		char c = '3';  //3
		char c2 = c;   //3
		
		c = '4';   
		System.out.println(c); // 4
		System.out.println(c2);// 3
		
		Character ca = 'a';   // ������ ��ͬ���ڴ���ֻ��һ�������ڷ���������8Ԫ��������
		Character cb = 'b';
		System.out.println(ca == cb);
		
		Character cc  = ca;
		cc = 'c';
		System.out.println(ca == cc);
		
		
		Character c1 = 'a';
		Character cc2 = new Character('a');
		Character cc3 = new Character('a');
		System.out.println("c1 == cc2:"+(c1 == cc2));
		System.out.println("cc3 == cc2:"+(cc3 == cc2));
		System.out.println(cc2.equals(cc3));
		
		System.out.println("------------------------------");
		boolean b = c == c1;
		
		/*
		 * 8�������������͵İ�װ���String���͡�
		 *  1�������� ��ͬ���ڴ���ֻ��һ�������ڷ�������
		 *  2��new ���촫����������ǳ�����
		 */
		
		Character ccc = Character.valueOf('c');
		
		
		Long.valueOf(400L);
		Long.parseLong("33");
		Integer.valueOf(30);
		Integer.parseInt("23");
		
		
	}
}
