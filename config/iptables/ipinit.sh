#!/bin/bash

#默认accept所有包  
iptables -P INPUT  ACCEPT  
iptables -P OUTPUT ACCEPT
iptables -P FORWARD ACCEPT   

#清除所有规则
iptables -F
iptables -X
iptables -Z
