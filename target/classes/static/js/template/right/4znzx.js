// commons.rightQuery({}).then(function(res){
function znzx(res){

    var dataX = [];
    var dataY1 = [];
    var dataY2 = [];
    // 加载标题
    var title1 = res[0].blockFour.resultOne.sz;
    if(title1.length<5){
        var b = 5 - parseInt(title1.length);
        var releft = '';
        for(var i=0;i<b;i++){
            releft+="<li>0</li>"
        }
        for(var i in title1){
            releft+="<li>"+title1[i]+"</li>"
        }
        $('#znzx').parent().find('.stat-data .first').html(releft);
        $('#znzx').parent().find(".li-content-title a").eq(0).hide();
    } else {
        var releft = '';
        var a = title1.substring(0,title1.length-2);  
        var str = parseInt(title1)/10000 + "";
        var strs = str.indexOf(".");
        var st = str.substring(0,strs+3);
        var b = 5-a.length;
        for(var i=0;i<b;i++){
            releft+="<li>0</li>"
        }
        for(var i=0;i<st.length;i++){
            releft+="<li>"+st[i]+"</li>";    
        } 
        $('#znzx').parent().find('.stat-data .first').html(releft); 
        $('#znzx').parent().find(".li-content-title a").eq(0).show();
        $("#znzx").parent().find('.stat-data .first li').eq(3).addClass("on")
    }
    
    
    var title2 = res[0].blockFour.resultTwo.sz;
    if(title2.length<5){
        var b = 5 - parseInt(title2.length);
        var reright = '';
        for(var i=0;i<b;i++){
            reright+="<li>0</li>"
        }
        for(var i in title2){
            reright+="<li>"+title2[i]+"</li>"
        }
        $('#znzx').parent().find('.stat-data .second').html(reright);
        $('#znzx').parent().find(".li-content-title a").eq(1).hide();
    } else {
        var reright = '';
        var a = title2.substring(0,title2.length-2);  
        var str = parseInt(title2)/10000 + "";
        var strs = str.indexOf(".");
        var st = str.substring(0,strs+3);
        var b = 5-a.length;
        for(var i=0;i<b;i++){
            reright+="<li>0</li>"
        }
        for(var i=0;i<st.length;i++){
            reright+="<li>"+st[i]+"</li>";    
        } 
        $('#znzx').parent().find('.stat-data .second').html(reright); 
        $('#znzx').parent().find(".li-content-title a").eq(1).show();
        $("#znzx").parent().find('.stat-data .second li').eq(3).addClass("on")
    }

    // 加载echarts
    var date = res[0].blockFour.resultThree;
    dataX = date[0].sz.split(',');
    dataY1 = date[1].sz.split(',');
    dataY2 = date[2].sz.split(',');
    znzxs(dataX,dataY1,dataY2); 
}

    


function znzxs(x,y1,y2){
    var chart = echarts.init(document.getElementById('znzx-lines'));
    // function getData(){
    //     return [20,70,35,40,30,60]
    // }
    // function getAData(){
    //     return [10,30,25,30,20,35]
    // }

    chart.setOption({
        legend: {
            data:['智能咨询量','人工咨询量'],
            textStyle: {
                color: '#fff'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                // boundaryGap : false,
                axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' }},
                splitLine: {
                    show: false
                },
                axisLine: {
                    show:false
                },
                // data : ['1月','2月','3月','4月','5月','6月']
                data:x,
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' }},
                // axisLine: {
                //     // show:false,
                //     lineStyle: {
                //         color: '#113461',
                //         // shadowColor: 'rgba(0, 0, 0, 1)',
                //         // shadowBlur: 10,
                //         // shadowOffsetY: -8
                //     },
                // },
                axisLine: {
                    show:false
                },
                // min: 0,
                // max: 100,
                splitNumber: 5,
                splitLine: {
                    show: false
                }
            }
        ],
        series : [
            {
                name:'智能咨询量',
                type:'line',
                // stack: '总量',
                symbol: 'none',
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 1, 1,
                            [
                                { offset: 0, color: '#1cf9f8' },
                                { offset: 1, color: '#225693' }
                            ]
                        )
                    }
                },
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 1, 1,
                            [
                                { offset: 0, color: '#1cf9f8' },
                                { offset: 1, color: '#5e6cf3' }
                            ]
                        )
                    }
                },
                // data: [20,80,35,40,30,65]
                data:y2,
            },
            {
                name:'人工咨询量',
                type:'line',
                // stack: '总量',
                symbol: 'none',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                { offset: 0, color: '#61c0c1' },
                                { offset: 1, color: '#46ea9b' }
                            ]
                        )
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                { offset: 0, color: '#72d2cc' },
                                { offset: 1, color: '#499cb0' }
                            ]
                        )
                    }
                },
                // data: [10,60,25,30,20,35]
                data:y1,
            }
        ]
    })
}