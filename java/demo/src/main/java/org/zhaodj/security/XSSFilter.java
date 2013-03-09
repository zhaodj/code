package org.zhaodj.security;

import org.apache.commons.lang3.StringEscapeUtils;

public class XSSFilter {
	
	public static void main(String[] args){
		System.out.println(StringEscapeUtils.escapeHtml4("aaa克林顿积分卡拉级"));
		System.out.println(StringEscapeUtils.escapeHtml4("<script>alert(\"aaaa\")</script>"));
		System.out.println(StringEscapeUtils.escapeHtml4(null));
		System.out.println(StringEscapeUtils.escapeEcmaScript("aaa克林顿积分卡拉级"));
		System.out.println(StringEscapeUtils.escapeHtml4(".%22%3C\\/script%3E%3Cscript%3Ealert(111);%3C\\/script%3E"));
		System.out.println(StringEscapeUtils.unescapeHtml4(".%22%3C\\/script%3E%3Cscript%3Ealert(111);%3C\\/script%3E"));
	}

}
