package com.thzhima.homework;

import java.io.IOException;

public class Guess {

	public static void guessNumber() throws IOException {
		int ran = (int)(Math.random()*10);
		byte[] buffer  = new byte[1000];
		while(true) {
			System.out.println("�����У�����һ��0-10֮�������");
			int length = System.in.read(buffer);
			String s = new String(buffer, 0, length-2);
			int val = Integer.parseInt(s);
			if(ran == val) {
				System.out.println("�¶��ˡ�");
				break;
			}else if(val > ran) {
				System.out.println("���ˡ�");
			}else {
				System.out.println("С�ˡ�");
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		Guess.guessNumber();
	}
}
