package com.zhaodj.test;

public class ParseDemo {
	
	public static void main(String[] args){
		System.out.println(Double.valueOf("¥138.00".replaceAll("[^0-9\\.]", "")));
		System.out.println(Double.parseDouble("¥138.00".replaceAll("[^0-9\\.]", "")));
	}

}
