package com.thzhima.jw.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuildingSqlProviderTest {

	BuildingSqlProvider sp = new BuildingSqlProvider();
	
	@Test
	void testListByPage() {
		
		String sql = sp.listByPage(null, 1, 10);
		System.out.println(sql);
	}

	@Test
	void testCountSql() {
		System.out.println(sp.countSql(null));
	}

}
