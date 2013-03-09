package org.zhaodj.trick;

import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class EventVote {
	
	public static void main(String[] args) throws UnknownHostException, MongoException{
		Mongo mongo = new Mongo( "localhost" , 27017 );
		DB db=mongo.getDB("miidooo");
		final DBCollection eeColl=db.getCollection("eventEntities");
		Timer timer=new Timer();
		TimerTask task=new TimerTask(){

			@Override
			public void run() {
				DBObject query=new BasicDBObject();
				query.put("eventId", new ObjectId("507e28d50cf29cfbc77b8898"));
				query.put("refId", new ObjectId("508104bc0cf29cfbc77bda3a"));//508a8e860cf284e6f8ec61a1
				DBObject field=new BasicDBObject("rewardCount",1);
				DBObject opt=new BasicDBObject("$inc",field);
				System.out.println("加票:508104bc0cf29cfbc77bda3a");
				eeColl.update(query, opt);
			}
			
		};
		System.out.println("任务开始");
		timer.schedule(task, 0,30*1000);
		Calendar cal=Calendar.getInstance();
		cal.set(2012, 10, 17, 20, 0, 0);
		while(true){
			Calendar now=Calendar.getInstance();
			if(now.compareTo(cal)>0){
				System.out.println("停止");
				timer.cancel();
				break;
			}
		}
	}

}
