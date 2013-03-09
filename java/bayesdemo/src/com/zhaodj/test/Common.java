package com.zhaodj.test;

public class Common {
	
	public static void main(String[] args){
		System.out.println(System.getProperties());
		StringBuilder sb=new StringBuilder(System.getProperty("java.library.path"));
		System.setProperty("java.library.path", sb.append(":").append(Common.class.getResource("").getPath()).toString());
		String[] arr=System.getProperty("java.library.path").split(":");
		for(String str:arr){
			System.out.println(str);
		}
	}

}
