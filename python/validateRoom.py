#coding=utf-8
import redis
import sys
import json
import urllib
import urllib2


SERVERS = {
    'liveshow-h01-1': 'h01.bobo.163.com:8180',
    'liveshow-h01-2': 'h01.bobo.163.com:8181',
    'liveshow-h01-3': 'h01.bobo.163.com:8182',
    'liveshow-h01-4': 'h01.bobo.163.com:8183',
    'liveshow-h02-1': 'h02.bobo.163.com:8180',
    'liveshow-h02-2': 'h02.bobo.163.com:8181',
    'liveshow-h02-3': 'h02.bobo.163.com:8182',
    'liveshow-h02-4': 'h02.bobo.163.com:8183',
    'liveshow-h03-1': 'h03.bobo.163.com:8180',
    'liveshow-h03-2': 'h03.bobo.163.com:8181',
    'liveshow-h03-3': 'h03.bobo.163.com:8182',
    'liveshow-h03-4': 'h03.bobo.163.com:8183',
    'liveshow-h04-1': 'h04.bobo.163.com:8180',
    'liveshow-h04-2': 'h04.bobo.163.com:8181',
    'liveshow-h04-3': 'h04.bobo.163.com:8182',
    'liveshow-h04-4': 'h04.bobo.163.com:8183',
    'liveshow-h05-1': 'h05.bobo.163.com:8180',
    'liveshow-h05-2': 'h05.bobo.163.com:8181',
    'liveshow-h05-3': 'h05.bobo.163.com:8182',
    'liveshow-h05-4': 'h05.bobo.163.com:8183',
    'liveshow-h06-1': 'h06.bobo.163.com:8180',
    'liveshow-h06-2': 'h06.bobo.163.com:8181',
    'liveshow-h06-3': 'h06.bobo.163.com:8182',
    'liveshow-h06-4': 'h06.bobo.163.com:8183'
}


def validate(roomId,remove):
    offlineUsers = []
    dirtyUsers = []
    pool = redis.ConnectionPool(host='localhost', port=6379, db=0)
    r = redis.Redis(connection_pool=pool)
    roomKey = 'room_user#' + roomId + '#'
    print('房间人数:' + str(r.zcard(roomKey)))
    res = r.zrange(roomKey, 0, -1)
    for key in res:
        val = r.hget('online_user', key)
        if val is None:
            offlineUsers.append(key)
            if remove:
                r.zrem(roomKey,key)
        else:
            valJson = json.loads(val)
            url = 'http://' + SERVERS[valJson['hostname']] + '/host/exists.do'
            data = {'userId': key}
            req = urllib2.Request(url, urllib.urlencode(data))
            response = urllib2.urlopen(req)
            body = response.read()
            bodyJson = json.loads(body)
            if bodyJson['exists'] == 0:
                dirtyUsers.append(key)
                if remove:
                    r.zrem(roomKey,key)
    print('缓存房间里有，缓存在线用户里没有:')
    print(offlineUsers)
    print('缓存里有，host server上没有:')
    print(dirtyUsers)


if __name__ == '__main__':
    remove = 0
    if len(sys.argv) > 2 :
        remove = sys.argv[2]
    validate(sys.argv[1], remove)
