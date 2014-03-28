#coding=utf-8
import sys
import socket

def call(num):
    address = ('127.0.0.1',7000)
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    data = b'\x88\x77\x66\x55\x01\x01\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00' + str.encode(num) +b'\x00'
    print(data)
    s.sendto(data,address)

if __name__ == '__main__':
    call(sys.argv[1])
