# coding=utf-8
import re

'''
python2.7编码
参考:http://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html
'''

s='中文'
su=u'中文'
print(s,len(s))
print(su,len(su))
us=unicode(s,'utf-8')
print('unicode:',us,len(us))
#print(unicode(su,'utf-8')) #出错

'''decode：其他编码转为unicode(如：utf-8，gbk)'''
ds=s.decode('utf-8')
print('decode:',ds,len(ds))
#print(su.decode('utf-8')) #出错

'''encode：unicode转为其他编码(如：utf-8，gbk)'''
#s.encode('utf-8') #出错
esu=su.encode('utf-8')
print('encode:',esu,len(esu))
esugbk=su.encode('gbk')
print(esugbk,len(esugbk))
#esuascii=su.encode('ascii') #出错
esuascii=su.encode('ascii','ignore')
print(esuascii,len(esuascii))

#regex
patt=re.compile('[。？]?([\x80-\xff]*'+s+'[\x80-\xff]*)[。？]?') #s换为su不能匹配
m=patt.search('前一句。取中文句子。后一句')
if m:
    print(m.group(0))
    print(m.group(1))
    #print(m.group(0),m.group(1))

patt=re.compile(u'[。？]?([\u4e00-\u9fa5]*'+su+u'[\u4e00-\u9fa5]*)[。？]?') #
m=patt.search(unicode('前一句。取中文句子。后一句','utf-8'))
if m:
    print(m.group(0))
    print(m.group(1))
    #print(m.group(0),m.group(1))
