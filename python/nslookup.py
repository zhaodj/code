#coding=utf-8
import subprocess
for num in range(1, 1000):
    url = "dl-client" + str(num) + ".dropbox.com"
    cmd = "nslookup -vc " + url + " 8.8.8.8"
    p = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT) #用Python来调用系统命令
    ip = p.stdout.readlines()[-2].replace("Address: ", "").replace("\n", "") #过滤出ip
    print ip + " " + url  #打印结果为  204.236.220.23 dl-client7.dropbox.com

