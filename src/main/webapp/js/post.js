$(function () {
    //消息
    $('.show-comment-btn').on('click',function () {
        var $this = $(this);
        if($this.hasClass('comment-open')){
            $this.removeClass('comment-open');
        }else{
            $this.addClass('comment-open');
        }
        $this.parents('.item-content').nextAll('.reply-comment-wrap').toggle();
    });

    $(function () {
        var $embed = $('.content iframe');
        var $content = $('.content');

        $embed.width($content.width());
        $embed.height($content.width()*10/16);
        $embed.addClass('note-video-clip');
    })
});