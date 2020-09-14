package com.thzhima.myspring.aop;

import org.springframework.stereotype.Component;

@Component
public class Cook implements Cooking {

	@Override
	@Moniter
	public void cook() {
		System.out.println("料理.............");
	}

	@Override
	public void cook2() {
		System.out.println("做饭。。。");
	}
	
	
	
	
}
