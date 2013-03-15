#coding=utf-8
import os,sys,hashlib
from pymongo import Connection

def md5sum(filepath):
    f=open(filepath,'rb')
    m=hashlib.md5()
    while True:
        data=f.read(8192)
        if not data:
            break
        m.update(data)
    f.close()
    return m.hexdigest()

def upddb(imgroot):
    con=Connection()
    db=con.miidooo
    for img in db.userImages.find({'type':0,'hashcode':{'$exists':0}}):
        filepath=imgroot+img['path']
        print(filepath)
        if os.path.isfile(filepath):
            db.userImages.update({'_id':img['_id']},{'$set':{'hashcode':md5sum(filepath)}})

if __name__=='__main__':
    upddb(unicode(sys.argv[1],'utf-8'))
