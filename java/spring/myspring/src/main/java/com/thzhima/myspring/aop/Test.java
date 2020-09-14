package com.thzhima.myspring.aop;

import java.lang.reflect.Proxy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		Cooking ck =  (Cooking) Proxy.newProxyInstance(Cooking.class.getClassLoader(), 
//				       Cook.class.getInterfaces(), new CookingProxy());
//		
//
//		ck.cook();
//		ck.cook2();
		
		
		
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		Cooking cook = app.getBean(Cooking.class);
//		System.out.println(cook);
		cook.cook();
		cook.cook2();
		
		Object m =  app.getBean("human");
		System.out.println(m);
		
		System.out.println(m instanceof Human);
		System.out.println(m instanceof Flyable);
		Flyable f = (Flyable) m;
		f.fly();
	}

}
