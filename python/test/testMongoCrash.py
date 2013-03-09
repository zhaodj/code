#coding=utf-8
import time,datetime,codecs
from pymongo import Connection
from bson.dbref import DBRef
from bson.objectid import ObjectId

'''测试mongodb在使用kill -9杀死mongod进程时数据丢失情况'''
conn=Connection()
db=conn.test
db.posts.drop()
db.comments.drop()
posts=db.posts
comments=db.comments
seq=0;
output_file = codecs.open("done.txt", "w", encoding="utf-8", errors="xmlcharrefreplace")
while seq<100000:
    postId=ObjectId()
    post={"_id":postId,"seq":seq,"time":datetime.datetime.utcnow()}
    posts.insert(post)
    output="seq:"+str(seq)+",time:"+str(datetime.datetime.utcnow())+"\n"
    for i in range(0,10):
        commentId=ObjectId()
        comment={"_id":commentId,"post":DBRef("posts",postId),"seq":seq,"num":i}
        comments.insert(comment)
        output+="    content:"+str(seq)+str(i)+"\n"
    output_file.write(output)
    print seq
    seq=seq+1
    time.sleep(0.01)
output_file.close()
