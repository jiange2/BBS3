$(function () {
   $('#login-form').bootstrapValidator({
       message: '校验不通过',
       feedbackIcons: {
           valid: 'glyphicon glyphicon-ok',
           invalid: 'glyphicon glyphicon-remove',
           validating: 'glyphicon glyphicon-refresh'
       },fields: {
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
   }).on('success.form.bv', function(e) {//点击提交之后
       return false;
   });

    $('.login-btn').on('click',function () {
        var $form = $('#login-form');
        $form.bootstrapValidator('validate');
        if($form.data("bootstrapValidator").isValid()){
            var $this = $(this);
            var $username = $('input[name=username]').val();
            var $password = $('input[name=password]').val();
            var $verCode = $('input[name=verCode]').val();
            var $token = $('input[name=token]').val();
            $.ajax({
                url: '/user/login',
                method: 'post',
                data:{
                    username:$username.trim(),
                    password:$password.trim(),
                    verCode:$verCode.trim(),
                    token:$token.trim()
                },
                dataType: 'json',
                beforeSend:function () {
                    $this.attr('disabled',true);
                    $this.html('<img src="img/loading2.gif" style="width: 18px;height: 18px;"/>');
                },
                success:function (data) {
                    if(data.status === 'success'){
                        toastr.success('登录成功');
                        setInterval(function () {
                            location.reload(true);
                        },1500);
                    }else{
                        toastr.error(data.errors);
                        $this.attr('disabled',false);
                        $this.html("登录");
                        reFleshToken();
                        fleshVerCode();
                    }
                }, error:function () {
                    toastr.error("提交失败请重试!");
                    $this.attr('disabled',false);
                    $this.html("登录");
                    reFleshToken();
                    fleshVerCode();
                }
            })
        }
    });

});





