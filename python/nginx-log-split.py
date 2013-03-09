# coding=utf-8
from datetime import datetime
import re,sys,os

'''按照日期分割nginx日志文件'''
re_time='\d{2}\/\w{3}\/\d{4}:\d{2}:\d{2}:\d{2}'
str_time='%d/%b/%Y:%H:%M:%S'

def parseTime(line):
    t=re.search(re_time,line).group(0)
    return datetime.strptime(t, str_time)

def merge(file1,file2):
    out=open(file2,'a')
    fi=file(file1)
    while True:
        line=fi.readline()
        if(len(line)==0):
            break
        out.write(line)
    out.close()
    os.remove(file1)

def output(temp,filepath):
    if os.path.exists(filepath):
        merge(temp,filepath)
    else:
        os.rename(temp,filepath)


def split(filepath,outpath):
    fi=file(filepath)
    temp=outpath+'/temp.log'
    o=open(temp,'w')
    time_local=''
    while True:
        line=fi.readline()
        if(len(line)==0):
            o.close()
            output(temp,outpath+'/access'+time_local+'.log')
            break
        cur_time=parseTime(line).date().isoformat()
        if(time_local==''):
            time_local=cur_time
            o.write(line)
        elif(time_local==cur_time):
            o.write(line)
        else:
            o.close()
            output(temp,outpath+'/access'+time_local+'.log')
            o=open(temp,'w')
            time_local=cur_time
            print(time_local)

split(sys.argv[1],sys.argv[2])
