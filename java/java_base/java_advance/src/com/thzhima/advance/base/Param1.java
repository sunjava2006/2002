package com.thzhima.advance.base;

public class Param1 {

	public  void change(int a) {
		a += 10;
		System.out.println(a); // 20
	}
	
	public void change(String s) {
		s = s.toLowerCase();
		System.out.println(s); // china
	}
	
	public void change(int a, String s) {
		s="English";
		System.out.println(s);// English
	}
	
	public void change(StringBuffer sb) {
		sb.append("hi");
		System.out.println(sb); // okhi
	}
	
	public void change(Integer a) {
		a  = a+1;
		System.out.println(a);
	}
	
	public void change(People p) {
		p.setAge(20);
		System.out.println(p);// wang 20 male
	}
	
	public void change2(People pp) {
//		pp = null;
		pp = new People("li", 3, "male");
		System.out.println(pp);// null
	}
	
	public static void main(String[] args) {
		Param1 p = new Param1();
		int a = 10;
		p.change(a); // 20
		System.out.println(a); //10
	
		String s = "China";
		p.change(s); // china
		System.out.println(s); // China
		
		p.change(1, s);
		System.out.println(s); // China
		
		StringBuffer sb = new StringBuffer("ok");
		p.change(sb); // okhi
		System.out.println(sb); // okhi
		
		p.change(a); // 11
		System.out.println(a); //10
		
		Integer a2 = a;
		p.change(a2);
		
		People pp = new People("wang", 10, "male");
		p.change(pp); // wang 20 male
		System.out.println(pp);// wang 20 male
		
		p.change2(pp); // null
		System.out.println(pp);// wang 20 male
	}
}


