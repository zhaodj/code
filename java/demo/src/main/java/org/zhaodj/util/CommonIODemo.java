package org.zhaodj.util;

import org.apache.commons.io.FilenameUtils;

public class CommonIODemo {
	
	public static void main(String[] args){
		String url="http://tp4.sinaimg.cn/1973085323/180/39998938676/1";
		System.out.println(FilenameUtils.getExtension(url));
	}

}
