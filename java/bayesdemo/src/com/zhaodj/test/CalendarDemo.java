package com.zhaodj.test;

import java.util.Calendar;

public class CalendarDemo {
	
	public static void main(String[] args){
		Calendar now=Calendar.getInstance();
		System.out.println(now.getTime());
		System.out.println(Calendar.SUNDAY);
		System.out.println(Calendar.MONDAY);
		System.out.println(Calendar.WEDNESDAY);
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
	}

}
