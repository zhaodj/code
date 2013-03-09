package org.zhaodj.util;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class HtmlFilter {
	
	public static void main(String[] args){
		System.out.println(StringEscapeUtils.escapeHtml4("<span>ahahahah</span>"));
		System.out.println(StringEscapeUtils.escapeHtml4("<a href='http://www.miidooo.com'>ahahahah</a>"));
		System.out.println(StringEscapeUtils.escapeHtml4("<a href='http://www.miidooo.com'>ahahahah</a>\n打算打法撒发"));
		String unsafe = 
				  "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a>打法\n接口垃圾</p>";
		String safe = Jsoup.clean(unsafe, Whitelist.none());
		System.out.println(safe);
				// now: <p><a href="http://example.com/" rel="nofollow">Link</a></p>
	}

}
