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
                        delay: 2000,
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
                        delay : 2000,
                        type : 'post'
                    },
                    emailAddress: {
                        message: '邮箱地址格式有误'
                    }
                }
            },
            verCode:{
                validators: {
                    remote : {
                        threshold : 4,
                        notEmpty: {
                            message: '验证码不能为空'
                        },
                        stringLength: {
                            min: 4
                        },
                        url : 'verify/checkVerCode',
                        message : "验证码错误",
                        delay : 2000,
                        type : 'post'
                    }
                }
            }
        }
    });
});