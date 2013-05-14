package org.zhaodj.text;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeiboHuati {
	
	public static final String HUATI_REG="[＃#]([\\u4e00-\\u9fa5\\w]+)[＃#]";
	
	public Set<String> parse(String weibo){
		Pattern patt=Pattern.compile(HUATI_REG);
		Matcher matcher=patt.matcher(weibo);
		Set<String> result=new HashSet<String>();
		while(matcher.find()){
			result.add(matcher.group(1));
		}
		return result;
	}
	
	public static void main(String[] args){
		WeiboHuati wh=new WeiboHuati();
		System.out.println(wh.parse("aaaccccbbb"));
		System.out.println(wh.parse("aaa#cccc#bbb"));
		System.out.println(wh.parse("aaa#cccc#bbb#ddd"));
		System.out.println(wh.parse("aaa#cccc##bbb#ddd"));
		System.out.println(wh.parse("中文#宝贝#的"));
		System.out.println(wh.parse("奶奶#个腿#哈哈#建立快乐"));
		System.out.println(wh.parse("aaa#建立j阿里##j哦j哦j#ddd"));
		System.out.println(wh.parse("aaa＃看见垃圾垃圾＃＃坎坎坷坷＃ddd"));
		System.out.println(wh.parse("aaa＃看见垃圾 垃圾＃＃坎坎坷坷 ＃ddd"));
	}
}
