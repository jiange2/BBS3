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


    $('#post-content').summernote({
        placeholder: '内容',
        minHeight: height,             // set minimum height of editor
        maxHeight: height,             // set maximum height of editor
        focus: true,                  // set focus to editable area after initializing summernote
        lang: 'zh-CN',
        dialogsInBody: true,
        callbacks: {
            onImageUpload: function(files) {
                // upload image to server and create imgNode...
                $(this).summernote('insertImage', uploadImg(files[0],$(this)),'img');
                
            }
        }
    });
    
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
                    alert(data.message);
            },error: function () {
                $('.uploading-img').hide();
                alert('图片上传失败');
            }
        });
        
    }

    $('.post-btn').on('click',function () {
        var $form = $('#post-form');
        $form.bootstrapValidator('validate');
        if($form.data("bootstrapValidator").isValid()){
            var $this = $(this);
            var title = $('input[name=title]').val();
            var content = $('#post-content').summernote('code');
            if(removeTag(content) === ""){
                alert("内容不能为空");
                return false;
            }
            $.ajax({
                data: {title:title,content:content},
                type: "POST",
                url: "post/add",
                dataType: "json",
                beforeSend:function () {
                    var loadingImg = '<img src="img/loading2.gif" style="width: 18px;height: 18px;"/>';
                    $this.attr('disabled',true);
                    $this.html(loadingImg);
                },
                success: function(data) {
                    if(data.result === "success"){
                        $this.html("提交");
                    } else{
                        $this.html("提交");
                        alert(data.message);
                    }
                    $this.attr('disabled',false);
                },error: function () {
                    $this.html("提交");
                    alert('提交失败');
                    $this.attr('disabled',false);
                }
            });
        }
    });

    function beforeSend(sendingMessage,obj) {
    }

    function afterSend(obj) {
        obj.html(obj.attr('data-toggle'));
        obj.attr('disabled',false);
    }

    function removeTag(content) {
        return content.replace(/<.*?>(.*?)<\/.*?>/g,"$1").replace("<br>","");
    }
});