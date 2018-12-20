// commons.rightQuery({}).then(function(res){
function fwjg(res){
    var num = 0;
    $("body").on('click','.container-i',function(){
        var _this = $(this);
        if(num == 1){
            $("#tjy").stop().fadeOut(1000,function(){
                _this.prev(".container-head").html("金牌服务机构TOP 5");
                $(".fwjgData").stop().fadeIn(1000);
                num = 0;
            });
        }
    });
    $("body").on('click','.container-em',function(){
        var _this = $(this);
        if(num == 0){
            $(".fwjgData").stop().fadeOut(1000,function(){
                _this.parent().find(".container-head").html("金牌调解员TOP 5");
                $("#tjy").stop().fadeIn(1000);
                num = 1;
            });
            
        }
    });
    // 加载标题 
    var date = res[0].blockTwo.resultOne;
    var a = date.sz;
    var b = 5 - parseInt(a.length);
    var releft = '';
    for(var i=0;i<b;i++){
        releft+="<li>0</li>"
    }
    for(var i in a){
        releft+="<li>"+a[i]+"</li>"
    }
    $('#fwjg').parent().find('.stat-data .first').html(releft);


    var dates = res[0].blockTwo.resultTwo;
    var a1 = dates.sz;
    var b1 = 5 - parseInt(a1.length);
    var reright = '';
    for(var i=0;i<b1;i++){
        reright+="<li>0</li>"
    }
    for(var i in a1){
        reright+="<li>"+a1[i]+"</li>"
    }
    $('#fwjg').parent().find('.stat-data .second').html(reright);

    // 加载表格数据
    var data = res[0].blockTwo.resultThree;
    var result = '';
    var re = '';
    result+="<tr><td>排名</td><td>服务机构</td><td>成功率</td></tr>";
    re+="<tr><td>排名</td><td>姓名</td><td>案件量</td></tr>";
    for(var i in data){
        if(i<5){
            result+='<tr>'+
            '<td>TOP'+(parseInt(i)+1)+'</td>'+
            '<td>'+data[i].mc+'</td>'+
            '<td>'+data[i].sz+'</td>'+
            '</tr>'
        } else {
            re+='<tr>'+
            '<td>TOP'+(parseInt(i)-4)+'</td>'+
            '<td>'+data[i].mc+'</td>'+
            '<td>'+data[i].sz+'</td>'+
            '</tr>'
        } 
    }
    $(".fwjgData table").html(result);
    $('#tjy table').html(re);
}
