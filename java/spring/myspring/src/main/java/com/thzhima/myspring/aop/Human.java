package com.thzhima.myspring.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class Human {

	void work() {
		System.out.println("work.............");
	}
}
