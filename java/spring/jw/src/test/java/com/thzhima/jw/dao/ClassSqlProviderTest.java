package com.thzhima.jw.dao;

import org.junit.jupiter.api.Test;
import com.thzhima.jw.beans.Class;

class ClassSqlProviderTest {

	@Test
	void testQueryByExam() {
		ClassSqlProvider p = new ClassSqlProvider();
		Class c = new Class(null,"a","ss",null);
		String s = p.queryByExam(c, 1,10);
		System.out.println(s);
	}

}
