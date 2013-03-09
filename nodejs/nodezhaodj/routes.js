var home=require('./controllers/home');
var user=require('./controllers/user');
var download=require('./controllers/download');
var svn=require('./controllers/svn');

exports=module.exports=function(app){
    app.get('/',home.index);
    app.get('/download',download.index);
    app.get('/download/:pathname',download.downfile);
    app.get('/user/:name',user.index);
    app.get('/svn',svn.index);
    app.post('/svn/:name/status',svn.showStatus);
    app.post('/svn/:name/update',svn.update);
};
