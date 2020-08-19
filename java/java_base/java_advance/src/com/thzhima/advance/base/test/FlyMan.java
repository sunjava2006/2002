package com.thzhima.advance.base.test;

import java.io.Serializable;
import java.util.Iterator;

import com.thzhima.advance.base.Flyable;

public class FlyMan<T> extends Object implements Flyable, Serializable, Iterable<T>{

	@Override
	public void todo() {
		System.out.println("-----------------");
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
