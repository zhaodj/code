#coding=utf-8
from pyquery import PyQuery
import sys,re

output=''

def getHost(url):
    reg=re.compile('(http\:\/\/[\w\.]+)\/')
    m=reg.search(url)
    return m.group(1)

def main(start,f,host):
    while True:
        print(start)
        d=PyQuery(url=start)
        p=d('#member_list ul.member_list li span.uname')
        t=p.text()
        print(t)
        f.write(t.encode('utf-8')+'\n')
        nxt=d('#member_list .pagination a.c').nextAll('a')
        if nxt:
            start=host+nxt.attr('href')#start[0:start.rfind('?')]
            #main(nurl,f,host)
        else:
            break

if __name__ == '__main__':
    #print(getHost(sys.argv[1]))
    output=sys.argv[2]
    f=open(output,'w')
    main(sys.argv[1],f,getHost(sys.argv[1]))
    f.close()
