package com.zhaodj.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {
	
	public static class Word{
		public String word;
		public String pos;
		
		public Word(String word,String pos){
			this.word=word;
			this.pos=pos;
		}
		
		@Override
		public boolean equals(Object o){
			if(o instanceof Word){
				Word obj=(Word)o;
				return this.word.equals(obj.word)&&this.pos.equals(obj.pos);
			}
			return false;
		}
		
		@Override
		public int hashCode(){
			return this.word.hashCode()+this.pos.hashCode();
		}
		
		@Override
		public String toString(){
			return this.word+"/"+this.pos;
		}
	}
	
	public static void main(String[] args){
		Map<Word,Integer> demo=new HashMap<Word,Integer>();
		demo.put(new Word("你","n"), 1);
		demo.put(new Word("好","adj"), 2);
		demo.put(new Word("好","ad"), 3);
		demo.put(new Word("你","n"), 4);
		if(demo.containsKey(new Word("你","n"))){
			demo.put(new Word("我","n"), 5);
		}
		Iterator<Map.Entry<Word,Integer>> iter=demo.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<Word, Integer> entry=iter.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

}
