jQuery(document).ready(function($) {
    var middleDate = [];
    var animeNub = 1;
    var flag1 = true;
    $('.city-detail-box').hide();
    //弹窗数据
    $('#province-data1').load('../template/middle/1zhuzu.html');
    $('#province-data2').load('../template/middle/1zhexian.html');
    $('#province-data2').hide();
    //关闭按钮

    $('body').on('click','#close-window',function () {
        $('.city-detail-box').hide(300);
    })

    //弹窗轮播
    
    $('.odr-map .map').hover(function() {
		flag1 = false;
	}, function() {
		flag1 = true;
    });

    // $('.odr-map .city-detail-box').hover(function() {
    //     flag1 = false;
    //     console.log(111111111)
	// }, function() {
	// 	flag1 = true;
    // });

   $('body').on('mouseenter','.city-detail-box',function () {
        flag1 = false;
   })

   $('body').on('mouseleave ','.city-detail-box',function () {
        flag1 = true;
    })

    setInterval(function(){
        if(flag1 == true) {
            mapAnime()
        }
    },10000)

    
 // 地图弹窗动画
    function mapAnime() {
        if(animeNub == 1){
            if(flag1 == true) {
            beijing();
            setTimeout(function(){
                $('.city-detail-box').hide(300);
            },5000);
            setTimeout(function(){
                $('.city-detail-box i').click();
            },2500);
        }
        }else if(animeNub == 2) {
            if(flag1 == true) {
            hangzhou();
            setTimeout(function(){
                $('.city-detail-box').hide(300);
            },5000);
            setTimeout(function(){
                $('.city-detail-box i').click();
            },2500);
        }
        }else if(animeNub == 3) {
            if(flag1 == true) {
            yunnan();
            setTimeout(function(){
                $('.city-detail-box').hide(300);
            },5000);
            setTimeout(function(){
                $('.city-detail-box i').click();
            },2500);
        }
        }
        animeNub >= 3 ? animeNub=1 : animeNub++;
    }
    
    function hangzhou() {
        var city = '浙江省';
        CityNum(city);
        $(".line-Chart").addClass("zhejiang");
        $('.city-detail-box .city-detail').find('h5').html('浙江省近12个月数据');
        $('.city-detail-box .city-detail').find('.online-time span').html("2018年2月1日");
        $('.city-detail-box .city-detail').css('background','url(../../../img/bg-map-tc.png) no-repeat');
        $('.city-detail-box .left-arrow').removeClass('left-arrow-bj');
        $('.city-detail-box .right-arrow').removeClass('right-arrow-bj');
        $('.city-detail-box .close').removeClass('close-bj');
        $('.city-detail-box .left-arrow').addClass('left-arrow-bj1');
        $('.city-detail-box .right-arrow').addClass('right-arrow-bj1');
        $('.city-detail-box .close').addClass('close-bj1');
        $('.city-detail-box').show(300);
    }

    function yunnan() {
        var city = "云南省"
        CityNum(city);
        $('.city-detail-box .city-detail').find('h5').html('云南省近12个月数据');
        $('.city-detail-box .city-detail').find('.online-time span').html("2018年9月1日");
        $('.city-detail-box .city-detail').css('background','url(../../../img/bg-map-tb.png) no-repeat');
        $('.city-detail-box .left-arrow').removeClass('left-arrow-bj');
        $('.city-detail-box .right-arrow').removeClass('right-arrow-bj');
        $('.city-detail-box .close').removeClass('close-bj');
        $('.city-detail-box .left-arrow').removeClass('left-arrow-bj1');
        $('.city-detail-box .right-arrow').removeClass('right-arrow-bj1');
        $('.city-detail-box .close').removeClass('close-bj1');
        $('.city-detail-box').show(300);
    }

    function beijing() {
        var city = "北京市";
        CityNum(city);
        $('.city-detail-box .city-detail').find('h5').html('北京市近12个月数据');
        $('.city-detail-box .city-detail').find('.online-time span').html("2018年7月1日");
        $('.city-detail-box .city-detail').css('background','url(../../../img/bg-map-green.png) no-repeat');
        $('.city-detail-box .left-arrow').addClass('left-arrow-bj');
        $('.city-detail-box .right-arrow').addClass('right-arrow-bj');
        $('.city-detail-box .close').addClass('close-bj');
        $('.city-detail-box .left-arrow').removeClass('left-arrow-bj1');
        $('.city-detail-box .right-arrow').removeClass('right-arrow-bj1');
        $('.city-detail-box .close').removeClass('close-bj1');
        $('.city-detail-box').show(300);
    }

    //点击箭头
    $('body').on('click','.city-detail-box i',function () {
        if($(this).hasClass('bar')) {
            $(this).removeClass('bar');
            $(this).addClass('line');
            $('.city-detail .chart-title').fadeOut(500);
            $('#province-data1').stop().fadeOut(500,function () {
                $('#province-data2').stop().fadeIn(500);    
            });
        }else if($(this).hasClass('line')) {
            $(this).removeClass('line');
            $(this).addClass('bar');
            $('.city-detail .chart-title').fadeIn(2600);
            $('#province-data2').stop().fadeOut(500,function () {
                $('#province-data1').stop().fadeIn(500);
            });
        }
    })

    //点击地图小圈
    $('body').on('click','.odr-map .map ul li',function () {
        var title = $(this).find('span').html();
        if(title == '浙江') {
            hangzhou();
        }else if(title == '云南') {
            yunnan();
        }else if(title == '北京') {
            beijing();
        }
    })

    headTitle();
    middleMap();


    function headTitle(){
        start();
        setInterval(function(){
            start();
        },15000)
        function start(){
            $.ajax({
                type: "get",
                url: preUrl+ "/upQuery",
                dataType: 'json',
                data: "",
                success: function(res) {
                    var head = res.data[0].blockOne;
                    var numberB = head.sz;
                    var myDate = new Date();
                    var dataNum = myDate.getDay();
                    // 周日 dataNum = 0
                    if(dataNum == 0){
                        var numberC = numberB;
                        var numbers = "";
                        setInterval(function(){
                            if(numberB!=numbers){
                                $("#dataNums").rollNum({
                                    deVal: numberB,
                                    digit: '6'
                                });
                                numbers = numberB.slice(0,numberB.length-1)+'0';
                                numberB = numberB.slice(0,numberB.length-1)+'0';
                            } 
                            else if(numberB==numbers){
                                setTimeout(function(){
                                    numberB = numberC
                                    $("#dataNums").rollNum({
                                        deVal: numbers,
                                        digit: '6'
                                    });
                                },10000)   
                            }
                        },2000)
                    } else {
                        $("#dataNums").rollNum({
                            deVal: numberB,
                            digit: '6'
                        });
                    }  
                }
            })
        }
    }
    
    function middleMap(){
        commons.upQuery({}).then(function(res){
            middleDate = res;
        })
    }
    
    function CityNum(city){
        // 柱组图
        var dataX = [];
        var dataY = [];
        // 折线图
        var dateX= [];
        var date1 = [];
        var date2 = [];
        var res = middleDate;
        // commons.upQuery({}).then(function(res){
            // 左边标题
            $('.city-detail-box #diaojie').html(""); 
            var title = res[0].blockTwo[0];
            for(var i in title){
                if(i === city){
                    $('.city-detail-box .left').find("label").html(title[i].mc); 
                    $('.city-detail-box #diaojie').html(title[i].sz); 
                }
            }
            // 右边标题
            $('.city-detail-box .right').find("span").html(""); 
            var title1 = res[0].blockTwo[1];
            for(var i in title1){
                if(i === city){
                    $('.city-detail-box .rigth').find("label").html(title1[i].mc); 
                    $('.city-detail-box .right').find("span").html(title1[i].sz+'%'); 
                } 
            }
            // 柱组图
            var data = res[0].blockThree;
            for(var i in data){
                for(var j in data[i]){
                    if(j === city){
                        dataX = data[i][j].mc;
                        dataY = data[i][j].sz;
                    }  
                }
            }
            middleData(dataX,dataY);
            // 收案和日期
            var date = res[0].blockFour;
    
            var dates = res[0].blockFive;
            for(var i in date){
                for(var j in date[i]){
                    if(j === city){
                        dateX = date[i][j].mc;
                        date1 = date[i][j].sz;
                    }  
                }
            }
            // 结案 
            for(var i in dates){
                for(var j in dates[i]){
                    if(j === city){
                        date2 = dates[i][j].sz;
                    }  
                }
            }
    
            middleData2(dateX,date1,date2)
        // })
    }
})


function middleData2(x,y,z){
    var chart = echarts.init(document.getElementById('middle-zhexian'));
    chart.clear();
    chart.setOption({
        legend: {
            data: ['收案','结案'],
            textStyle: {
                color: '#fff'
            }
        },
        xAxis: {
            type: 'category',
            // boundaryGap: true,
            // data: ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
            data: x,
            axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' }},
            splitLine: {
                show: false
            },
            axisLine: {
                // show:false,
                lineStyle: {
                    color: '#0a3a6b',
                    // shadowColor: 'rgba(0, 0, 0, 1)',
                    // shadowBlur: 10,
                    // shadowOffsetY: -8
                },
            },
        },
        yAxis: {
            type: 'value',
            axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
            splitLine: {
                show: false
            },
            axisLine: {
                // show:false,
                lineStyle: {
                    color: '#0a3a6b',
                    // shadowColor: 'rgba(0, 0, 0, 1)',
                    // shadowBlur: 20,
                    // shadowOffsetY: -8
                },
            },
        },
        series: [
            {
                name:'收案',
                type:'line',
                stack: '总量',
                // data:[120, 132, 101, 134, 90, 230, 210, 110, 230, 145, 250, 53],
                data: y,
                symbol: 'circle',
                symbolSize: 8,
                areaStyle: {
                    shadowColor: 'rgba(0, 0, 0, 1)',
                    shadowOffsetY: -10,
                    shadowBlur: 10
                },
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0.5, 1, 1,
                            [
                                { offset: 0, color: '#5e6cf3' },
                                { offset: 0.5, color: '#37c0f6' },
                                { offset: 1, color: '#1cf9f8' }
                            ]
                        )
                    }
                },
            },
            {
                name:'结案',
                type:'line',
                stack: '总量',
                // data:[220, 182, 191, 234, 290, 330, 310, 101, 134, 90, 230, 210],
                data: z,
                symbol: 'circle',
                symbolSize: 8,
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0.5, 1, 1,
                            [
                                { offset: 0, color: '#cc4cee' },
                                { offset: 0.5, color: '#646df3' },
                                { offset: 1, color: '#6f69f2' }
                            ]
                        )
                        
                    }
                }
            },
            // {
            //     name:'存案',
            //     type:'line',
            //     stack: '总量',
            //     data:[150, 232, 201, 154, 190, 330, 410, 220, 182, 191, 234, 290],
            //     symbol: 'circle',
            //     symbolSize: 8,
            //     itemStyle: {
            //         normal: {
            //             color: new echarts.graphic.LinearGradient(
            //                 0, 0.5, 1, 1,
            //                 [
            //                     { offset: 0, color: '#feb58e' },
                                // { offset: 0, color: '#fec681' },
            //                     { offset: 1, color: '#ffde6f' }
            //                 ]
            //             )
            //         }
            //     }
            // },
        ]
    });
}

function middleData(x,y){
    var chart = echarts.init(document.getElementById('bar-variation'), null, {
        renderer: 'canvas'
    });
    chart.clear();

    // function getData(){
    //     return [100,200,300,250,600,450]
    // }
    chart.setOption({
        legend: {
            data: ['直接访问'],
            align: 'left',
            left: 10
        },
        grid: [{
            show: false,
            left: 120
        }],
        xAxis: {
            type: 'value',
            // axisLabel: { show: true, color: '#fff',textStyle: {color:'#fff'}},
            splitLine: { show: false },
            axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
            axisLine: {
                // show:false,
                lineStyle: {
                    color: '#0a3b6b'
                },
            }
        },
        yAxis: [
            {
                type: 'category',
                // axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
                splitLine: { show: false },
                axisLabel: {
                    margin: 1
                },
                axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
                axisLine: {
                    // show:false,
                    lineStyle: {
                        color: '#0a3b6b'
                    },
                },
                data:x,
                // data: ['调解成功案件量', '调解失败案件量', '评估案件量', '仲裁案件量', '诉讼案件量', '司法确认案件量']
            }
        ],
        // dataZoom: [
        //     {
        //         type: 'inside',
        //         yAxisIndex: [0]
        //     }
        // ],
        series: [
            {
                // name: '直接访问',
                // type: 'pictorialBar',
                type: 'bar',
                barGap: 1,
                // symbol: 'rect',
                // symbolRepeat: true,
                // symbolSize: 20,
                // stack: 'one',
                // barType: 'cylinder',
                data: y,
                // min:0,
                // max:100,
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 1, 1, 1,
                            [
                                { offset: 0, color: '#2daed3' },
                                { offset: 1, color: '#e6f61a' }
                            ]
                        ),
                        barBorderRadius: 50
                        // barBorderColor: '#018df0',
                        // opacity: 0.6
                
                    },
                    // emphasis: {
                    //     color: '#2daed3',
                    //     // barBorderColor: '#018df0'
                    // }
                }
            }
        ],
        barWidth: 25
    });
}