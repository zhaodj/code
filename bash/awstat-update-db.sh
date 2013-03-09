#!/bin/bash
cd /data/logs/nginx/
for i in `ls | sort`
do
    echo $i
    cp $i access.log
    perl /usr/local/awstats/wwwroot/cgi-bin/awstats.pl -update -config=miidooo
    rm -f access.log
done
