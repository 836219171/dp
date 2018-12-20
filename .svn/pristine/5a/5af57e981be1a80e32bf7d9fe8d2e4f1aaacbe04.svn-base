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