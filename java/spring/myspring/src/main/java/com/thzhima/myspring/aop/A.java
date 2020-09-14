package com.thzhima.myspring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class A {

	// 切点表达式。用以明确“加入的逻辑”在哪一个类的的哪个方法上
	@Before(value = "execution(* com.thzhima.myspring.aop.Cook.cook2(..))")
	public void a() {
		System.out.println("A工序");
	}
	
	@Around("execution(* com.thzhima.myspring.aop.Cook.cook(..))")
	public void todo(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("------------------");
		pjp.proceed();
		System.out.println("==================");
	}
}
