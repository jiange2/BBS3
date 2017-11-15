$(function () {
    fillSize();
});
$(window).resize(function () {
    fillSize();
});

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

var $searchQuery = $('.search-query');

$searchQuery.on('focus',function () {
    $(this).nextAll('.dropdown').show();
});

$searchQuery.on('blur',function () {
    $(this).nextAll('.dropdown').fadeOut(500);
});

$('.btn-login').on('click',function () {
   $(this).nextAll('.login-form-wrap').fadeToggle();
    $(this).nextAll('.arrow-up').fadeToggle();
});

$('.show-comment-btn').on('click',function () {
    var $this = $(this);
    if($this.hasClass('comment-open')){
        $this.removeClass('comment-open');
    }else{
        $this.addClass('comment-open');
    }
    $this.parents('.item-content').nextAll('.reply-comment-wrap').toggle();
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





