jQuery(document).ready(function($) {
        var months = [];
        var variation = [];
        commons.middlebottomQuery({}).then(function(res){
            var data = res[0].blockOne;
            for(var i=0;i<data.length;i++) {
                months.push(data[i].mc);
                variation.push(Math.ceil(data[i].sz/10000));
            }
            traffic(months,variation);
        })
    
    // dataSourse();
})

function traffic(months,variation){
    var chart = echarts.init(document.getElementById('traffic-variation'));

    chart.setOption({
        tooltip: {
            "trigger": "item",
            formatter: '{c}',
            show:true
        },
        grid: [{
            show: false,
        }],
        xAxis: {
            type: 'category',
            data: months,
            axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
            splitLine: { show: false },
            axisLine: {
                lineStyle: {
                    color: '#143561',
                },
            },
        },
        yAxis: [
            {
                type: 'value',
                axisLabel: { show: true, color: '#fff', textStyle: { color: '#fff' } },
                splitLine: { show: false},
                min: 0,
                max: 100,
                splitNumber: 5,
                axisLine: {
                    show:false,
                    lineStyle: {
                        color: '#143561',
                    },
                }
            },
            {
                name: '单位：万次',
                nameGap: 10,
                nameTextStyle: {
                    color: '#bdcee5'
                },
                axisLine: {
                    show:false,
                    lineStyle: {
                        color: '#143561',
                    },
                }
            }
        ],
        grid: {
            x:'9%'
        },
        series: [
            {
                type: 'bar',
                stack: 'one',
                // barType: 'cylinder',
                data: variation,
                label: {
                    normal: {
                        show: false,
                        formatter: '{b}',
                        position: 'inside'
                    }
                },
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                { offset: 0, color: '#3ddfeb' },
                                { offset: 1, color: '#5989e1' }
                            ]
                        ),
                        barBorderColor: '#087a83',
                        opacity: 0.8
                    }
                }
            },
            {
                type: 'line',
                data: variation,
                symbol: 'circle',
                symbolSize: 8,
                itemStyle: {
                    normal: {
                        color: '#ffd689',
                    }
                }
            }
        ],
        barWidth: 30
    });

}


