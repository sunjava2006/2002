package com.thzhima.myspring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Home {

	@Autowired
	@Qualifier(value = "vw")
	private Car car;

	@Override
	public String toString() {
		return "Home [car=" + car + "]";
	}
	
	
	
	
}
