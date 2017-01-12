#!/bin/bash

#放行本机设备
iptables  -t filter  -I  INPUT 1 -i lo  -j ACCEPT   
iptables  -t filter  -I  OUTPUT 1 -o lo  -j ACCEPT   
#为了事先采用22端口链接ssh，所以22端口也放行先，ssh配置好之后，drop掉这两条规则即可。
iptables -A INPUT  -p tcp --dport 22 -j ACCEPT  
iptables -A OUTPUT  -p tcp --sport 22 -j ACCEPT  
iptables -A INPUT  -p tcp --sport 22 -j ACCEPT  
iptables -A OUTPUT  -p tcp --dport 22 -j ACCEPT  
iptables -A INPUT  -p tcp --dport 60806 -j ACCEPT  
iptables -A OUTPUT  -p tcp --sport 60806 -j ACCEPT  


#默认drop 所有包  
iptables -P INPUT  DROP  
iptables -P OUTPUT DROP  
iptables -P FORWARD DROP   

#让exim可以使用smtp发送邮件
iptables -A OUTPUT -p tcp --sport 1024:65535 --dport 25 -m state --state NEW,ESTABLISHED -j ACCEPT
iptables -A INPUT -p tcp  --sport 25 --dport 1024:65535 -m state --state ESTABLISHED -j ACCEPT

##本机可以上网，udp协议的。
#dns   
iptables -A OUTPUT -p udp   --dport 53 -j ACCEPT  
iptables -A INPUT -p udp --sport 53  -j ACCEPT  
#上网  
iptables -A OUTPUT -p tcp --dport 80 -j ACCEPT  
iptables -A INPUT -p tcp --sport 80 -j ACCEPT  

#我要使用ntpdate来校时，所以开放ntp的udp。
iptables -A OUTPUT -p udp --dport 123 -j ACCEPT
iptables -A INPUT -p udp --sport 123 -j ACCEPT

#本机开启web server  ，tcp协议的
iptables -A INPUT -p tcp  --dport 80 -j ACCEPT   
iptables -A OUTPUT  -p tcp  --sport 80 -j ACCEPT  

#本机开启web 服务  ，tcp协议的，https。如果不需要https就不要开启这个端口。
iptables -A INPUT -p tcp  --dport 443 -j ACCEPT   
iptables -A OUTPUT  -p tcp  --sport 443 -j ACCEPT   

#ssh上网
iptables -A INPUT -p tcp --sport 443 -j ACCEPT
iptables -A OUTPUT -p tcp --dport 443 -j ACCEPT

#svn
iptables -A INPUT -p tcp  --dport 3690 -j ACCEPT   
iptables -A OUTPUT -p tcp  --sport 3690 -j ACCEPT   

#web server,8000
iptables -A INPUT -p tcp  --dport 8000 -j ACCEPT   
iptables -A OUTPUT  -p tcp  --sport 8000 -j ACCEPT  
#web server,8888
iptables -A INPUT -p tcp  --dport 8888 -j ACCEPT   
iptables -A OUTPUT  -p tcp  --sport 8888 -j ACCEPT  
#web server,9999
iptables -A INPUT -p tcp  --dport 9000 -j ACCEPT   
iptables -A OUTPUT  -p tcp  --sport 9000 -j ACCEPT  
#mongodb
iptables -A INPUT -p tcp  --dport 27017 --source 192.168.1.0/255.255.255.0 -j ACCEPT   
iptables -A OUTPUT  -p tcp  --sport 27017 --destination 192.168.1.0/255.255.255.0 -j ACCEPT  

# dhcp ，使用dhcp 获得ip ,  
# dhcp  
iptables -A INPUT -p udp --sport 67 --dport 68 -j ACCEPT  

# 以下是∶你可以送信给别人
iptables -A OUTPUT -o eth0 -p tcp --sport 1024:65535 -d any/0 --dport 587 -j ACCEPT
iptables -A INPUT -i eth0 -p tcp ! --syn -s any/0 --sport 587 --dport 1024:65525 -j ACCEPT 

##防止ssh攻击
iptables -I INPUT -p tcp --dport 22 -m state --state NEW -m recent --name sshprobe --set -j ACCEPT
iptables -I INPUT -p tcp --dport 22 -m state --state NEW -m recent --name sshprobe --update --seconds 60 --hitcount 3 --rttl -j DROP
