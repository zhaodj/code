import markdown
import sys,codecs


output = """<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
"""
mkin = codecs.open(sys.argv[1], mode="r", encoding="utf-8")
output += markdown.markdown(mkin.read())
mkin.close()

output += """</body>

</html>
"""
print output
output_file = codecs.open(sys.argv[2], "w", encoding="utf-8", errors="xmlcharrefreplace")
output_file.write(output)
output_file.close()
