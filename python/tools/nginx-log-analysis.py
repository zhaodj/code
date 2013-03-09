#!/bin/bash
import sys,re

re_ip='((?:(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))\.){3}(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d))))'
def parseIP(line):
    return re.search(re_ip,line).group(0)

def countIP(filepath):
    d={}
    fi=file(filepath)
    while True:
        line=fi.readline()
        if(len(line)==0):
            break
        ip=parseIP(line)
        if(ip in d):
            d[ip]+=1
        else:
            d[ip]=0
    print(d)
    print(len(d))

countIP(sys.argv[1])
