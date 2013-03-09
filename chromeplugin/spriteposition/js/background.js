var sprite={
    init:function(){
        chrome.browserAction.onClicked.addListener(function(){
            chrome.tabs.create({url:'sprite.html'});
        });
    }
};
sprite.init();
