package com.zhaodj.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SearchDemo {

	private static Random random = null;
	private static List<String> store = new ArrayList<String>();

	public static void main(String[] args) {
		for(int i=0;i<500000;i++){
			store.add(SearchDemo.getRandomLengthChiness(3,10));
		}
		long time=System.currentTimeMillis();
		List<String> list=new ArrayList<String>();
		for(String str:store){
			if(str.startsWith("我")){
				list.add(str);
			}
		}
		System.out.println(System.currentTimeMillis()-time);
		System.out.println(list);
	}

	private static Random getRandomInstance() {
		if (random == null) {
			random = new Random(new Date().getTime());
		}
		return random;
	}

	public static String getRandomLengthChiness(int start, int end) {
		String str = "";
		int length = new Random().nextInt(end + 1);
		if (length < start) {
			str = getRandomLengthChiness(start, end);
		} else {
			for (int i = 0; i < length; i++) {
				str = str + getChinese();
			}
		}
		return str;
	}

	public static String getChinese() {
		String str = null;
		int highPos, lowPos;
		Random random = getRandomInstance();
		highPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = 161 + Math.abs(random.nextInt(93));
		byte[] b = new byte[2];
		b[0] = (new Integer(highPos)).byteValue();
		b[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(b, "GB2312");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

}
