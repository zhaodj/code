#coding=utf-8
import socket
import sys
host='localhost'
def send(user,msg):
	sock=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
	sock.connect((host,1024))
	sock.send(user+'\0\0'+msg+'\0') #$nick=赵道军,$headImg=http://tp4.sinaimg.cn/1973085323/180/5618313255/1\0
	print 'rebot:'+sock.recv(1024)
	sock.close()

def run():
    user='zhaodj'
    if len(sys.argv)>2 and sys.argv[2]:
        user=sys.argv[2]
    send(user,"")
    while True:
        msg=raw_input(user+':')
        if msg==':exit':
            break
        send(user,msg)

if __name__=='__main__':
    if len(sys.argv)>1 and sys.argv[1]:
        host=sys.argv[1]
    run()
