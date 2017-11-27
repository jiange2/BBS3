$(function () {
    $('#register-form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        }, fields: {
            username: {
                message: '用户名验证失败',
                validators: {
                    threshold : 9,
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z]+[\w]+$/,
                        message: '用户名必须由英文字母开头'
                    },
                    stringLength: {
                        min: 9,
                        max: 20,
                        message: '用户名长度为9-20之间'
                    },remote:{
                        url: '/user/checkUsername',
                        type: 'post',
                        delay: 1000,
                        message: '用户名已经被使用'
                    }
                }
            },
            password: {
                message: '密码验证失败',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 50,
                        message: '密码长度为6-50之间'
                    }
                }
            },
            rePassword: {
                message: '确认密码验证失败',
                validators: {
                    identical: {
                        field: 'password',
                        message: '两次密码不同请重新输入'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: '邮箱地址不能为空'
                    },
                    remote : {
                        url : 'user/checkEmail',
                        message : "该邮箱已经使用！",
                        delay : 1000,
                        type : 'post'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
                }
            },
            verCode:{
                validators: {
                    threshold : 4,
                    notEmpty: {
                        message: '验证码不能为空'
                    },
                    stringLength: {
                        min: 4,
                        message : "验证码长度为4位"
                    },
                    remote : {
                        url : 'verify/checkVerCode',
                        message : "验证码错误",
                        delay : 1000,
                        type : 'post'
                    }
                }
            }
        }
    });


});
var time = 0;

$('.get-reg-code-btn').on('click',function () {
    if(time < 1){
        var $form = $('#register-form');

        var $this = $(this);
        time = 90;
        var message = "邮件已发送";
        var text = $this.html();
        var $email = $('input[name=email]');
        $this.css('disabled',true);
        $this.addClass('active');

        if($email.nextAll('i').hasClass('glyphicon-ok')){
            var verCode = $('input[name=verCode]');
            if(verCode.nextAll('i').hasClass('glyphicon-ok')){
                $.ajax({
                    url: 'user/getEmailRegCode',
                    dataType:'json',
                    data:{email:$email.val(),
                        verCode:verCode.val()},
                    method:'post',
                    beforeSend:function () {
                        $this.html('正在发送...');
                    },
                    success:function (data) {
                        if(data.message !== undefined){
                            time = 5;
                            $this.html(data.message+"("+time+")");
                            setTimeout(function () {
                                render(text,data.message,$this);
                            },1000);
                        }else {
                            time = parseInt((data.interval - (new Date().getTime() - data.leftTime))/1000);
                            if(time > 0){
                                $this.html(message+"("+time+")");
                                setTimeout(function () {
                                    render(text,message,$this);
                                },1000);
                            }else{
                                time = 0;
                                $this.css('disabled',false);
                                $this.removeClass('active');
                                $this.html(text);
                            }
                        }
                    },
                    error:function () {
                        time = 0;
                        $this.css('disabled',false);
                        $this.removeClass('active');
                        $this.html(text);
                    }
                });
            }else{
                time = 3;
                $this.html("请正确输入验证码("+time+")");
                setTimeout(function () {
                    render(text,"请正确输入验证码",$this);
                },1000);
            }
        }else{
            time = 3;
            $this.html("请正确输入邮箱("+time+")");
            setTimeout(function () {
                render(text,"请正确输入邮箱",$this);
            },1000);
        }
    }
});

function render(text,message,ele) {
    --time;
    ele.html(message+"("+time+")");
    if(time > 0){
        setTimeout(function () {
            render(text,message,ele);
        },1000);
    }else{
        ele.css('disabled',false);
        ele.removeClass('active');
        ele.html(text);
    }
}

$('#register-form-btn').on('click',function () {
    var $form = $('#register-form');
    $form.bootstrapValidator('validate');
    if($form.data("bootstrapValidator").isValid()){
        var $this = $(this);
        var $token = $('input[name=token]').val();
        var $username = $('input[name=username]').val();
        var $password = $('input[name=password]').val();
        var $rePassword = $('input[name=rePassword]').val();
        var $email = $('input[name=email]').val();
        var $registerCode = $('input[name=registerCode]').val();
        $.ajax({
            url: '/user/register',
            method: 'post',
            data:{
                token: $token.trim(),
                username:$username.trim(),
                password:$password.trim(),
                rePassword:$rePassword.trim(),
                email:$email.trim(),
                registerCode:$registerCode.trim()
            },
            dataType: 'json',
            beforeSend:function () {
                $this.css('disabled',true);
                $this.addClass('opacity',0.6);
                $this.html("提交注册中...");
            },
            success:function (data) {
                if(data.status === 'success'){
                    window.location.href = "/index";
                }else{
                    $('.error-modal .error-massage').html(data.errors);
                    $('.error-modal').modal('show');
                    $this.css('disabled',false);
                    $this.addClass('opacity',1);
                    $this.html("注册");
                    getToken();
                }
            },error:function (data) {
                $('.error-modal .error-massage').html("提交失败");
                $('.error-modal').modal('show');
                $this.css('disabled',false);
                $this.addClass('opacity',1);
                $this.html("注册");
                getToken();
            }
        })
    }
});

function getToken() {
    $.ajax({
        url:'/verify/getToken',
        dataType:'text',
        success:function (data) {
            $('input[name=token]').val(data);
        }
    })
}