#!/bin/bash
DIR=$(date -d yesterday +%Y%m%d)
FILE="/data/logs/nginx/access.log-${DIR}"
echo $FILE
scp $FILE a1dm9n@192.168.1.109:/data/logs/nginx
