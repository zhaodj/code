#coding=utf-8
import sys,re

def extract(filepath):
    fi=file(filepath)
    key=filepath[filepath.rfind('/')+1:filepath.index('.txt')]
    regex=re.compile('[。？]?(.*'+key.encode('utf-8')+'.*)[。？]?')
    while True:
        line=fi.readline()
        if len(line)==0:
            break
        print(regex.pattern)
        m=regex.search(line)
        print(line)
        if m:
            print(m.group(1))


if __name__ == '__main__':
    extract(unicode(sys.argv[1],'utf-8'))
