package com.zhaodj.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Time {
	
	public static void main(String[] args) throws ParseException{
		Calendar calendar=Calendar.getInstance();
		System.out.println(calendar.get(Calendar.MILLISECOND));
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),0,0,0);
		System.out.println(calendar.getTime());
		System.out.println(Math.random()*1000);
		Date now=new Date();
		int score=score(0,now);
		List<String> roles=new ArrayList<String>();
		roles.add("user");
		System.out.println(score);
		System.out.println(base(score(0,now),now));
		score+=1000*100;
		System.out.println(incScore(roles,score,100,now));
		roles.add("editor");
		System.out.println(incScore(roles,score,100,now));
		System.out.println(score(1,now));
		System.out.println(base(score(1,now),now));
		System.out.println(score(2,now));
		System.out.println(base(score(2,now),now));
		System.out.println(score(10,now));
		System.out.println(base(score(10,now),now));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.toHexString(new Date().getTime()));
		List<SortItem> list=new ArrayList<SortItem>();
		list.add(new SortItem(1,"2012-06-01 11:11:11"));
		list.add(new SortItem(2,"2012-06-01 11:11:11"));
		list.add(new SortItem(5,"2012-06-01 11:11:11"));
		list.add(new SortItem(3,"2012-06-02 11:11:11"));
		list.add(new SortItem(13,"2012-06-01 12:11:11"));
		list.add(new SortItem(25,"2012-06-02 6:11:11"));
		list.add(new SortItem(50,"2012-05-24 11:11:11"));
		list.add(new SortItem(2,"2012-06-24 11:11:11"));
		list.add(new SortItem(0,"2012-06-25 11:11:11"));
		Collections.sort(list,new Comparator<SortItem>(){

			@Override
			public int compare(SortItem arg0, SortItem arg1) {
				return (int) (arg1.getSeq()-arg0.getSeq());
			}
			
		});
		for(SortItem item:list){
			System.out.println(item);
		}
	}
	
	private static int score(int like,Date time){
		return (int) (Math.pow(like, 1.5)*1000+time.getTime()/3600);
	}
	
	private static int base(int score,Date time){
		int val=(int)(score-(time.getTime()/3600))/1000;
		return val==0?0:(int)Math.ceil(Math.pow(val, 1/1.5));
	}
	
	public static double sort(long hit,String time){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			long from = format.parse(time).getTime()/3600000;
			return Math.pow(1+hit, 1.5)+from;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	private static int incScore(List<String> roles,int score,int scoreAddition,Date time){
		return score(base(score-scoreAddition*1000,time)+getWeight(roles),time)+scoreAddition*1000;
	}
	
	private static int getWeight(List<String> roles){
		if(roles.contains("editor")||roles.contains("admin")){
			return 10;
		}
		return 1;
	}
	
	public static class SortItem{
		private long hit;
		private String time;
		private double seq;
		
		public SortItem(long hit,String time){
			this.hit=hit;
			this.time=time;
			this.seq=sort(hit,time);
		}
		
		public long getHit() {
			return hit;
		}
		public void setHit(long hit) {
			this.hit = hit;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}

		public double getSeq() {
			return seq;
		}

		public void setSeq(double seq) {
			this.seq = seq;
		}
		
		@Override
		public String toString(){
			return "hit="+hit+",time="+time+",seq="+seq;
		}
		
	}
}
