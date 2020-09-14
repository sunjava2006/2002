package com.thzhima.myspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class RunTest {

	@Around(value = "@annotation(com.thzhima.myspring.aop.Moniter)")
	public void time(ProceedingJoinPoint pjp) throws Throwable {
		long s = System.currentTimeMillis();
		pjp.proceed();
		System.out.println("用时："+(System.currentTimeMillis()-s));
	}
}
