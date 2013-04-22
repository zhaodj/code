#coding=utf-8
import sys,os,shutil
import time as _time
from datetime import datetime

'''
遍历目录导出指定时间点之后修改过的文件及目录
'''

def recur(filename,filepath,stime,outdir):
    if os.path.isdir(filepath):
        list=os.listdir(filepath)
        for item in list:
            recur(item,os.path.join(filepath,item),stime,os.path.join(outdir,filename))
    else:
        mtime=os.path.getmtime(filepath) #修改时间
        if stime<mtime:
            if not os.path.exists(outdir):
                print(u'创建目录:'+outdir)
                os.makedirs(outdir)
            dst=os.path.join(outdir,filename)
            print(filepath,dst)
            shutil.copyfile(filepath,dst)

def export(rootdir,outdir,start):
    print(start)
    if os.path.isdir(rootdir):
        stime=datetime.strptime(start,"%Y-%m-%d %H:%M:%S") #输入日期转换
        list=os.listdir(rootdir)
        for item in list:
            recur(item,os.path.join(rootdir,item),_time.mktime(stime.timetuple()),outdir)
    else:
        print(rootdir+u'不是目录')

if __name__=='__main__':
    export(unicode(sys.argv[1],'utf-8'),unicode(sys.argv[2],'utf-8'),unicode(sys.argv[3],'utf-8'))
