package com.thzhima.inner;

public class AireplaneFactory {

	public static J22 create() {
		return new J22() ;//{
//			public void ai(){
//				super.ai();
//				System.out.println("增强人工智能........");
//			}
//		};
	}
	
	public static F6G createNew() {
		F6G airplane =  new F6G() {
			public void ai() {
				System.out.println("AI功能");
			}
			public void drive() {
				System.out.println("AI驾驶");
			};
		}; 
		
		return airplane;
	}
	
	public static void main(String[] args) {
		F6G plane = AireplaneFactory.createNew();
		plane.ai();
		plane.drive();
		plane.validate();
		System.out.println(plane.getClass().getName());
		System.out.println(plane instanceof F6G);
		
		
		J22 j22 = AireplaneFactory.create();
		
		j22.ai();
		j22.drive();
		j22.validate();
		System.out.println(j22.getClass().getName());
		System.out.println(j22 instanceof J22);
		System.out.println(j22 instanceof F6G);
	}
}
