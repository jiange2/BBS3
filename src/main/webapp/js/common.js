$(function () {
    //modal显示
    fillSize();

    //搜索框弹出
    var $searchQuery = $('.search-query');
    $searchQuery.on('focus',function () {
        $(this).nextAll('.search-box-dropdown').show();
    });
    $searchQuery.on('blur',function () {
        $(this).nextAll('.search-box-dropdown').fadeOut(500);
    });

    $('.nav-select .dropdown-menu a').on('click',function () {
        var $this = $(this);
        var targetId = $this.attr('href');
        var $drop_menu = $this.parents('.dropdown-menu');
        $drop_menu.children().removeClass('active');
        $this.parent().addClass('active');
        $drop_menu.prev().html($this.html());
        var $target = $(targetId);
        $target.nextAll().removeClass('active');
        $target.prevAll().removeClass('active');
        $target.addClass('active');
    });

    //刷新验证码
    $('.flesh-ver-code').on('click',function () {
        fleshVerCode();
    });

    //
    $(window).resize(function () {
        fillSize();
    });

    //浮动按钮组
    (function () {
        var hideFlag = true;
        var animateTime = 300;
        var $backToTopBtn = $('.back-to-top-btn');
        $(window).scroll(function () {
            var scrollTop = window.pageYOffset||document.documentElement.scrollTop || document.body.scrollTop;
            var windowHeight = $(window).height()/2;
            var $fixedBtnGroup = $('.fixed-btn-group');
            if(scrollTop > windowHeight && hideFlag){
                hideFlag = false;
                $fixedBtnGroup.animate({bottom:"7px"},animateTime);
            }
            if(scrollTop < windowHeight && !hideFlag)
            {
                hideFlag = true;
                $fixedBtnGroup.animate({bottom:"-40px"},animateTime);
            }
        });
        $backToTopBtn.on('click',function () {
            $('body,html').animate({ scrollTop: 0 }, animateTime);
        });
        $('body,html').trigger('scroll');
    })();
    $('.btn-login').on('click',function () {
        $('#login-model').modal('show');
    });
    $('.enter-post').on('keydown',function (e) {
        if((e.keyCode || e.which) === 13){
            $(this).find('.submit-btn').trigger('click');
        }
    });
    //初始化toastr
    toastr.options = {
        closeButton: false,
        debug: false,
        progressBar: true,
        positionClass: "toast-bottom-center",
        onclick: null,
        showDuration: "300",
        hideDuration: "1000",
        timeOut: "2000",
        extendedTimeOut: "1500",
        showEasing: "swing",
        hideEasing: "linear",
        showMethod: "fadeIn",
        hideMethod: "fadeOut"
    };
    //初始化tooltip
    if($(window).width() > 768){
        $("[data-toggle='tooltip']").tooltip();
    }
    $('.token-btn').on('click',function () {
        getToken();
    });
});

Date.prototype.format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1)
                ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

function getCurrentPageNum() {
    var text = window.location.hash;
    var reg = /(?:\w+\/)?(\d+)/;
    var match = text.match(reg);
    if(match && match[1].length){
        if(match[1] > 0)
            return match[1];
        else
            return 1;
    }else{
        return 1;
    }
}

function getPageHtml(pageInfo) {
    if(pageInfo === undefined)
        return "";
    var html = '';
    var pattern = '<li  class="${active}"><a class="page-item" data-toggle="${realPage}">${page}</a></li>';
    var curPage = pageInfo.pageNum;
    var totalPage = pageInfo.pages;
    var total = 10;
    var start = 1;

    if($(window).width() < 768){
        total = 6;
    }else if($(window).width() < 998){
        total = 8;
    }

    if(totalPage > total){
        if(curPage > total/2){
            start = curPage - parseInt(total/2);
        }
        if(curPage + total/2 > totalPage){
            start = totalPage - total + 1;
        }
    }

    if(totalPage < total)
        total = totalPage;

    if(curPage > 1)
        html += pattern.replace("${page}",'&laquo')
            .replace("${active}",'')
            .replace("${realPage}",1+'');

    for(var i=start; i<total+start; i++){
        if(i === curPage)
            html += pattern.replace("${page}",i+'')
                .replace("${active}",'active')
                .replace("${realPage}",i+'');
        else
            html += pattern.replace("${page}",i+'')
                .replace("${active}",'')
                .replace("${realPage}",i+'');
    }

    if(curPage < totalPage)
        html += pattern.replace("${page}",'&raquo')
            .replace("${active}",'')
            .replace("${realPage}",totalPage+'');

    return html;
}

function formatDate(dateTime) {
    var curDate = new Date();
    var date = new Date(dateTime);
    var time = (curDate.getTime() - dateTime)/1000;
    if(curDate.getFullYear() > date.getFullYear()){
        return new Date(dateTime).format("yyyy年MM月dd日 hh:mm:ss");
    }if(time > 86400){
        return date.format("MM月dd日 hh:mm:ss");
    }else if(time > 3600){
        return parseInt(time/3600)+"小时前";
    }else if(time > 60){
        return parseInt(time/60)+"分钟前";
    }else{
        return parseInt(time)+"秒前";
    }
}

function fillSize(){
    $('.absolute-screen-width-100').each(function () {
        var $this = $(this);
        if($this.css('position') === 'absolute' || $this.css('position') === 'fixed'){
            $this.css('width',$(window).width());
        }else{
            $this.css('width','100%');
        }
    });
    $('.absolute-screen-height-100').each(function () {
        var $this = $(this);
        if($this.css('position') === 'absolute' || $this.css('position') === 'fixed'){
            $this.css('height',$(window).height());
        }else{
            $this.css('height','100%');
        }
    });
}

function fleshVerCode() {
    var verCode = $('#ver-code');
    verCode.attr('src','/verify/verCode?timestamp='+new Date().getTime());
}

function getToken() {
    var $token = $('input[name=token]');
    console.log($token.val());
    if($token.val() ===　""){
        reFleshToken();
    }
}

function reFleshToken() {
    var $token = $('input[name=token]');
    $.ajax({
        url:'/verify/getToken',
        dataType:'text',
        success:function (data) {
            $token.val(data);
        }
    })
}









