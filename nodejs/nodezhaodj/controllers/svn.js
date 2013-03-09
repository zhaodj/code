var exec=require("child_process").exec;
var childalbumCmd="svn st /home/zhaodj/workspace/childalbum";
var repos={
    'childalbum':'/home/zhaodj/workspace/childalbum',
    'base':'/home/zhaodj/workspace/midou-base'
};

exports.index=function(req,res,next){
    res.render('svn.jade',{data:getNames()});
}
exports.showStatus=function(req,res,next){
    var path=repos[req.params.name];
    if(path){
        doSvnSt('svn st '+path,path,function(response,arr){response.json({success:true,data:arr});},res);
    }else{
        res.status(404);
    }
}
exports.update=function(req,res,next){
    var path=repos[req.params.name];
    if(path){
        exec("svn up "+path, function (error, stdout, stderr){
            console.log(stdout);
            res.json({success:true,data:stdout.replace(new RegExp(path,'gm'),'').split('\n')});
        });
    }else{
        res.status(404);
    }
}
function doSvnSt(cmd,path,callback,res){
    exec(cmd, function (error, stdout, stderr){
        var arr=stdout.replace(new RegExp(path,'gm'),'').split('\n');
            console.log(arr);
        callback(res,arr);
    });
}
function getNames(){
    var result=[];
    for(var name in repos){
        result.push(name);
    }
    return result;
}
