package com.thzhima.myspring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CookingProxy implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("方法名："+method.getName());
		if("cook".equals(method.getName())) {
			A a  = new A();
			B b = new B();
			a.a();
			b.b();
			Cook c = new Cook();
			c.cook();
			return null;
		}
		else {
			Cook c = new Cook();
			c.cook();
			return null;
		}
		
		
	}

}
