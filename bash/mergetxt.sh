#!/bin/bash
cd $1
for i in `ls`
do
    echo $i
    cat $i >> $2
done
