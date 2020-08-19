package com.thzhima.homework;

import java.io.IOException;

public class Guess {

	public static void guessNumber() throws IOException {
		int ran = (int)(Math.random()*10);
		byte[] buffer  = new byte[1000];
		while(true) {
			System.out.println("在下行，输入一个0-10之间的数：");
			int length = System.in.read(buffer);
			String s = new String(buffer, 0, length-2);
			int val = Integer.parseInt(s);
			if(ran == val) {
				System.out.println("猜对了。");
				break;
			}else if(val > ran) {
				System.out.println("大了。");
			}else {
				System.out.println("小了。");
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		Guess.guessNumber();
	}
}
