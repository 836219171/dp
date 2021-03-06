function sfqrl(data){
    // 司法确认率
    var sf = data[0].blockFive.resultOne.sz;
    $('#sfqrl').parent().find('.stat-data .stat-sfqr span').html(sf+"%");
    // 申请诉讼率
    var sq = data[0].blockFive.resultTwo.sz;
    $('#sfqrl').parent().find('.stat-data .stat-sqgs span').html(sq+"%");
    var dataX = [];
    // 调节成功案件量
    var data1 = [];
    var data2 = [];
    var data3 = [];
    var data4 = [];
    var res = data[0].blockFive.resultThree;
    for(var i in res){
        dataX.push(res[i].mc)
        data1.push(res[i].sz.split(',')[0]);
        data2.push(res[i].sz.split(',')[1]);
        data3.push(res[i].sz.split(',')[2]);
        data4.push(res[i].sz.split(',')[3]);
    }
    srqrls(dataX,data1,data2,data3,data4); 
}
function srqrls(x,y1,y2,y3,y4){
    var chart = echarts.init(document.getElementById('sfqr-bars'), null, {
        renderer: 'canvas'
    });
    chart.setOption({
        legend: [
            {
            data: ['调解成功案件量','调解失败案件量'],
            x: '25%',
            y: '1%',
            orient: 'vertical',
            textStyle: {
                color: '#fff'
            }
        },
        {
            data: ['申请司法确认率','申请诉讼确认率'],
            x: '60%',
            y: '1%',
            orient: 'vertical',
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
            // data: ['杭州', '绍兴', '宁波', '金华', '嘉兴']
            data: x,
        },
        yAxis: [
            {
                type: 'value',
                axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
                splitLine: { show: false },
                axisLine: {
                    show:false
                },
                axisTick: {
                    show: false
                }
            },
            {
                type: 'value',
                min: 0,
                max: 100,
                axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
                splitLine: { show: false },
                axisLabel: {
                    formatter:'{value} %'
                },
                axisLine: {
                    show: false,
                    lineStyle: {
                        color: '#fff',
                    },
                },
                axisTick: {
                    show: false
                }
            }
        ],
        dataZoom: [
            {
                type: 'inside'
            }
        ],
        series: [
            {
                name: '调解成功案件量',
                type: 'bar',
                // stack: 'one',
                // barType: 'cylinder',
                // data: getData(),
                data: y1,
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 1, 1, 0,
                            [
                                { offset: 0, color: '#5e6cf3' },
                                { offset: 1, color: '#1df7f8' }
                            ]
                        ),
                            barBorderRadius: 7
                    },
                    emphasis: {
                        color: '#1df7f8',
                        // barBorderColor: '#018df0'
                    }
                }
            },
            {
                name: '调解失败案件量',
                type: 'bar',
                // stack: 'one',
                // barType: 'cylinder',
                // data: getAData(),
                data: y2,
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 1, 1, 0,
                            [
                                { offset: 0, color: '#e65f32' },
                                { offset: 1, color: '#fed580' }
                            ]
                        ),
                            barBorderRadius: 7
                        // opacity: 0.6
                    }
                }
            },
            {
                name: '申请诉讼确认率',
                type: 'line',
                // data: getAData(),
                data: y3,
                symbol: 'none',
                // symbolSize: 8,
                itemStyle: {
                    normal: {
                        color: '#ffd689',
                    }
                }
            },
            {
                name: '申请司法确认率',
                type: 'line',
                // data: getData(),
                data: y4,
                symbol: 'none',
                // symbolSize: 8,
                itemStyle: {
                    normal: {
                        color: '#53cffc',
                    }
                }
            }
        ],
        barWidth: 20
    });
}