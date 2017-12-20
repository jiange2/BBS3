$(function () {

    if(window.history && window.history.pushState){
        $(window).on('popstate', function () {
            getReplyList(getCurrentPageNum());
        });
    }
    //消息
    $('.reply-list').on('click', '.show-comment-btn',function () {
        var $this = $(this);
        if ($this.hasClass('comment-open')) {
            $this.removeClass('comment-open');
        } else {
            $this.addClass('comment-open');
        }
        $this.parents('.item-content').nextAll('.reply-comment-wrap').toggle();
    });

    //设置iframe样式（视频样式）
    $(function () {
        var $embed = $('.content iframe');
        var $content = $('.content');
        $embed.width($content.width());
        $embed.height($content.width() * 10 / 16);
        $embed.addClass('note-video-clip');
        $embed.attr('frameborder', 0);
    });

    //格式化date
    $(function () {
        var $date = $('.date');
        $date.html(formatDate(parseInt($date.html())));
    });

    $(function () {
        getReplyList(getCurrentPageNum());
        var $pageSelect = $('.page-select');
        $pageSelect.on('click', '.page-item', function () {
            if ($(this).parent().hasClass("active"))
                return;
            var page = $(this).attr('data-toggle');
            $('body,html').animate({scrollTop: ($('.reply-list').offset().top-50)}, 300);
            getReplyList(page);
        });
    });


    function getReplyList(pageNum) {
        var $replyList = $('.reply-list');
        var pid = getCurPid();
        $.ajax({
            url: "reply/list",
            data: {page: pageNum, pid: pid},
            method: "post",
            beforeSend: function () {
                $replyList.html('<div style="padding: 45%"><img src="img/loading.gif"/></div>');
            },
            success: function (data) {
                var $pageSelect = $('.page-select');
                if(data.pageInfo.pages === 0){
                    $pageSelect.hide();
                    $replyList.html('<div style="margin-top:20px;text-align: center">暂无回复</div>');
                }else if(data.pageInfo.pages === 1){
                    $pageSelect.hide();
                    $replyList.html(getReplyListHtml(data.pageInfo));
                }else {
                    $pageSelect.html(getPageHtml(data.pageInfo));
                    $pageSelect.show();
                    $replyList.html(getReplyListHtml(data.pageInfo));
                }
                return true;
            }, error: function () {
                $replyList.html('<div style="padding: 45% 40%"><a onclick="getPostList(getCurrentId());">加载失败，请重试</a></div>');
                return false;
            }
        });
    }

    var curPid;

    function getCurPid() {
        return curPid === undefined ? curPid = $('input[name=pid]').val() : curPid;
    }

    function getReplyListHtml(pageInfo) {
        var curPage = pageInfo.pageNum;
        var pageSize = pageInfo.pageSize;
        var replies = pageInfo.list;
        console.log(pageInfo);
        var html = '';
        var pattern = '<div class="reply-item">' +
            '<div class="item-head  clearfix">' +
            '<a class="avatar"><img src="${reply[i].uavatar}"></a>' +
            '<div class="title">' +
            '<p>${reply[i].unickname}</p>' +
            '<p></p>' +
            '</div>' +
            '</div>' +
            '<div class="item-content">' +
            '<div class="item-body">' +
            '<p>${reply[i].content}</p>' +
            '</div>' +
            '<div class="item-footer">' +
            '<a class="btn btn-default" href="#" role="button">' +
            '<span class="glyphicon glyphicon-thumbs-up"></span>' +
            '<b class="count">&nbsp;${reply[i].agreeCount}</b>' +
            '</a>' +
            '<a class="btn btn-default show-comment-btn" role="button">' +
            '<span class="glyphicon glyphicon-comment"></span>' +
            '<b class="count">&nbsp;${reply[i].commentCount}</b>' +
            '</a>' +
            '<p class="date pull-right"><span>${floor}楼•${reply[i].replyTime}</span></p>' +
            '</div>' +
            '</div>' +
            '<div class="reply-comment-wrap" hidden>' +
            '<div class="reply-comment panel panel-default">' +
            '<div class="panel-body">' +
            '<div class="comments-body">' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
        var floor = pageSize*(curPage-1);
        for(var i in replies){
            html += pattern.replace('${reply[i].uavatar}',replies[i].uavatar)
                .replace('${reply[i].unickname}',replies[i].unickname)
                .replace('${reply[i].content}',replies[i].content)
                .replace('${floor}',(parseInt(i)+2+floor))
                .replace('${reply[i].agreeCount}',replies[i].agreeCount)
                .replace('${reply[i].commentCount}',replies[i].commentCount)
                .replace('${reply[i].replyTime}',formatDate(replies[i].replyTime));
        }
        return html;
    }
});

