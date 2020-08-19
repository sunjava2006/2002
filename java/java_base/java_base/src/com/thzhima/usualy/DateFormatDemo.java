package com.thzhima.usualy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {

	public static void main(String[] args) throws ParseException {
		DateFormat fmt = DateFormat.getDateInstance();
		String str = fmt.format(new Date());
		System.out.println(str);
		
		DateFormat fmt2 = DateFormat.getDateTimeInstance();
		str = fmt2.format(new Date());
		System.out.println(str);
		
		DateFormat fmt3 = new  SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");
		System.out.println(fmt3.format(new Date()));
		
		DateFormat fmt4 = new  SimpleDateFormat("yyyy年MM月dd日");
		System.out.println(fmt4.format(new Date()));
		
		Date d1 = fmt.parse("2020-8-10");
		System.out.println(d1);
		
		Date d2 = fmt3.parse("2020年08月10日 15时12分10秒 星期一");
		System.out.println(d2);
		
	}
}
