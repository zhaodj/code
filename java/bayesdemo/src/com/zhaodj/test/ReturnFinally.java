package com.zhaodj.test;

public class ReturnFinally {
	
	public static void main(String[] args){
		System.out.println(doAndReturn());
	}
	
	private static String doAndReturn(){
		try{
			System.out.println("try");
			return "done";
		}
		catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		finally{
			System.out.println("finally");
		}
	}

}
