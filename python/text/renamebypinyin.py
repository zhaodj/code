#coding=utf-8
import sys,os,pypinyin

def py(p):
    return p['by']

def rename(filepath):
    files = []
    for file in os.listdir(filepath):
        if os.path.isfile(os.path.join(filepath,file)) == True and file.find('.jpg') > 0:
            print(file)
            files.append({'file':file,'by':pypinyin.pinyin(file,style=pypinyin.NORMAL)})
    fs=sorted(files,key = py)
    i = 0
    for f in fs:
        i = i+1;
        print(f['by'])
        os.rename(os.path.join(filepath,f['file']),os.path.join(filepath,'%s_%d_%s' % (u'赵妮',i,f['file'])))


if __name__ == '__main__':
    rename(unicode(sys.argv[1],'utf-8'))
