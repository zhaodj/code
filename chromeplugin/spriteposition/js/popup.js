$(function(){
    var bg=chrome.extension.getBackgroundPage();
    $('#image').change(function(e){
        var files=e.currentTarget.files;
        if(files.length==0){
            alert('未选择图片');
        }else{
            var reader=new FileReader();
            reader.onload=function(re){
                var imgData=re.target.result;
                //console.log(bg);
                //bg.sprite.openWorkplace(imgData);
                chrome.extension.sendMessage(imgData);
            }
            reader.readAsDataURL(files[0]);
        }
    });
});
