$(function(){
    drawMark(); 
    // 旋转对画
    function drawMark(){ 
        var circle = document.getElementById("warp");
        for(let i=0;i<80;i++){
            (function(e){
                setTimeout(function(){
                    var div = document.createElement('div');
                    div.className ="jiaDian";
                    div.style.transform = "rotate("+e*4.5+"deg)";
                    circle.appendChild(div);
                },e*50)
            })(i)
        }
        setTimeout(function (){
            $(".warp").empty();
            drawMark();
        },8000)
    }
})


function mdjflxqwm(res){
    // 对应图片地址
    var dataIcon = [
        'image://./../../img/mdjflxqwm-hyjc.png',
        'image://./../../img/mdjflxqwm-xfwq.png',
        'image://./../../img/mdjflxqwm-ldzy.png',
        'image://./../../img/mdjflxqwm-jdjf.png',
        'image://./../../img/mdjflxqwm-qt.png',
        'image://./../../img/mdjflxqwm-wyjf.png'
    ]
    var dataX = [];
    var dataY = [];
    var data = res[0].blockTwo.resultOne;
    for(var i in data){
        dataX.push({'name':data[i].mc +' '+data[i].sz,"icon":dataIcon[i]})
        dataY.push({"value":data[i].sz,"name":data[i].mc +' '+data[i].sz})
    }
    popcharts1(dataX,dataY);
   
}

function popcharts1(x,y){
	// 基于准备好的dom，初始化echarts图表
	var charts_1 = echarts.init(document.getElementById('dyfwjc-pie')); 
	var option = {
        color:['#58c4eb','#3182c5','#f4a522','#e35028','#10f6e9','#ffffff'],
		tooltip : {
			trigger: 'item',
			formatter: '{b} {d}%'
		},	
		legend: {
			type:'scroll',
            // icon:"rect",
            itemWidth:10,
            itemHeight:10,
            orient:'vertical',
            top:10,
            left:'60%',
            data:x,
			// data:[
            //     {
            //         name:'婚姻继承 1001',
            //         icon:'image://./../../img/mdjflxqwm-hyjc.png'
            //     },
            //     {
            //         name:'消费维权 1235',
            //         icon:'image://./../../img/mdjflxqwm-xfwq.png'
            //     },
            //     {
            //         name:'劳动争议 2354',
            //         icon:'image://./../../img/mdjflxqwm-ldzy.png'
            //     },
            //     {
            //         name:'借贷纠纷 2451',
            //         icon:'image://./../../img/mdjflxqwm-jdjf.png'
            //     },
            //     {
            //         name:'物业纠纷 3021',
            //         icon:'image://./../../img/mdjflxqwm-qt.png'
            //     },
            //     {
            //         name:'其他类型 500',
            //         // textStyle:{
            //         //     fontSize:14,
            //         //     color:"#fff"
            //         // },
            //         icon:'image://./../../img/mdjflxqwm-wyjf.png'
            //     },
            //     ],
			// itemGap:15,
			// top:52,
			textStyle:{
				color:"#10f6e9",
                fontSize:15,
                // fontStyle:"impact",
                rich:{
                    align:'left',
                }
			}
		},	
		series : [
			{
				name:'',
				type:'pie',
				radius:["40%", "55%"],
                center:["24.9%","50%"],
                itemStyle:{
                    normal:{
                        label:{
                            show:false,
                            // formatter: '{d}%',
                            textStyle: {
                                color: '#163242',
                            }
                        },
                    },
                },
                data:y,
				// data:[
                //     {value:1001, name:'婚姻继承 1001'},
                //     {value:1235, name:'消费维权 1235'},
                //     {value:2354, name:'劳动争议 2354'},
                //     {value:2451, name:'借贷纠纷 2451'},
                //     {value:3021, name:'物业纠纷 3021'},
                //     {value:500, name:'其他类型 500'}
                // ],
				avoidLabelOverlap: false,
				label: {
					show: false
				}
			}
		],
		
	};

	// 为echarts对象加载数据 
    charts_1.setOption(option); 
    window.onresize = function(){
        charts_1.resize();
    }
}
