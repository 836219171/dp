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