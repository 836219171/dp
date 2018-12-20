var canvas = document.getElementById("bubble");
canvasSize();
var w = window.innerWidth;
var h = window.innerHeight;
var pX;
var pY;
canvas.width = w;
canvas.height = h;
window.onresize = canvasSize;

function canvasSize() {
    w = window.innerWidth;
    h = window.innerHeight;
    canvas.width = w;
    canvas.height = h;
}
var ctx = canvas.getContext('2d');
var colors = ["#fff", "#c7b3e5", "#e0803e" ,"#7cbaff","#2a83ff",'#49a2ff','#508aea','#2c9aff','#3088fe','#ffa41d','#1e75fe','#1a70fe','#1e7ffe','#0225c8','#0f60fe','#87bdfc'];
function random(min, max) { //返回一个Min到max的值
    return Math.random() * (max - min) + min;
}
function Bubble() {
}
Bubble.prototype = {
    init: function() {
        this.x = random(0, w); //泡泡生成的x的位置
        this.y = random(0, h);
        this.r = random(1, 1);
        this.color = colors[Math.floor(random(0, 12))];
        this.xr=random(-1,1);
        this.yr=random(-1,1);
        this.Dis=10;
        this.vr=random(1,2);
    },
    draw: function() {
        ctx.beginPath();
        ctx.fillStyle = this.color;
        ctx.arc(this.x, this.y, this.r, 0, Math.PI * 2);
        ctx.fill();
    },
    move:function(){
    this.x+=this.xr;
    this.y+=this.yr;
    if(this.x-this.r<0||this.x+this.r>w||this.y-this.r<0||this.y+this.r>h){
        this.xr=-this.xr;
        this.yr=-this.yr;
    }
    this.xDis=Math.abs(pX-this.x);
    this.yDis=Math.abs(pY-this.y);
    if(this.xDis<this.Dis&&this.yDis<this.Dis&&this.r<this.Dis){
        this.r+=this.vr;
    }else if(this.xDis>this.Dis&&this.yDis>this.Dis&&this.r>4){
        this.r-=this.vr;
    }

    this.draw();
    }
}
var bubbleArray=[];

function create() {
    var bubble = new Bubble();
    bubble.init();
    bubble.draw();
    bubbleArray.push(bubble);
}

for(var i=0;i<188;i++){
    create();
}
setInterval(function(){
    ctx.clearRect(0,0,w,h);
        for(var item of bubbleArray){
            item.move();
        }
},1000/10);