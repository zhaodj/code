var express=require("express");
var app=require("express").createServer();
var routes=require('./routes');
var config=require('./config').config;
app.configure(function(){
    app.use(express.methodOverride());
    app.use(express.bodyParser());
    app.use(app.router);
    app.use("/download",express.static(__dirname+"/download"));
    app.use(express.static(__dirname+"/static"));
    app.set('view options', { layout: false });
});

app.helpers({
    config:config
});

routes(app);

app.listen(config.port);

