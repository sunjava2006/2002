package com.thzhima.myspring.beans;

import java.beans.ConstructorProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component(value = "javaPro")
public class Book {

	@Value("JavaProfessional")
	private String name;

	private Float price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	@Value("23.12")
	public void setPrice(Float price) {
		this.price = price;
	}


	
	public Book(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Book(String name) {
		super();
		this.name = name;
		
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}
	
	
	
}
