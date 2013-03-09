package com.zhaodj.test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Md5 {
	
	public static void main(String[] args){
		Md5 md5=new Md5();
		System.out.println(md5.generateHash("zhaodj1985@gmail.com"));
		System.out.println(md5.generateHash("282322121@qq.com"));
		System.out.println(md5.generateHash("181968828@qq.com"));
	}
	
	private String generateHash(String mail){
		String str=mail+UUID.randomUUID();
		String result=null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(str.getBytes("UTF-8"));
			byte[] byteArr=md5.digest();
			StringBuilder md5StrBuff = new StringBuilder(); 
	        for (int i = 0; i < byteArr.length; i++) {              
	            if (Integer.toHexString(0xFF & byteArr[i]).length() == 1)  
	                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArr[i]));  
	            else  
	                md5StrBuff.append(Integer.toHexString(0xFF & byteArr[i]));  
	        }  
	        result=md5StrBuff.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
