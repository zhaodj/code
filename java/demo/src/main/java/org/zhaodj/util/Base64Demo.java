package org.zhaodj.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

public class Base64Demo {
	
	public static void main(String[] args) throws Exception {
        String topParams = "bmljaz16aGFvZGowODAyJnRzPTEzNDQxNjkzNDU4MTkmdXNlcl9pZD04MjU3MDc1NQ==";
        String topSign = "r5+eaY8ufDABfdQ02Esf6A==";
        String appSecret = "4f74400944c93ae316d332b78fae6c11";
        // 先校验签名
        boolean success = verifyTopResponse(topParams, topSign, appSecret);
        if (success) {
               // 再解析参数
               System.out.println(convertBase64StringtoMap(topParams));
               // TODO 实际使用时建议再校验时间戳，比如时间误差5分钟内视为有效
        }
	}
	
	public static boolean verifyTopResponse(String topParams, String topSign,
			String appSecret) throws NoSuchAlgorithmException, IOException {
		StringBuilder result = new StringBuilder();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		result.append(topParams).append(appSecret);
		byte[] bytes = md5.digest(result.toString().getBytes("UTF-8"));
		Base64 encoder = new Base64();
		String encodedStr=new String(encoder.encode(bytes));
		return encodedStr.equals(topSign);
	}

	/**
	 * 把经过BASE64编码的字符串转换为Map对象
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	private static Map<String, String> convertBase64StringtoMap(String str) {
		if (str == null)
			return null;
		String keyvalues = null;
		try {
			keyvalues = new String(Base64.decodeBase64(URLDecoder.decode(str,
					"UTF-8").getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String[] keyvalueArray = keyvalues.split("\\&");
		Map<String, String> map = new HashMap<String, String>();
		for (String keyvalue : keyvalueArray) {
			String[] s = keyvalue.split("\\=");
			if (s == null || s.length != 2)
				return null;
			map.put(s[0], s[1]);
		}
		return map;
	}

}
