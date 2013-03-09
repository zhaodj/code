package org.zhaodj.util;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {
	
	public static void main(String[] args) throws IOException{
		Document doc=Jsoup.parse(new File("/home/zhaodj/update/qqbuy.html"), "UTF-8");
		Element attributes=doc.getElementById("tab_desc");
		System.out.println(attributes);
	}

}
