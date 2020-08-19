package com.thzhima.advance.lambda;

public class AirPlane {

	public void fly(Flyable f) {
		String action = "90度";
		f.fly(action);
	}

	public static void main(String[] args) {

		AirPlane plane = new AirPlane();
		Flyable f = (String s) -> {System.out.println("按" + s + "姿势飞行....");};
		plane.fly(f);
		
		
	}
}
