#coding=utf-8
import markdown
import sys,codecs

#根据markdown文件生成html

output = """<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <style type="text/css">
    .toc{
        position:absolute;
        top:10px;
        right:10px;
        padding-right:20px;
        border:1px solid black;
    }
    </style>
</head>
<body>
"""
mkin = codecs.open(sys.argv[1], mode="r", encoding="utf-8")
output += markdown.markdown(mkin.read(),extensions=['extra','toc'])
mkin.close()

output += """</body>
</html>
"""
#print output

output_file = codecs.open(sys.argv[2], "w", encoding="utf-8", errors="xmlcharrefreplace")
output_file.write(output)
output_file.close()
