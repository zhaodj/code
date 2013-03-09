package com.zhaodj.bayes;

/*import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;*/
import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;


import java.io.IOException;  	
import java.io.Reader;
import java.io.StringReader;


/**
* 中文分词器
*/
public class ChineseSpliter 
{
	/**
	* 对给定的文本进行中文分词
	* @param text 给定的文本
	* @param splitToken 用于分割的标记,如"|"
	* @return 分词完毕的文本
	*/
	public static String split(String text,String splitToken)
	{
		String result = "";
		/*String fieldName = "text";
		Analyzer analyzer = new IKAnalyzer();
		IndexWriter iwriter = null;
		Directory directory = null;*/
		try  	
        {
			Reader reader=new StringReader(text);
			IKSegmentation segment=new IKSegmentation(reader,true);
			/*directory = new RAMDirectory();
			iwriter = new IndexWriter(directory, analyzer, true ,IndexWriter.MaxFieldLength.LIMITED);
			Document doc = new Document();
			doc.add(new Field(fieldName, text, Field.Store.YES,Field.Index.ANALYZED));
			iwriter.addDocument(doc);
			iwriter.close();*/
			boolean hasNext=true;
			while(hasNext){
				Lexeme lexeme=segment.next();
				if(lexeme!=null){
					result+=lexeme.getLexemeText()+splitToken;
				}
				else{
					hasNext=false;
				}
			}
			System.out.println("分词结果："+result);
		}  	
        catch (IOException e)  	
        { 	
        	e.printStackTrace(); 	
        } 	
        return result;
	}
	
	public static void main(String[] args){
		split("去掉文档中无意思的词语也是必须的一项工作,这里简单的定义了一些常见的停用词，并根据这些常用停用词在分词时进行判断。","|");
	}
}