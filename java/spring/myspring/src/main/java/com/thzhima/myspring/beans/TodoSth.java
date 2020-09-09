package com.thzhima.myspring.beans;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

public class TodoSth implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("obj:"+obj);
		System.out.println("method:" + method.getName());
		System.out.println("args:" + Arrays.toString(args));
		return null;
	}

}
