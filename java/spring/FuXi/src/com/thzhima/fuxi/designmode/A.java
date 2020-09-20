package com.thzhima.fuxi.designmode;

public final class A {

	public final String gender;
	
	A(){
		gender = "男";
	}
	
	public final void todo() {
		System.out.println("sssssssssssssssss");
	}
	
}

//class B extends A{ // final类不能继
//	
//	public final void todo() { // final方法不能重写
//		
//		System.out.println("sssssssssssssssss");
//	}
//}
