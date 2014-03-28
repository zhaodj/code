#coding=utf-8
import sys
import socket

def start(port):
    address = ('',int(port))
    s = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
    s.bind(address)
    while True:
        data,addr = s.recvfrom(64)
        if not data:
            print('client has exist')
            break
        print(data)
    s.close()

if __name__ == '__main__':
    start(sys.argv[1])
