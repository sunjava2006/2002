package com.thzhima.oop;

// class ������Ĺؼ��֣������������������������
class People {
	
	// �����ж���ı�������Ϊ�����ԡ���
	String birthDate;
	final String gender ;
	String name = "����";
	float height;
	float weight;
	int age = 1;
	
	{  // �����
	    name = "С��";
//	    this.gender = "x";
	}
	
	// Ĭ�Ϲ��췽����������û�ж����κι��췽��������£��������ṩ����һ��ȱʡ���졣
	People(){
		System.out.println("--------Ĭ�Ϲ���----------");
		age = 1;
		birthDate = "����";
		gender = "��";
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
	
	
	// �����˷��������������ж���ĺ�����
	void run() {
		System.out.println(name + "�ܲ��� .......");
	}
	
	int work() {
		System.out.println(this.name+"�ϰ࣬������....");
		return 5000;
	}
	
	void work(String task) {
		System.out.println(this.name+"ִ��:"+task+"��....");
		
	}
	
	public static void main(String[] args) {
		// ����People��ı���p, new �ؼ���������������
//		People p = new People(); // ���캯��
//		p.name = "��С��";
//		p.age = 22;
//		p.height = 178;
//		System.out.println(p.name);
//		System.out.println(p.age);
//		System.out.println(p.height);
//		
//		p.work();
//		p.run();
		
		People p = new People("1990-3-3", "��", "����", 180, 80, 30);
		System.out.println(p.gender);
		p.work();
		p.work("�Ͽ�");
		People p2 = new People("1990-3-3", "Ů", "С��", 180, 80, 30);
		System.out.println(p2.gender);
//		p2.gender = "��";		
	}
}
