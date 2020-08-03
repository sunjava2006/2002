package com.thzhima.inherit;

import java.util.Date;

public class Animal {
	
	public String gender;
	Date birthDate;
	public float weight;
	public String food = "»‚";
	
	public void run() {
		System.out.println("±º≈‹.........");
	}
	
	protected void eat() {
		System.out.println("≥‘"+this.food+"..........");
	}
}
