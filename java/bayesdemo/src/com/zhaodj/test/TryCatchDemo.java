package com.zhaodj.test;

public class TryCatchDemo {
	
	public static void main(String[] args){
		func();
		System.out.println("end");
	}
	
	public static void func(){
		try{
			System.out.println("try");
			//throw new Exception();
		}catch(Exception e){
			System.out.println("catch");
		}finally{
			System.out.println("finally");
		}
		
	}

}
