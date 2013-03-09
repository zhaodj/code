package com.zhaodj.test;

public class MathDemo {
	
	public static void main(String[] args){
		for(int i=0;i<20;i++){
			System.out.println(2+Math.round(Math.random()));
			System.out.println(Math.pow(2, i));
		}
		System.out.println((int)Math.round((0.6-0.4d)*30));
	}
	
}
