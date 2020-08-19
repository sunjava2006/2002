package com.thzhima.advance.enums;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Season s = Season.SPRING;
		System.out.println(s==Season.SPRING);
		Season[] arr = Season.values();
		for(Season i : arr) {
			System.out.println(i.getStartMonth()+":"+i.getEndMonth()+":"+i.getMsg());
			System.out.println(i);
		}
		
		
		if(s==Season.SPRING) {
		   System.out.println("-----------ÊÇ´ºÌì");	
		}
		switch(s) {
		case SPRING:
			System.out.println("--------------");
			break;
		case SUMMER:
			System.out.println("===============");
			break;
		default:
		    System.out.println("0000000000000000");		
		}
		
	}

}
