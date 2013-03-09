var fs = require("fs");
function route(pathname,response){
	//console.log("路由请求:"+pathname);
	fs.readFile("/home/zhaodj/图片/madouwa"+pathname,"binary",function(error,file){
		if(error){
			response.writeHead(500,{"Content-Type":"text/plain"});
			response.write(error+"\n");
			response.end();
		}else{
			response.writeHead(200,{"Content-Type":"image/jpeg"});
			response.write(file,"binary");
			response.end();
		}
	});
}

exports.route = route;
