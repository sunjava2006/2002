package com.thzhima.myspring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class B {

	@After("execution(* com.thzhima.myspring.aop.Cook.*(..))")
	public void b() {
		System.out.println("B工序");
	}
}
