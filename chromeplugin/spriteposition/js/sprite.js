$(function(){
    $('#image').change(function(e){
        var files=e.currentTarget.files;
        if(files.length==0){
            alert('未选择图片');
        }else{
            var reader=new FileReader();
            reader.onload=function(re){
                var imgData=re.target.result;
                draw(imgData);
            }
            reader.readAsDataURL(files[0]);
        }
    });
});
function draw(imgData){
    var $sprite = $("#sprite");
    $sprite.empty();
    //var context = $sprite[0].getContext("2d");
    var $img = $('<img>', { src: imgData});
    $sprite.append($img);
    $img.load(function(){
        $(this).mouseover(function(){
            $('#position').show();
        });
        $(this).mousemove(function(e){
            $('#position').css({top:e.pageY+15,left:e.pageX+15}).text(e.offsetX+','+e.offsetY);
        });
        $(this).mouseout(function(){
            $('#position').hide();
        });
    });
}
