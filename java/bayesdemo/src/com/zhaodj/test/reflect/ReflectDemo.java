package com.zhaodj.test.reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectDemo {

	private String input;
	public ReflectDemo(String input){
		this.input=input;
	}
	
	public String getInput(){
		return this.input;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		System.out.println(ReflectDemo.class.getSimpleName());
		ReflectDemo demo=ReflectDemo.class.getConstructor(String.class).newInstance("dadsada");
		System.out.println(demo.getInput());
	}
}
