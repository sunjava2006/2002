package com.thzhima.usualy;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "china";
		String s2 = "china";
		String s3 = new String("china");
		
		char[] array = {'h','e','l','l','o'};
		
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.charAt(0));
		System.out.println(s.codePointAt(4));
		System.out.println(s.codePointBefore(4));
		System.out.println(s.codePointCount(3, 4));
		System.out.println(s.compareTo("China"));
		System.out.println(s.compareToIgnoreCase("ChIna"));
		System.out.println(s.concat("ok"));
		System.out.println(s.contains("ch"));
		System.out.println(s.contentEquals("china"));
		System.out.println(String.copyValueOf(array));
		System.out.println(new String(array));
		System.out.println(s.startsWith("c"));
		System.out.println(s.endsWith("na"));
		System.out.println(Arrays.toString(s.getBytes("utf-8")));
		char [] c = new char[10];
		s.getChars(0, 2, c, 1);
		System.out.println(Arrays.toString(c));
		
		
	}

}
