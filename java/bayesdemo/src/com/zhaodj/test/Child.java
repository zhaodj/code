package com.zhaodj.test;

public class Child extends Father {
	
	public Child(){
		super("1 ");
		System.out.println("child created");
	}
	
	public static void main(String[] args){
		Father f=new Father();
		Child c=new Child();
	}
}
