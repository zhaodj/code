#coding=utf-8
import sys
import xml.etree.ElementTree as ET

def handle(fp):
    tree = ET.parse(fp)
    root = tree.getroot()
    print('INSERT INTO `area`(`id`,`code`,`parent_id`,`name`,`level`)VALUES')
    for child in root:
        pid = child.attrib['p_id']
        for city in child:
            if city.tag == 'pn':
                pname = city.text
                print("(%s,%s,%s,'%s',%s)," % (pid, pid, '0', pname, 1))
                #print(pid, pname)
            elif city.tag == 'c':
                cid = city.attrib['c_id']
                for district in city:
                    if district.tag == 'cn':
                        cname = district.text
                        print("(%s,%s,%s,'%s',%s)," % (cid, cid, pid, cname, 2))
                        #print(cid, cname)
                    elif district.tag == 'd':
                        did = district.attrib['d_id']
                        print("(%s,%s,%s,'%s',%s)," % (did, did, cid, district.text, 3))
                        #print(district.attrib['d_id'], district.text)

if __name__ == '__main__':
    handle(sys.argv[1])
