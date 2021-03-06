#coding=utf-8
import sys,re

def extract(filepath):
    fi=file(filepath)
    key=filepath[filepath.rfind('/')+1:filepath.index('.txt')]
    regex=re.compile(u'[。？“”]?([\u4e00-\u9fa5]*'+key+u'[\u4e00-\u9fa5]*)[。？“”]?')
    while True:
        line=fi.readline()
        if len(line)==0:
            break
        m=regex.search(line.decode('utf-8'))
        print(line)
        if m:
            print(m.group(1))


if __name__ == '__main__':
    extract(unicode(sys.argv[1],'utf-8'))
