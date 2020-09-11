package com.thzhima.jw.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thzhima.jw.beans.Class;
@SpringBootTest
class ClassDAOTest {

	@Autowired
	ClassDAO dao;
	
	@Test
	void testInsert() {
//		fail("Not yet implemented");
	}

	@Test
	void testFindByID() {
//		fail("Not yet implemented");
	}

	//@Test
	void testQueryByExample() {

		Class c = new Class(null,null,null,null);
		List<Class> list = dao.queryByExample(c,1,50);
		System.out.println(list);
		assertEquals(14, list.size());
	}
	
	//@Test
	void testQueryByExample2() {

		Class c = new Class(1,null,null,null);
		List<Class> list = dao.queryByExample(c,1,20);
		System.out.println(list);
		assertEquals(list.get(0).getId(),1);
	}
	
	//@Test
	void testQueryByExample3() {

		Class c = new Class(null,"150101",null,null);
		List<Class> list = dao.queryByExample(c,1,20);
		assertEquals(list.size(),1);
	}
	
	@Test
	void testQueryByExample4() {

		Class c = new Class(null,"1501%",null,null);
		List<Class> list = dao.queryByExample(c,1,20);
		assertEquals(list.size(),4);
	}

//	@Test
	void testCountByExample() {
		Class c = new Class(null,"1501%","%计算机%",null);
		int count = dao.countByExample(c);
		assertEquals(count, 10);
	}

}
