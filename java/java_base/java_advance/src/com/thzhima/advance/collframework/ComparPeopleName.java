package com.thzhima.advance.collframework;

import java.util.Comparator;

import com.thzhima.advance.base.People;

public class ComparPeopleName implements Comparator<People>{

	@Override
	public int compare(People o1, People o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
