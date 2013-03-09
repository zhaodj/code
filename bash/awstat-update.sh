#!/bin/bash
cd /data/logs/nginx/
for i in `ls | sort`
do
    echo $i
    cp $i access.log
    perl /usr/local/awstats/tools/awstats_buildstaticpages.pl -update -config=miidooo -lang=cn -dir=/home/zhaodj/web/doc/miidooo/ -awstatsprog=/usr/local/awstats/wwwroot/cgi-bin/awstats.pl
done
