$(function () {
    if(window.history && window.history.pushState){
        $(window).on('popstate', function () {
            getPostList(getCurrentPageNum());
        });
    }

    getPostList(getCurrentPageNum());
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

function getPostList(id) {
    var $postListBody = $('.post-list-body');
    $.ajax({
        url:"post/list/"+id,
        method: "post",
        beforeSend:function () {
            $postListBody.html('<div style="padding: 45%"><img src="img/loading.gif"/></div>');
        },
        success:function (data) {
            var $pageSelect = $('.page-select');
            if(data.pageInfo.pages === 0){
                $pageSelect.hide();
                $postListBody.html('<div style="margin-top:20px;text-align: center">暂无回复</div>');
            }else if(data.pageInfo.pages === 1){
                $pageSelect.hide();
                $postListBody.html(getPostListHtml(data.pageInfo.list));
            }else {
                $pageSelect.html(getPageHtml(data.pageInfo));
                $pageSelect.show();
                $postListBody.html(getPostListHtml(data.pageInfo.list));
            }
            return true;
        },error:function () {
            $postListBody.html('<div style="padding: 45% 40%"><a onclick="getPostList(getCurrentPageNum());">加载失败，请重试</a></div>');
            return false;
        }
    });
}


function getPostListHtml(posts) {
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







