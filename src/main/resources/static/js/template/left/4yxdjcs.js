
function yxdjcs(res){
    var data = res[0].blockFour.resultOne;
        var result = '';
        for(var i in data){
            result+='<tr>'+
                '<td>TOP'+(parseInt(i)+1)+'</td>'+
                '<td>'+data[i].mc+'</td>'+
                '<td>'+data[i].sz+'</td>'+
                '</tr>'
        }
    $(".cityData table").html(result); 
}

$(function(){
    // 表格动画
    var speed = Math.ceil(272/8);
    setTimeout(function(){
        var $city = $(".city table");
        starts();
        function starts(){
            $(".city table").stop().animate({"top":'-272px'},8000,function(){
                setTimeout(function(){
                    $city.fadeOut(1500,function(){
                        stops($city); 
                    })
                },2000)
            });
        } 
    },5000);
    function stops(_city){
        _city.css("top","0px");
        _city.fadeIn(1000,function(){
            setTimeout(function(){
                continues();
            },5000)
            
        });
    }
    function continues(){
        var $city = $(".city table");
        $(".city table").stop().animate({"top":'-272px'},8000,function(){
            setTimeout(function(){
                $city.fadeOut(1500,function(){
                    stops($city); 
                    })
            },2000)
        });
    }
    var $on = $(".city table");
    $on.hover(function(){
        $(".city table").stop();
    },
        function(){
            var sp = 272+(parseInt($on.css("top")));
            var time = sp/speed;   
            times(time);
        }
    )
    function times(_tmie){
        var time = _tmie*1000;
        var $city = $(".city table");
        $(".city table").stop().animate({"top":'-272px'},time,function(){
            setTimeout(function(){
                $city.fadeOut(1500,function(){
                    stops($city); 
                    })
            },2000)
        });
    }     
})
 