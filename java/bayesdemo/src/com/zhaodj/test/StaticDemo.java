package com.zhaodj.test;

public class StaticDemo {
	
	public static StringTest test=new StringTest();
	
	public void setStr(String s){
		test.setStr(s);
	}
	
	public static void main(String[] args){
		StaticDemo demo1=new StaticDemo();
		demo1.setStr("first");
		StaticDemo demo2=new StaticDemo();
		System.out.println(StaticDemo.test.getStr());
	}

}
