// commons.rightQuery({}).then(function(res){
function fg(res){
    var param = {
        fg: '',
        zxs: '',
        citys: [],
        value: [],
        valueYn: [],
        valueBj: [],
        valueZj: []
    }
    param.fg = res[0].blockThree.resultOne.sz;
    param.zxs = res[0].blockThree.resultTwo.sz;
    var data = res[0].blockThree.resultThree;
    // console.log(data[0].mc);
    for(var i=0;i<data.length;i++){
        if(data[i].mc != null){
            param.value.push(data[i].sz);
            if(data[i].mc.indexOf("云南") != -1){
                param.citys.push(data[i].mc);
                param.valueYn.push(data[i].sz.split(',')[0]);
                param.valueZj.push(data[i].sz.split(',')[1]);
                param.valueBj.push(data[i].sz.split(',')[2]);
            } else if(data[i].mc.indexOf("浙江") != -1){
                param.citys.push(data[i].mc);
                param.valueYn.push(data[i].sz.split(',')[0]);
                param.valueZj.push(data[i].sz.split(',')[1]);
                param.valueBj.push(data[i].sz.split(',')[2]);
            } else if(data[i].mc.indexOf("北京") != -1){
                param.citys.push(data[i].mc);
                param.valueYn.push(data[i].sz.split(',')[0]);
                param.valueZj.push(data[i].sz.split(',')[1]);
                param.valueBj.push(data[i].sz.split(',')[2]);
            }
        }   
    }
    var a = [];
    //法官
    var fgres ='';
    if(param.fg.length<5) {
        var k = 5-param.fg.length;
        for(var i=0;i<k;i++) {
            fgres +='<li>0</li>';
        }
        for(var i=0;i<param.fg.length;i++) {
            fgres += '<li>'+param.fg.substr(i,1)+'</li>'
        }
    }else{
        for(var i=0;i<param.fg.length;i++) {
            fgres += '<li>'+param.fg.substr(i,1)+'</li>'
        }
    }
    $('#fg-data').html(fgres);

    //咨询师
    var zxsres ='';
    if(param.zxs.length<5) {
        var k = 5-param.zxs.length;
        for(var i=0;i<k;i++) {
            zxsres +='<li>0</li>';
        }
        for(var i=0;i<param.zxs.length;i++) {
            zxsres += '<li>'+param.zxs.substr(i,1)+'</li>'
        }
    }else{
        for(var i=0;i<param.zxs.length;i++) {
            zxsres += '<li>'+param.zxs.substr(i,1)+'</li>'
        }
    }
    $('#zxs-data').html(zxsres);

    //柱图
    judge(param.citys,param.valueYn,param.valueBj,param.valueZj)
}

function judge(citys,yn,bj,zj) {
    // console.log(zj)
    var chart = echarts.init(document.getElementById('fg-bars'));
    chart.setOption({
        legend: [
            {
            data: ['心理评估咨询师','法官','法律服务咨询师'],
            // x: '25%',
            y: '1%',
            orient: 'horizontal',
            textStyle: {
                color: '#fff'
            }
        },
    ],
        grid: [{
            show: false,
        }],
        xAxis: {
            type: 'category',
            axisLabel: { show: true, color: '#fff',textStyle: {color:'#fff'}},
            splitLine: { show: false },
            axisLine: {
                show:false
            },
            axisTick: {
                show: false
            },
            data: citys
        },
        yAxis: [
            {
                type: 'value',
                axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
                splitLine: { show: false },
                // min: 0,
                // max: 100,
                splitNumber: 5,
                axisLine: {
                    show:false
                },
                axisTick: {
                    show: false
                }
            }
        ],
        // dataZoom: [
        //     {
        //         type: 'inside'
        //     }
        // ],
        series: [
            {
                name: '心理评估咨询师',
                type: 'bar',
                // stack: 'one',
                // barType: 'cylinder',
                data: yn,
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 1, 1, 0,
                            [
                                { offset: 0, color: '#5e6cf3' },
                                { offset: 1, color: '#1df7f8' }
                            ]
                        ),
                            barBorderRadius: 15
                    },
                    emphasis: {
                        color: '#1df7f8',
                        // barBorderColor: '#018df0'
                    }
                }
            },
            {
                name: '法律服务咨询师',
                type: 'bar',
                // stack: 'one',
                // barType: 'cylinder',
                data: bj,
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 1, 1, 0,
                            [
                                { offset: 0, color: '#e65f32' },
                                { offset: 1, color: '#fed580' }
                            ]
                        ),
                            barBorderRadius: 15
                        // opacity: 0.6
                    }
                }
            },
            {
                name: '法官',
                type: 'bar',
                // stack: 'one',
                // barType: 'cylinder',
                data: zj,
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 1, 1, 0,
                            [
                                { offset: 0, color: '#46ea9c' },
                                { offset: 1, color: '#75d9cd' }
                            ]
                        ),
                            barBorderRadius: 15
                        // opacity: 0.6
                    }
                }
            }
        ],
        barWidth: 20
    });
}
    
