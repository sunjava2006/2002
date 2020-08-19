package com.thzhima.usualy;

public class StringBufferTest {

	public static void main(String[] args) {
//		StringBuffer sb = new StringBuffer("I like Python.");
		StringBuilder sb = new StringBuilder("I like Python.");
		StringBuilder copy = sb;
		
		System.out.println(copy==sb);
		
		sb.append("and java.");
		sb.insert(0, "!");
		sb.deleteCharAt(14);
		sb.insert(14, ",");
		sb.replace(14, 15, ";");
		System.out.println(sb.substring(1, 5));
		System.out.println(sb.indexOf("java"));
		
		
		System.out.println(sb);
		System.out.println(copy==sb);
		
	}

}
