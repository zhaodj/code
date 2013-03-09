package com.zhaodj.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoderDemo {
	
	public static void main(String[] args) throws UnsupportedEncodingException{
		String encodedStr=URLEncoder.encode("http://api.renren.com/restserver.do?method=users.getInfo&v=1.0&access_token=135949|6.1c246b2493b3e4934315690c1e1ef1dc.2592000.1346842800-243747026&sig=bdbf2d0fd4d580b4e5f3c2aa1631782d","UTF-8");
		System.out.println(encodedStr);
	}

}
