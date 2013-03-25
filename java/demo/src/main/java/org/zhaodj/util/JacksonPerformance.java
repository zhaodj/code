package org.zhaodj.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 自定义类与HashMap序列化json性能对比
 * @author zhaodj
 *
 */
public class JacksonPerformance {
	
	private static ObjectMapper mapper=new ObjectMapper();
	
	private int code;
	private String message;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
		int times=100000;
		long start=System.nanoTime();
		for(int i=0;i<times;i++){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("code", 502);
			map.put("message", "服务器内部错误");
			mapper.writeValueAsString(map);
		}
		System.out.println((System.nanoTime()-start));
		start=System.nanoTime();
		for(int i=0;i<times;i++){
			JacksonPerformance jp=new JacksonPerformance();
			jp.setCode(502);
			jp.setMessage("服务器内部错误");
			mapper.writeValueAsString(jp);
		}
		System.out.println((System.nanoTime()-start));
	}
	

}
