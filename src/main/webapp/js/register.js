$(function () {
    $('#register-form').bootstrapValidator({
        message: '校验不通过',
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
                        message: '用户名已经被使用<a href="login">,登录</a>'
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
                        message : "该邮箱已经使用！<a href=\"login\"'>,登录</a>",
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
            },
            registerCode:{
                validators: {
                    notEmpty: {
                        message: '注册码不能为空'
                    },
                    callback : {
                        message : "注册码错误",
                        callback: function (value,validator, $field) {
                            return true;
                        }
                    }
                }
            }
        }
    });
});

(function () {
    var time = 0;

    $('.get-reg-code-btn').on('click',function () {
        var $this = $(this);
        var $form = $('#register-form');
        var validate = $form.data("bootstrapValidator");
        var $email = $('input[name=email]');
        var $verCode = $('input[name=verCode]');
        if(time < 1){
            if(!validate.isValidField($email)){
                validate.validateField($email);
                if(!validate.isValidField($verCode)){
                    validate.validateField($verCode);
                }
            }else{
                if(!validate.isValidField($verCode)){
                    validate.validateField($verCode);
                }else{
                    if($verCode.nextAll('i').hasClass('glyphicon-ok')){
                        $.ajax({
                            url: 'user/getEmailRegCode',
                            dataType:'json',
                            data:{email:$email.val(),
                                verCode:$verCode.val()},
                            method:'post',
                            beforeSend: function () {
                                beforeSend('正在发送',$this);
                            },
                            success:function (data) {
                                if(data.valid === true || data.lastSendTime !== undefined){
                                    time = parseInt((data.interval -
                                        (new Date().getTime() - data.lastSendTime))/1000);
                                    var message = "邮件已发送";
                                    showMessage(message,$this);
                                    setTimeout(function () {
                                        render(message,$this);
                                    },1000);
                                    if(data.valid === true){
                                        fleshVerCode();
                                    }
                                }else{
                                    validate.revalidateField($email);
                                    validate.revalidateField($verCode);
                                    afterSend($this);
                                }
                            },
                            error:function () {
                                afterSend($this);
                            }
                        });
                    }
                }
            }
        }
    });

    $('#register-form-btn').on('click',function () {
        var $form = $('#register-form');
        $form.bootstrapValidator('validate');
        if($form.data("bootstrapValidator").isValid()){
            var $this = $(this);
            var $token = $('input[name=token]').val();
            var $username = $('input[name=username]').val();
            var $password = $('input[name=password]').val();
            var $email = $('input[name=email]').val();
            var $registerCode = $('input[name=registerCode]').val();
            $.ajax({
                url: '/user/register',
                method: 'post',
                data:{
                    token: $token.trim(),
                    username:$username.trim(),
                    password:$password.trim(),
                    email:$email.trim(),
                    registerCode:$registerCode.trim()
                },
                dataType: 'json',
                beforeSend:function () {
                    beforeSend("",$this);
                },
                success:function (data) {
                    if(data.valid === true){
                        window.location.href = "/index";
                    }else{
                        showError(data.errors);
                        afterSend($this);
                        reFleshToken();
                    }
                },error:function () {
                    $('.error-modal .error-massage').html("提交失败");
                    $('.error-modal').modal('show');
                    afterSend($this);
                    reFleshToken();
                }
            })
        }
    });

    function render(message,ele) {
        --time;
        showMessage(message,ele);
        if(time > 0){
            setTimeout(function () {
                render(message,ele);
            },1000);
        }else{
            afterSend(ele);
        }
    }

    function showMessage(message,ele){
        ele.html(message+time+"秒");
    }


    function showError(errors) {
        var validator = $('#register-form').bootstrapValidator('validate');
        for(var i=0; i<errors.length; ++i){
            if(errors[i] !== "registerCode"){
                validator.revalidateField(errors[i]);
            }else{
                $('input[name=registerCode]')
                    .nextAll('.help-block[data-bv-validator=callback]').show();
            }
        }
    }

    function beforeSend(sendingMessage,obj) {
        var loadingImg = '<img src="img/loading2.gif" width="20px" height="20px"/>';
        obj.attr('disabled',true);
        obj.html(sendingMessage+' '+loadingImg);
    }

    function afterSend(obj) {
        time = 0;
        obj.html(obj.attr('data-toggle'));
        obj.attr('disabled',false);
    }
})();
