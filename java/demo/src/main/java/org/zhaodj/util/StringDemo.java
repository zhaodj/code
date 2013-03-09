package org.zhaodj.util;

import org.apache.commons.lang3.StringUtils;

public class StringDemo {
	
	public static void main(String[] args){
		System.out.println(StringUtils.trim(" Esprit"));
		System.out.println(" Esprit".replaceAll("\\u00A0", " ").trim());
		System.out.println(" Esprit dakl ".replace(' ', ' ').trim());
		char c=(char)160;
		System.out.println(c);
		System.out.println((int)(" ".charAt(0)));
		System.out.println((int)(" ".charAt(0)));
		System.out.println((int)(" ".charAt(0)));
		String str="哈哈 呵呵";
		str=StringUtils.replaceEach(str, new String[] { ",", "，", "　" }, new String[] { " ", " ", " " });
		System.out.println(str);
		for(String s:StringUtils.split(str,' ')){
			System.out.println(s);
		}
	}

}
