#coding=utf-8
import sys

def main(ipt,opt):
    fi=open(ipt)
    fo=open(opt,'w')
    while True:
        line=fi.readline()
        if len(line)==0:
            break
        arr=line.split()
        for s in arr:
            fo.write(s+'\n')
            print(s)
    fi.close()
    fo.close()

if __name__ == '__main__':
    main(sys.argv[1],sys.argv[2])
