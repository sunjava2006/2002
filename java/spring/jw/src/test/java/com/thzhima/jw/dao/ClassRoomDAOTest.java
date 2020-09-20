package com.thzhima.jw.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClassRoomDAOTest {

	@Autowired
	private ClassRoomDAO dao;
	
	@Test
	void testFindByName() {
		System.out.println(dao.findByName("716"));
	}

}
