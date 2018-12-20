function zcyh(res){
    var params = {
        users: '',
        woman: '',
        man: '',
        bj: [],
        yn: '',
        zj: ''
    };
    params.users = res[0].blockOne.resultOne.sz;
    var date = res[0].blockOne.resultTwo;
    for(var i in date){
        if(date[i].mc == '女'){
            params.woman = parseInt(date[i].sz)
        }else if(date[i].mc == '男'){
            params.man = parseInt(date[i].sz)
        }
    }

    //男女百分比
    
    $('#man').html(params.man+"%");
    $('#woman').html(params.woman+"%");
    var dataSource = res[0].blockOne.resultThree;
    console.log(dataSource)
    // 指定排序的比较函数
    function compare(property){
        return function(obj1,obj2){
            var value1 = obj1[property];
            var value2 = obj2[property];
            return value2- value1; 
        }
    }
    var sortObj = dataSource.sort(compare("sz"));
    var array = [];
    for(var i in sortObj){
        array.push(sortObj[i].mc);
    }
    //注册用户数
   
    if(params.users.length<5) {
        var res = '';
        var k = 5-params.users.length;
        for(var i=0;i<k;i++) {
            res +='<li>0</li>';
        }
        for(var i=0;i<params.users.length;i++) {
            res += '<li>'+params.users.substr(i,1)+'</li>'
        }
        $('#zcyh').parent().find('.stat-data .first').html(releft);
        $('#zcyh').parent().find(".li-content-title a").eq(0).hide();
    }else{
        var releft = '';
        var a = params.users.substring(0,params.users.length-2);  
        var str = parseInt(params.users)/10000 + "";
        var strs = str.indexOf(".");
        var st = str.substring(0,strs+3);
        var b = 5-a.length;
        for(var i=0;i<b;i++){
            releft+="<li>0</li>"
        }
        for(var i=0;i<st.length;i++){
            releft+="<li>"+st[i]+"</li>";    
        } 
        $('#zcyh').parent().find('.stat-data .first').html(releft); 
        $('#zcyh').parent().find(".li-content-title a").eq(0).show();
        $("#zcyh").parent().find('.stat-data .first li').eq(3).addClass("on")
    }
    
    zcyhs(sortObj,array);
}

function zcyhs(pro,_text){
    var _data = JSON.stringify(pro);
    var name = _data.replace(/mc/ig,'name');
    var value = name.replace(/sz/ig,'value');
    var myZcyh = echarts.init(document.getElementById("zcyh"));
    data = JSON.parse(value);
    // data = [
    //     {
    //         "name":"北京市",
    //         "value":"15234"
    //     },
    //     {
    //          "name":"浙江省",
    //          "value":"4512"
    //     },
    //     {
    //         "name":"云南省",
    //         "value":"788"
    //     }
    // ]
    let seriesObjs = [];
    let r = 100;
    let color = [
        new echarts.graphic.LinearGradient(
            0, 1, 1, 1,
            [
                { offset: 0, color: '#45e791' },
                { offset: 1, color: '#98db68' }
            ]
        ),
        new echarts.graphic.LinearGradient(
            0, 1, 1, 1,
            [
                { offset: 0, color: '#eb7a43' },
                { offset: 1, color: '#f5cc7a' }
            ]
        ),
        new echarts.graphic.LinearGradient(
            0, 1, 1, 1,
            [
                { offset: 0, color: '#20f1f8' },
                { offset: 1, color: '#6068f3' }
            ]
        )
    ];
    let placeHolderStyle = {
        normal: {
            label: {
                show: false,
                position: 'center'
            },
            labelLine: {
                show: false
            },
            color: 'rgba(0, 0, 0, 0)',
            borderColor: 'rgba(0, 0, 0, 0)',
            borderWidth: 0
        }
    }
    for (let i = 0; i < data.length; i++) {
        let seriesObj = {
            name: data[i].name,
            type: 'pie',
            clockWise: false,
            radius: [r - 1 - i * 20, r - i * 20],
            itemStyle: {
                normal: {
                    label: {
                        show: false,
                        position: 'center'
                    },
                    labelLine: {
                        show: false
                    },
                    borderWidth: 8,
                    shadowBlur: 50,
                    borderColor: color[i],
                    shadowColor: 'rgba(142,152,241, 0.6)'
                }
            },
            hoverAnimation: true,
            data: [{
                value: data[i].value
            }, {
                value: (parseInt(data[0].value)+parseInt(data[1].value)+parseInt(data[2].value))-(parseInt(data[i].value)),
                // name: 'invisible',
                itemStyle: placeHolderStyle
            }]
        }
        seriesObjs.push(seriesObj)
    }
    option = {
        "tooltip": {
                "trigger": "item",
                formatter: '{a} : {c}',
                show:true
            },
            color : [
                new echarts.graphic.LinearGradient(
                    0, 1, 1, 1,
                    [
                        { offset: 0, color: '#45e791' },
                        { offset: 1, color: '#98db68' }
                    ]
                ),
                new echarts.graphic.LinearGradient(
                    0, 1, 1, 1,
                    [
                        { offset: 0, color: '#eb7a43' },
                        { offset: 1, color: '#f5cc7a' }
                    ]
                ),
                new echarts.graphic.LinearGradient(
                    0, 1, 1, 1,
                    [
                        { offset: 0, color: '#20f1f8' },
                        { offset: 1, color: '#6068f3' }
                    ]
                )
            ],
            "legend": {
                type:"scroll",
                itemWidth:20,
                itemHeight:10,
                orient:'vertical',
                bottom:30,
                right:40,
                data:_text,
                // data: [
                //     "浙江省",
                //     "云南省",
                //     "北京市",
                // ],
                textStyle: {
                    color: "#bdcee5",
                    fontSize:10.5                
                }
            },
        series: seriesObjs
    }
    myZcyh.setOption(option);
    window.onresize = function(){
        myZcyh.resize();
    }
}
