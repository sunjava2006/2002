package com.thzhima.myspring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FlyMan {

	@DeclareParents(defaultImpl = Bird.class, value = "com.thzhima.myspring.aop.Human")
	Flyable man;
}
