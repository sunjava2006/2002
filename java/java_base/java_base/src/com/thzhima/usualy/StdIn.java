package com.thzhima.usualy;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StdIn {

	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		
		
//		while(true) {
//			char c = (char) in.read();
//			System.out.println(c);
//			if(c=='\r') {
//				System.out.println("-r");
//			}if(c=='\n') {
//				System.out.println("-n");
//				break;
//			}
//		}
		
		InputStreamReader inReader = null;
		
		char[] buffer = new char[5];
		
		// 从字节流上建立的字符输入流。
		inReader = new InputStreamReader(in);
		
		while(true) {
			int length = inReader.read(buffer);
			String msg = new String(buffer,0, length);
			System.out.println(msg);

		}
		
		
	}
}
