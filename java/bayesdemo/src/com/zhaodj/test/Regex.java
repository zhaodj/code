package com.zhaodj.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	private static final String TEACH_COMMAND_REGEX="\u829D\u9EBB\u5F00\u95E8[:：](.+)";
	private static final String REPLY_SCRIPT_REGEX="<javascript>(.*?)</javascript>";
	private static final Pattern REPLY_SCRIPT_PATTERN=Pattern.compile(REPLY_SCRIPT_REGEX,Pattern.CASE_INSENSITIVE);
	
	public static void main(String[] args) {
		System.out.println("http://item.taobao.com/item.htm?id=17339968433".matches("item\\.taobao\\.com|detail\\.tmall\\.com"));
		Pattern pattern=Pattern.compile("(\\?|\\&)id=(\\d{1,})");
		Matcher m=pattern.matcher("http://detail.tmall.com/item.htm?spm=1008.1000032.1000012.7&id=14565257096&is_b=1&cat_id=50025145&q=");//http://item.taobao.com/item.htm?id=17339968433
		if(m.find()){
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		//Pattern p=Pattern.compile("\\[[0-9a-zA-Z\\u4e00-\\u9fa5]+\\]");
		/*System.out.println("【哈哈】".replace("【", "[").replace("】", "]").matches("\\[[0-9a-zA-Z\\u4e00-\\u9fa5]+\\]"));
		System.out.println(Arrays.toString(parseReply("哈啊和哈哈<javascript>changeHeadimg()</javascript>")));
		Pattern ptn=Pattern.compile("[j|J]ava:([_a-zA-Z0-9]+)\\s{0,}\\(([_a-zA-Z0-9\\s,]*)\\)");
		Matcher m=ptn.matcher("Java:getWeather (int 1)");
		if(m.find()){
			System.out.println(m.group(1));
			System.out.println(m.group(2));
		}
		testZhimakaimen();*/
    }  
	
	private static String[] parseReply(String input){
		String[] result=new String[2];
		Matcher matcher=REPLY_SCRIPT_PATTERN.matcher(input);
		if(matcher.find()){
			result[1]=matcher.group(1);
			result[0]=matcher.replaceAll("");
		}
		else{
			result[0]=input;
		}
		return result;
	}
	
	private static void testZhimakaimen(){
		Pattern tp=Pattern.compile(TEACH_COMMAND_REGEX);
        Matcher m=tp.matcher("芝麻开门:大家都哦啊的那就垃圾啦");
        if(m.find()){
        	System.out.println(m.group(1));
        }
        String regex = "^(13|15|18)\\d{9}$";  
        Pattern p = Pattern.compile(regex);  
              
        String[] testArr = {  
                "138",  
                "112",  
                "138000000000000",  
                "13800138000"  
        };  
      
        for (String string : testArr) {  
            testMatch(p,string);  
        }
        //=
        regex="=";
        p=Pattern.compile(regex);
        m=p.matcher("1+2+3");
        StringBuffer buffer = new StringBuffer();
        while (!m.hitEnd() && m.find())
        {
          System.out.println(m.start());
          m.appendReplacement(buffer, " ");
        }
        m.appendTail(buffer);
        System.out.println(buffer.toString());
        
        //两个空格
        buffer.delete(0, buffer.length());
        regex="  ";
        p=Pattern.compile(regex);
        m=p.matcher("  lg  ");
        while(!m.hitEnd()&&m.find()){
        	System.out.println(m.start());
            m.appendReplacement(buffer, " ");
        }
        m.appendTail(buffer);
        System.out.println(buffer.toString());
	}
  
    private static void testMatch(Pattern p, String string) {  
        Matcher matcher = p.matcher(string);  
        System.out.println("string:" + string + "---matches:"  
                + matcher.matches() + "---hitEnd:" + matcher.hitEnd());  
    }  
}
