package com.zhaodj.test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo implements FilenameFilter{
	
	private String expression;
	
	public FileDemo(){}
	
	public FileDemo(String exp){
		expression=exp;
	}
	
	public static void main(String[] args){
		File file=new File("/home/zhaodj/文档/语料库/机器人/xiaoming");
		FileDemo demo=new FileDemo(".*\\.aiml");
		System.out.println(Arrays.toString(file.list(demo)));
		file=new File("/home/zhaodj/图片/download/IMG_8303.jpg");
		System.out.println(file.length());
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.matches(expression);
	}

}
