package com.thzhima.advance.lambda;

public class AirPlane {

	public void fly(Flyable f) {
		String action = "90��";
		f.fly(action);
	}

	public static void main(String[] args) {

		AirPlane plane = new AirPlane();
		Flyable f = (String s) -> {System.out.println("��" + s + "���Ʒ���....");};
		plane.fly(f);
		
		
	}
}
