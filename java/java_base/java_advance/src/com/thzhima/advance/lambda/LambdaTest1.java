package com.thzhima.advance.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaTest1 {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		
		li.add(50);
		li.add(10);
		li.add(30);
		
		// Lambda表达式是实现接口方法的简化形式。是匿名函数，也是接口对象。
		Comparator<Integer> c = (Integer o1, Integer o2) -> o2-o1;
		
		
		li.sort(Integer::compare);
		
		System.out.println(li);
		
		li.forEach((a)->System.out.println(a));
		
		li.forEach(System.out::println);
		
		
		
	}
}
