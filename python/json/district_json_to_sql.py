#coding=utf-8
import json
import sys

def read(fp):
    data = {}
    with open(fp) as json_file:
        data = json.load(json_file)
    return data['districts']

def handle(lst):
    parent_id = '0'
    sql = 'INSERT INTO `area`(`id`,`parent_id`,`name`,`level`)VALUES'
    level = 1
    sql = recur(lst, sql, parent_id, level)
    print(sql);

def recur(districts, sql, parent, level):
    for item in districts:
        sql = sql + "(%s,%s,'%s',%s),\n" % (item['adcode'], parent, item['name'], level)
        if 'districts' in item:
            sql = recur(item['districts'], sql, item['adcode'], level + 1)
    return sql

if __name__ == '__main__':
    handle(read(sys.argv[1]))
