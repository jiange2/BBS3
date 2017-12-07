$(function () {
    fillSize();

    var $searchQuery = $('.search-query');

    $searchQuery.on('focus',function () {
        $(this).nextAll('.dropdown').show();
    });

    $searchQuery.on('blur',function () {
        $(this).nextAll('.dropdown').fadeOut(500);
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

    $('.flesh-ver-code').on('click',function () {
        fleshVerCode();
    });

    $(window).resize(function () {
        fillSize();
    });

    (function () {
        var hideFlag = true;
        var animateTime = 300;

        $(window).scroll(function () {
            var scrollTop = window.pageYOffset||document.documentElement.scrollTop || document.body.scrollTop;
            var windowHeight = $(window).height()/2;
            var $fixedBtnGroup = $('.fixed-btn-group');

            if(scrollTop > windowHeight && hideFlag){
                hideFlag = false;
                $fixedBtnGroup.animate({bottom: "10px"},animateTime);
            }
            if(scrollTop < windowHeight && !hideFlag)
            {
                hideFlag = true;
                $('.fixed-btn-group').animate({bottom: "-50px"},animateTime);
            }
        });

        $('.back-to-top-btn').on('click',function () {
            $('body,html').animate({ scrollTop: 0 }, animateTime);
        });

        $('body,html').trigger('scroll');
    })();

    if($(window).width() > 768){
        $("[data-toggle='tooltip']").tooltip();
    }

    $('.add-post-btn').on('click',function () {
        $('#post-modal').modal('show');
    });

    $('.btn-login').on('click',function () {
        $('#login-model').modal('show');
    });

    $('.enter-post').on('keydown',function (e) {
        if((e.keyCode || e.which) === 13){
            $(this).find('.submit-btn').trigger('click');
        }
    });
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

function fleshVerCode() {
    var verCode = $('#ver-code');
    verCode.attr('src','/verify/verCode?timestamp='+new Date().getTime());
}









