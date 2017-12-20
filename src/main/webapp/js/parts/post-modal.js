$(function () {

    $('#post-form').bootstrapValidator({
        message: '校验不通过',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },fields: {
            title: {
                message: '标题验证失败',
                validators: {
                    threshold: 9,
                    notEmpty: {
                        message: '标题不能为空'
                    },
                    stringLength: {
                        min: 5,
                        max: 30,
                        message: '标题长度为5-30之间'
                    }
                }
            }
        }
    });

    var width = $(window).width();
    var height;
    if(width > 768){
        height = $(window).height() * 0.5;
    }else{
        height = $(window).height() * 0.35;
    }
    console.log($(window).height());

    $(function () {
        var postToolbar = [
            ['style',['style']],
            ['style', ['bold', 'italic', 'underline','color', 'fontname','clear']],
            ['para', ['ul', 'ol', 'table','paragraph']],
            ['insert',['link','picture','video']]
        ];
        var replyToolbar =[
            ['style',['style']],
            ['style', ['bold', 'italic', 'underline','color', 'fontname','clear']],
            ['para', ['ul', 'ol', 'table','paragraph']],
            ['insert',['link','picture']]
        ];
        var postEditorInit = false;
        var replyEditorInit = false;
        $('.show-post-modal-btn').on('click',function () {
            if(!postEditorInit){
                initEditor($('#post-content'),postToolbar);
            }
            $('#post-modal').modal('show');
        });
        $('.show-reply-modal-btn').on('click',function () {
            if(!replyEditorInit){
                initEditor($('#reply-content'),replyToolbar);
            }
            $('#reply-modal').modal('show');
        });
    });

    var maxOfWords = 3000;

    function initEditor($editor,toolbar) {
        if($editor !== undefined){
            $editor.summernote({
                placeholder: '内容',
                minHeight: height,
                maxHeight: height,
                focus: true,
                lang: 'zh-CN',
                toolbar: toolbar,
                dialogsInBody: true,
                callbacks: {
                    onImageUpload: function (files) {
                        $(this).summernote('insertImage', uploadImg(files[0], $(this)), 'img');
                    },
                    onChange: function (contents, $editable) {
                        var $count = $(this).parent().nextAll('.count-tip').children('.count-left');
                        $count.html(maxOfWords-getRichTextLength(contents));
                    }
                }
            })
        }

    }
    function uploadImg(file,$this) {
        if(file.size > 1024 * 1024){
            alert('图片文件过大,文件最大可为1M');
            return;
        }
        var data = new FormData();
        data.append("file", file);
        console.log(data);
        $.ajax({
            data: data,
            type: "POST",
            url: "upload/img",
            cache: false,
            contentType: false,
            processData: false,
            beforeSend:function () {
                $('.uploading-img').show();
            },
            success: function(data) {
                $('.uploading-img').hide();
                if(data.result === "success")
                    $this.summernote('insertImage', data.url, 'image name'); // the insertImage API
                else
                    toastr.error(data.message);
            },error: function () {
                $('.uploading-img').hide();
                toastr.error('图片上传失败');
            }
        });

    }
    function submit(data,url,$btn) {
        $.ajax({
            data: data,
            type: "POST",
            url: url,
            dataType: "json",
            beforeSend:function () {
                var loadingImg = '<img src="img/loading2.gif" style="width: 18px;height: 18px;"/>';
                $btn.attr('disabled',true);
                $btn.html(loadingImg);
            },
            success: function(data) {
                if(data.status === "success"){
                    toastr.success("提交提交成功!");
                    setInterval(function () {
                        location.reload(true);
                    },1500);
                } else{
                    toastr.error(data.errors);
                    $btn.html("提交");
                    $btn.attr('disabled',false);
                    reFleshToken();
                }
            },error: function () {
                toastr.error("提交失败!");
                $btn.html("提交");
                $btn.attr('disabled',false);
                reFleshToken();
            }
        });
    }

    $('.reply-submit-btn').on('click',function () {
        var $this = $(this);
        var content = $('#reply-content').summernote('code');
        content = content.replace(new RegExp('</pre><pre>','g'),'<br>');
        var pid = $('input[name=pid]').val();
        var token = $('input[name=token]').val();
        if(getRichTextLength(content) > maxOfWords){
            toastr.error("请保证文本少于1000字");
            return false;
        }
        submit({pid:pid,token:token,content:content},"reply/add",$this);

    });

    $('.post-submit-btn').on('click',function () {
        var $form = $('#post-form');
        $form.bootstrapValidator('validate');
        if($form.data("bootstrapValidator").isValid()){
            var $this = $(this);
            var title = $('input[name=title]').val();
            var content = $('#post-content').summernote('code');
            content = content.replace(new RegExp('</pre><pre>','g'),'<br>');
            var $token = $('input[name=token]').val();
            if(getRichTextLength(content) > maxOfWords){
                toastr.error("请保证文本少于1000字");
                return false;
            }
            submit({token:$token,title:title,content:content},"post/add",$this);
        }
    });

    function getRichTextLength(text) {
        var result = text.replace(/<(\/?)(.+?)>/g,"");
        console.log(result);
        return result.length;
    }
});