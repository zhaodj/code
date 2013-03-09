#!/bin/bash
DIR=$(date +%Y.%m.%d.%H.%M)
OUTPUT="/data/bak/${DIR}"
echo "$OUTPUT"
/opt/mongodb/bin/mongodump -d miidooo -o $OUTPUT
tar zcvf ${OUTPUT}.tar.gz $OUTPUT
rm -rf $OUTPUT
#备份到其他主机
scp ${OUTPUT}.tar.gz a1dm9n@192.168.1.109:/data/db.bak
