#coding=utf-8
import sys,re

def extract(filepath):
    fi=file(filepath)
    regex=re.compile('[^。？，；]*\[[\u4e00-\u9fa5]+\][^。？，；]*')#[。？，]?([^。？，；]*\[[\u4e00-\u9fa5]+\][^。？，；]*)[。？，]?
    while True:
        line=fi.readline()
        if len(line)==0:
            break
        m=regex.search(line)
        print(line)
        if m:
            print(m.group(1))


if __name__ == '__main__':
    extract(unicode(sys.argv[1],'utf-8'))
