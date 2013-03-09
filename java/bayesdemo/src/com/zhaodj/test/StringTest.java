package com.zhaodj.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class StringTest {
	
	private String str;
	
	public void setStr(String str){
		this.str=str;
	}
	
	public String getStr(){
		return this.str;
	}

	public static void main(String[] args){
		//System.out.println("/diary/?\\w*".matches(regex))
		String str="120828/e76e585385b04977884348f79547baa6.jpg";
		int index=str.lastIndexOf(".");
		System.out.println(str.substring(0, index)+str.substring(index+1));
		Calendar calendar=Calendar.getInstance();
		calendar.set(2012, 0, 0,0,0,0);
		System.out.println(calendar.getTimeInMillis());
		System.out.println(new Date().getTime()-calendar.getTimeInMillis());
		System.out.println(Long.toString((new Date().getTime()-calendar.getTimeInMillis())/1000, 32));
		System.out.println("赵道军1344569155333".length());
		System.out.println("wwww.aibuyi.com".indexOf("www.aibuyi.com"));
		String json="callback( {\"client_id\":\"YOUR_APPID\",\"openid\":\"YOUR_OPENID\"} );";
		System.out.println(json.substring("callback(".length(),json.lastIndexOf(");")));
		System.out.println("如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商如果您是独立品牌电商".length());
		String sss="中文&Eng";
		for(int i=0;i<sss.length();i++){
			System.out.println(sss.codePointAt(i));
		}
		System.out.println(String.format("亲爱的%s，很高兴您能成为我们的内测用户。我们给您写了一封站内信，很重要的，请不要错过哦。点击 查看站内信。", "hacker"));
		StringTest test=new StringTest();
		test.setStr("aaaaaaa");
		String temp=test.getStr();
		test.setStr("bbbbbbbbbbb");
		System.out.println(test.getStr());
		System.out.println(temp);
		System.out.println(" Esprit".trim());
		System.out.println(" 品牌:Esprit".contains("品牌"));
		System.out.println("dalk_+-中文".matches("[a-zA-Z0-9\\u4e00-\\u9fa5_\\+\\-]+"));
		System.out.println(Boolean.parseBoolean("true")?"1":"0");
		System.out.println(Arrays.toString("你是谁".split("")));
		System.out.println("哈@哈|哈\\哈$哈/".replaceAll("[\\?@#\\$\\&\\(\\)/\\|;‘’“”\\\\]", ""));
		System.out.println("谢谢".hashCode()==new String("谢谢").hashCode());
		System.out.println("谢谢你教我,你可以再问我一次\n");
		System.out.println("谢谢你教我,你可以再问我一次\n".trim());
		System.out.println("谢谢你教我,你可以再问我一次".length());
		System.out.println("1、*&\n2、*(".replace("\n", " "));
		System.out.println(" 1、*&2、".substring(0, 2));
		System.out.println("\uff0c");
		System.out.println("我/n".indexOf("/"));
		str="<a href=\"http://sinatair.sinaapp.com/\" rel=\"nofollow\">[0xe5][0xbe][0xae][0xe5][0x8d][0x9a]AIR</a>";
		System.out.println(Arrays.toString(str.split("\"",5)));
	}
}
