package com.thzhima.jw.dao;

import org.junit.jupiter.api.Test;
import com.thzhima.jw.beans.Class;

class ClassSqlProviderTest {

	ClassSqlProvider p = new ClassSqlProvider();
	
	//@Test
	void testQueryByExam() {
		
		Class c = new Class(null,null,"dfgf",null);
		String s = p.queryByExam(c, 1,10);
		System.out.println(s);
	}

	@Test
	void testCountByExam() {
		Class c = new Class(2,"xxx","dfgf",null);
		String s = p.countByExam(c);
		System.out.println(s);
	}
}
