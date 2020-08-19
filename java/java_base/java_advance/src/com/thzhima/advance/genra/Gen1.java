package com.thzhima.advance.genra;

import java.util.ArrayList;
import java.util.List;

public class Gen1<T extends Number> {

	boolean a(List<? extends Number> l) {
		return false;
	}
	
	List<? super Integer> li;
	List<? extends Number> lis;
	
	public static void main(String[] args) {
		List<String> list = new ArrayList();
		
		list.add("String");
//		list.add(new Integer(20));
		
		String s =  list.get(0);
//		int i = (Integer) list.get(1);
		
	}
}
