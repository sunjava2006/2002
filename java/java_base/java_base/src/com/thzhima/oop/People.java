package com.thzhima.oop;

// class 定义类的关键字，后面跟类名（数据类型名）
class People {
	
	// 在类中定义的变量，称为“属性”。
	String birthDate;
	final String gender ;
	String name = "宝宝";
	float height;
	float weight;
	int age = 1;
	
	{  // 代码块
	    name = "小宝";
//	    this.gender = "x";
	}
	
	// 默认构造方法，在我们没有定义任何构造方法的情况下，编译器提供这样一个缺省构造。
	People(){
		System.out.println("--------默认构造----------");
		age = 1;
		birthDate = "今天";
		gender = "男";
	}
	People(String birthDate, String gender, String name, float height, float weight){
		this(birthDate, gender,name,height,weight,0);
	}
	
	People(String birthDate, String gender, String name, float height, float weight, int age){
		this.birthDate = birthDate;
		this.gender = gender;
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}
	
	
	// 定义了方法。就是在类中定义的函数。
	void run() {
		System.out.println(name + "跑步中 .......");
	}
	
	int work() {
		System.out.println(this.name+"上班，工作中....");
		return 5000;
	}
	
	void work(String task) {
		System.out.println(this.name+"执行:"+task+"中....");
		
	}
	
	public static void main(String[] args) {
		// 申明People类的变量p, new 关键字用来创建对象。
//		People p = new People(); // 构造函数
//		p.name = "李小刚";
//		p.age = 22;
//		p.height = 178;
//		System.out.println(p.name);
//		System.out.println(p.age);
//		System.out.println(p.height);
//		
//		p.work();
//		p.run();
		
		People p = new People("1990-3-3", "男", "李明", 180, 80, 30);
		System.out.println(p.gender);
		p.work();
		p.work("上课");
		People p2 = new People("1990-3-3", "女", "小红", 180, 80, 30);
		System.out.println(p2.gender);
//		p2.gender = "男";		
	}
}
