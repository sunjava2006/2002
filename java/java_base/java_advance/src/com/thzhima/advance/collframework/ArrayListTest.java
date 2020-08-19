package com.thzhima.advance.collframework;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ArrayList<Integer> list = new ArrayList<>(18);
		
		
		Class cls = list.getClass();
		Field f = cls.getDeclaredField("elementData");
		f.setAccessible(true);
		Object[] values = (Object[]) f.get(list);
		System.out.println(values.length);
		
		list.ensureCapacity(200);
		
		values = (Object[]) f.get(list);
		System.out.println(values.length);
		
		list.trimToSize();
		
		values = (Object[]) f.get(list);
		System.out.println(values.length);
		
	}
}
