package com.thzhima.myspring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Value("QQ")
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Car(String brand) {
		super();
		this.brand = brand;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
	
}
