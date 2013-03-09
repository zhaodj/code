# coding=utf-8
import httplib,json,time

httpConn=httplib.HTTPConnection("192.168.1.119")
for oi in range(1,30):
    httpConn.request("GET","/public/nick/verify?nick=zhaodjjjj")
    res=httpConn.getresponse()
    data=res.read()
    print(res.status,res.reason)
    if res.status==200:
        obj=json.loads(data)
        print(obj["success"])
    #time.sleep(2)
