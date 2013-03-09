var fs=require("fs");
var path=require("path");
var config=require('../config').config;
var mimeTypes = {
  "css": "text/css",
  "gif": "image/gif",
  "html": "text/html",
  "ico": "image/x-icon",
  "jpeg": "image/jpeg",
  "jpg": "image/jpeg",
  "js": "text/javascript",
  "json": "application/json",
  "pdf": "application/pdf",
  "png": "image/png",
  "svg": "image/svg+xml",
  "swf": "application/x-shockwave-flash",
  "tiff": "image/tiff",
  "txt": "text/plain",
  "wav": "audio/x-wav",
  "wma": "audio/x-ms-wma",
  "wmv": "video/x-ms-wmv",
  "xml": "text/xml"
};

exports.index=function(req,res,next){
    var result=getAllFiles(config.downloadDir,result);
    res.render('download.jade',{data:result});
};

/**
 * 下载文件
* 参考:http://cnodejs.org/topic/4f16442ccae1f4aa27001071
* */
exports.downfile=function(req,res,next){
    var realPath=config.downloadDir+'/'+req.params.pathname;
    fs.exists(realPath, function (exists) {
        if (!exists) {
            res.writeHead(404, {'Content-Type': 'text/plain'});
            res.write("This request URL " + pathname + " was not found on this server.");
            resend();
        } else {
            var ext=path.extname(realPath);
            ext=ext?ext.slice(1):'unknow';
            fs.readFile(realPath, "binary", function(err, file) {
                if (err) {
                    res.writeHead(500, {'Content-Type': 'text/plain'});
                    res.end(err);
                } else {
                    res.writeHead(200, {'Content-Type': mimeTypes[ext] || "text/plain"});
                    res.write(file, "binary");
                    res.end();
                }
            });
        }
    });
};

function getAllFiles(root){
    var result=[],files=fs.readdirSync(root)
    files.forEach(function(file){
        var pathname=root+"/"+file,stat=fs.lstatSync(pathname);
        if(stat===undefined){
            return;
        }
        if(!stat.isDirectory()){
            result.push({href:"/download/"+file,name:file});
        }
        else{
        }
    });
    return result;
}
