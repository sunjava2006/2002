package com.thzhima.usualy;

import java.util.Calendar;
import java.util.Date;

public class DateCalendar {

	public static void main(String[] args) {
		Date now = new Date(System.currentTimeMillis());
		now = new Date();
		
		Date birthDate = new Date(109, 5, 4);
		System.out.println(birthDate);
		
		
		Calendar c = Calendar.getInstance(); // 静态工厂方法
		
		System.out.println(c.get(Calendar.YEAR)+"-"+(1+c.get(Calendar.MONTH))+"-"+c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));
		
		c.set(2009, 5, 6, 12, 12, 12);
		c.set(Calendar.YEAR, 2000);
		c.set(Calendar.MONTH, 11);
		
		
		Date d = c.getTime();
		System.out.println(d);
		
		long fasttime = now.getTime();
		c.setTimeInMillis(fasttime);
		
	}
}
