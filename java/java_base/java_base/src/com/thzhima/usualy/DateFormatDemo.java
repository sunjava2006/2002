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
		
		DateFormat fmt3 = new  SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss�� E");
		System.out.println(fmt3.format(new Date()));
		
		DateFormat fmt4 = new  SimpleDateFormat("yyyy��MM��dd��");
		System.out.println(fmt4.format(new Date()));
		
		Date d1 = fmt.parse("2020-8-10");
		System.out.println(d1);
		
		Date d2 = fmt3.parse("2020��08��10�� 15ʱ12��10�� ����һ");
		System.out.println(d2);
		
	}
}
