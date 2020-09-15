package com.thzhima.jw.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thzhima.jw.beans.Building;

@SpringBootTest
class BuildingDAOTest {

	@Autowired
	private BuildingDAO dao;
	
//	@Test
	void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	void testListByPage() {
	    List<Building> list = dao.listByPage("智", 1, 10);
	    
	    assertEquals(list.size(), 1);
	}

}
