package com.thzhima.jw.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubjectPlanDAOTest {
	
	@Autowired
	private SubjectPlanDAO dao;

	@Test
	void testCurrentPlan() {
		System.out.println(dao.currentPlan(1, 8.0, 8.10, 1));
	}

}
