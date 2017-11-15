var r = 4;
var ballColor = "#18cdb0";
var ballAmount = 50;
var balls = [];
var backgroundColor = "#16a085";
var fps = 1000 / 60;
var width = 0;
var height = 0;
var minDistance = 12100;
var cxt;
var ball = {x: -100, y: -100, color: ballColor, vx: 0, vy: 0};

$(function () {
    init();
    drawBalls();
    setInterval(function () {
        move();
        cxt.clearRect(0,0,width,height);
        drawBalls();
        drawLines();
        drawBall(ball,0);
        drawLine(ball,-1);
    }, fps);
});

function init() {
    var c = document.getElementById('body-bg-canvas');
    width = $(window).width();
    height = $(window).height();
    ballAmount = width*height/10000;
    var $formWrap = $('.form-wrap');
    if(width < 768){
        $formWrap.css('margin-top',0);
    }else{
        $formWrap.css('margin-top',height/10);
    }
    c.width = width;
    c.height = height;
    cxt = c.getContext('2d');
    cxt.width = width;
    cxt.height = height;
    var rangeWidth = width - r * 2;
    var rangeHeight = height - r * 2;
    for (var i = 0; i < ballAmount; i++) {
        var x = Math.random() * rangeWidth + r;
        var y = Math.random() * rangeHeight + r;
        var vx = (Math.random() * 20 - 10) / fps;
        var vy = (Math.random() * 20 - 10) / fps;
        var ball = {x: x, y: y, color: ballColor, vx: vx, vy: vy};
        balls.push(ball);
    }
}

function move() {
    for (var i = 0; i < ballAmount; i++) {
        if (balls[i].x < r || balls[i].x > width - r) {
            balls[i].vx = -balls[i].vx;
        }
        if (balls[i].y < r || balls[i].y > height - r) {
            balls[i].vy = -balls[i].vy;
        }
        moveBall(balls[i],balls[i].vx,balls[i].vy);
    }
}
function moveBall(ball,x,y) {
    ball.x = ball.x + x;
    ball.y = ball.y + y;
}

function drawBackground() {
    cxt.fillStyle = backgroundColor;
    cxt.fillRect(0, 0, cxt.width, cxt.height);
}

function drawBalls() {
    for (var i = 0; i < ballAmount; i++) {
        drawBall(balls[i],r);
    }
}
function drawBall(ball,radius) {
    cxt.fillStyle = ball.color;
    cxt.beginPath();
    cxt.arc(ball.x, ball.y, radius, 0, Math.PI * 2, false);
    cxt.closePath();
    cxt.fill();
}

function drawLines() {
    cxt.strokeStyle = ballColor;
    for (var i = 0; i < ballAmount; i++) {
        drawLine(balls[i],i);
    }
}
function drawLine(ball,i) {
    for (var j = i+1; j < ballAmount; j++) {
        if (Math.pow(ball.x - balls[j].x, 2) + Math.pow(ball.y - balls[j].y, 2) < minDistance) {
            cxt.beginPath();
            cxt.moveTo(ball.x, ball.y);
            cxt.lineTo(balls[j].x, balls[j].y);
            cxt.closePath();
            cxt.stroke();
        }
    }
}

$('.body-bg').mousemove(function (e) {
    ball = {x: e.pageX, y: e.pageY, color: ballColor, vx: 0, vy: 0};
});

$(window).resize(function () {
    balls.length = 0;
    init();
});

