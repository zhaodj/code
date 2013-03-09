#coding=utf-8
import re
import simplejson
import sys

reload(sys)
sys.setdefaultencoding("utf8")

def ipToInt(ip):
    arr=re.split('\.',ip)
    return (int(arr[0])<<24)+(int(arr[1])<<16)+(int(arr[2])<<8)+int(arr[3])

def toJson(path,out):
    fi=file(path)
    o=open(out,"w")
    i=1
    while True:
        line=fi.readline()
        if len(line)==0:
            break
        strs=re.split('\s{1,}',line.decode("utf-8").strip())
        if len(strs)==0:
            continue
        arrlen=len(strs)
        if(arrlen>=3):
            json={
                    '_id':i,
                    'begin':ipToInt(strs[0]),
                    'end':ipToInt(strs[1]),
                    'beginIp':strs[0],
                    'endIp':strs[1],
                    'location':" ".join(strs[2:arrlen-1]),
                    'isp':strs[arrlen-1]
                    }
            jsonstr=simplejson.dumps(json,ensure_ascii=False)
            #print jsonstr
            o.write(jsonstr)
            o.write("\n")
            i=i+1
    o.close()

toJson("/home/zhaodj/temp/ip.txt","/home/zhaodj/temp/ipdb.json")
