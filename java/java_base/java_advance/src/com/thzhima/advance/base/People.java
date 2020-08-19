package com.thzhima.advance.base;

// Java Bean
public class People implements Comparable<People>{

	private final String name;
	private int age;
	private String gender;

	public People(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	

//	public void setName(String name) {
//		this.name = name;
//	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean equals(Object o) {
		System.out.println("----------------equals----------------");
		if(this == o) {
			return true;
		}
		else {
			if(o instanceof People) {
				People pp = (People) o;
				if(this.name.equalsIgnoreCase(pp.name) 
				   && this.age==pp.age) {
					if(this.gender!=null) {
						if(this.gender.equalsIgnoreCase(pp.gender)) {
							return true;
						}
					}
				}
				
			}
			return false;
		}
	}
	
	public int hashCode() {
		
		int result = this.name.hashCode();
		int code = 37*result + this.age + (this.gender!=null? gender.hashCode():0);
		return code;
	}
	
	@Override
	public int compareTo(People o) {
		int c = age-o.age;
		if(c != 0) {
			return c;
		}else {
			if(this.equals(o)) {
				return 0;
			}else {
				return -1;
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}



	public static void main(String[] args) {
		People p = new People("wang", 20, null);
		People p2 = new People("wang", 20, null);
		
		
		System.out.println(p.hashCode());
		System.out.println(p2.hashCode());
		
		System.out.println(p.equals(p2));
		
		System.out.println(p == p2);
	}



	
}

