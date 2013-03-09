#coding=utf-8
import hashlib

params=['nonce','ooodiimmiidooo','1361440814568']
params.sort()
print(hashlib.sha1(''.join(params)).hexdigest())
