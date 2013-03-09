var patrnTopic=/http:\/\/www\.zhihu\.com\/class\/[\w]*\/topics/;
var patrn=/\/topic\/[^\/]*/;
var event = document.createEvent("MouseEvents");
event.initMouseEvent("click", true, true, window,0, 0, 0, 0, 0,false, false, false, false,0, null);
var iter=setInterval(function(){more(event);},1000);
function more(e){
	var xlxw=document.getElementById("xlxw");	
	console.log(xlxw.innerHTML);
	if(xlxw&&xlxw.style.display!="none"){
		xlxw.dispatchEvent(event);
	}
	else{
		clearInterval(iter);
		console.log(document.location.href);
		if(patrnTopic.exec(document.location.href)){
			updateUrl();
		}
		document.body.style.backgroundColor="#FFFFBB";
	}
}
function updateUrl(){
	$(".xyp a").map(function(){
		var href=$(this).attr("href");
		 if(patrn.exec(href)){
				$(this).attr("href",href+"/top");
			}
	});
}
