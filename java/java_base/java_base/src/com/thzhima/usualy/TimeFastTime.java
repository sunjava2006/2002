package com.thzhima.usualy;

import java.util.Calendar;
import java.util.Date;

public class TimeFastTime {

	public static void main(String[] args) {
		Date d = new Date(0);
		System.out.println(d);
		
		System.out.println(d.getTime());
		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		System.out.println(c.getTime());
		
		
	}

}
