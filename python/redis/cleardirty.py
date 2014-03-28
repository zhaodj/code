#coding=utf-8
import redis,sys

def clear(roomId):
    pool = redis.ConnectionPool(host='localhost', port=6379, db=0)
    r = redis.Redis(connection_pool=pool)
    roomKey = 'room_user#'+roomId+'#'
    res = r.zrange(roomKey,0,-1)
    for key in res:
        if r.hexists('online_user',key) == False:
            print(key)
            r.zrem(roomKey,key)

if __name__=='__main__':
    clear(sys.argv[1])
