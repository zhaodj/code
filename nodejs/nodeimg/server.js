var http = require("http");
var url = require("url");

function start(route){
	http.createServer(function(request,response){
		var pathname = url.parse(request.url).pathname;
		console.log("请求路径:"+pathname);
		request.addListener("end",function(){
			route(pathname,response);
		});
	}).listen(8888);
}

exports.start = start;
