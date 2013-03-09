package com.zhaodj.test;

import java.io.UnsupportedEncodingException;

public class EncodingDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		byte[] jiong="囧".getBytes("UTF-8");
		byte[] ya="吖".getBytes("UTF-8");
		String sjiong=new String(jiong);
		String sya=new String(ya);
		System.out.println(sjiong);
		System.out.println(sya);
	}

}
