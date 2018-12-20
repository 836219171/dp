$(function(){
    zcyh();
})

function zcyh(){
    var myZcyh = echarts.init(document.getElementById("zcyh"));
    option = {
        backgroundColor: 'rgb(43, 51, 59)',
       
        "tooltip": {
            "trigger": "item",
        },
        "calculable": true,
        "legend": {
            type:"scroll",
            // icon:"line",
            itemWidth:20,
            itemHeight:10,
            orient:'vertical',
            bottom:10,
            right:50,
            "data": [
                "浙江省",
                "云南省",
                "北京市",
            ],
            "textStyle": {
                "color": "#fff"
            }
        },
        "series": [{
            "type": "pie",
            "radius": [
                0,
                80
            ],
            "avoidLabelOverlap": false,
            "startAngle": 0,
            "center": [
                "50%",
                "50%"
            ],
            "roseType": "area",
            "selectedMode": "single",
            "label": {
                "normal": {
                    "show": false,
                },
                "emphasis": {
                    "show": false
                }
            },
            "labelLine": {
                "normal": {
                    "show": false,
                    "smooth": false,
                    "length": 20,
                    "length2": 10
                },
            },
            "data": [{
                    "value": 600.58,
                    "name":"浙江省",
                    "itemStyle": {
                        "normal": {
                            color: new echarts.graphic.LinearGradient(
                                0, 1, 1, 1,
                                [
                                    { offset: 0, color: '#20f1f8' },
                                    { offset: 1, color: '#6068f3' }
                                ]
                            )
                        }
                    }
                },
                {
                    "value": 1100.58,
                    "name":"云南省",
                    "itemStyle": {
                        "normal": {
                            color: new echarts.graphic.LinearGradient(
                                0, 1, 1, 1,
                                [
                                    { offset: 0, color: '#eb7a43' },
                                    { offset: 1, color: '#f5cc7a' }
                                ]
                            )
                        }
                    }
                },
                {
                    "value": 1200.58,
                    "name":"北京市",
                    "itemStyle": {
                        "normal": {
                            color: new echarts.graphic.LinearGradient(
                                0, 1, 1, 1,
                                [
                                    { offset: 0, color: '#45e791' },
                                    { offset: 1, color: '#98db68' }
                                ]
                            )
                        }
                    }
                },
                
            ]
        }]
    };
    myZcyh.setOption(option);
    window.onresize = function(){
        myZcyh.resize();
    }
}
