package org.zhaodj.date;

import java.util.Calendar;
import java.util.Date;

public class DateInterval {
	
	public static void main(String[] args){
		Calendar cal=Calendar.getInstance();
		cal.set(2011, 2, 2);
		Date date=cal.getTime();
		System.out.println(interval(date));
	}
	
	public static int interval(Date birthday){
		Date date=new Date();
		return (int) ((date.getTime() - birthday.getTime()) / (24 * 3600000));
	}

}
