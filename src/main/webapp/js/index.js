$(function () {
    getPostList(getCurrentId());
    var $pageSelect = $('.page-select');
    $pageSelect.on('click','.page-item',function () {
        if($(this).parent().hasClass("active"))
            return;
        var page = $(this).attr('data-toggle');
        $('body,html').animate({ scrollTop: 0 }, 0);
        window.location.hash = '/new/'+page;
        getPostList(page);
    });
});

function getCurrentId() {
    var text = window.location.hash;
    var reg = /(?:\w+\/)(\d+)/;
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

function getPostList(id) {
    var $postListBody = $('.post-list-body');
    $.ajax({
        url:"post/list/"+id,
        method: "post",
        beforeSend:function () {
            $postListBody.html(getLoadingPic());
        },
        success:function (data) {
            $postListBody.html(getList(data.posts));
            $('.page-select').html(getPage(data.pageInfo));
            return true;
        },error:function () {
            return false;
        }
    });
}

function getLoadingPic() {
    return '<div class="loading-wrap"><img src="img/loading5.gif"/></div>';
}

function getList(posts) {
    var html = '';

    var pattern =
    '<div class="post-item clearfix">' +
        '<a class="avatar pull-left">' +
            '<img src="${post.uavatar}">' +
        '</a>' +
        '<div class="post-content">' +
            '<p class="post-title"><a href="post/${post.pid}">${post.title}</a></p>' +
            '<p class="post-sub">' +
                '<a href="#"><span class="badge">主题</span></a>' +
                    '<span>' +
                        '•<a href="#">${post.unickname}</a> 发起了问题 • ${post.starCount} 人关注 • ${post.replyCount} 个回复 • ${post.watchCount} 次浏览 •${post.lastReplyTime}' +
                    '</span>' +
                '<a href="#" class="pull-right">回复</a>' +
            '</p>' +
        '</div>' +
    '</div>';

    for(var i in posts){
        html += pattern.replace('${post.uavatar}',posts[i].uavatar)
            .replace('${post.pid}',posts[i].pid)
            .replace('${post.title}',posts[i].title)
            .replace('${post.unickname}',posts[i].unickname)
            .replace('${post.starCount}',posts[i].starCount)
            .replace('${post.replyCount}',posts[i].replyCount)
            .replace('${post.watchCount}',posts[i].watchCount)
            .replace('${post.lastReplyTime}',formatDate(posts[i].lastReplyTime));
    }
    return html;
}

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

function getPage(pageInfo) {

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

    if(curPage > totalPage){
        getPostList(totalPage);
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
        return parseInt((time/3600))+"小时前";
    }else if(time > 60){
        return parseInt((time/60))+"分钟前";
    }else{
        return parseInt(time)+"秒前";
    }
}



