<%--
  Created by IntelliJ IDEA.
  User: JG
  Date: 2017/11/14
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="<%=basePath%>">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>注册</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrapValidator.min.css" rel="stylesheet"/>
    <link href="css/register.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]><script src="js/html5shiv.min.js"></script><script src="js/respond.min.js"></script><![endif]-->
</head>
<body>

<jsp:include page="parts/error-modal.jsp"/>
<div class="body-bg absolute-screen-width-100 absolute-screen-height-100">
    <canvas id="body-bg-canvas">浏览器不支持canvas</canvas>
</div>
<div class="form-wrap container col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6">
    <div class="center-block logo"><h1><span class="glyphicon glyphicon-th-list"></span> 论坛名</h1></div>
    <form id="register-form" action="/index.html">
        <input type="text" name="token" value="${token}" hidden>
        <div class="form-group">
            <span class="input-before glyphicon glyphicon-user"></span>
            <input type="text" class="form-control" name="username"  placeholder="用户名">
        </div>
        <div class="form-group">
            <span class="input-before glyphicon glyphicon-lock"></span>
            <input type="password" class="form-control" name="password" placeholder="密码">
        </div>
        <div class="form-group">
            <span class="input-before glyphicon glyphicon-lock"></span>
            <input type="password" class="form-control" name="rePassword" placeholder="确认密码">
        </div>
        <div class="form-group">
            <span class="input-before glyphicon glyphicon-envelope"></span>
            <input type="email" name="email" class="form-control" placeholder="邮箱">
        </div>
        <div class="form-group clearfix">
            <div class="col-xs-7 position-relative form-item-wrap">
                <a href="#" onclick="return false" class="flesh-ver-code">
                    <span class="input-before glyphicon glyphicon-refresh"></span>
                </a>
                <input type="text" name="verCode" class="form-control" placeholder="验证码">
            </div>
            <div class="col-xs-5" style="padding-right: 0">
                <a class="flesh-ver-code"><img id="ver-code" src="/verify/verCode" style="width:100%;height: 42px;" ></a>
            </div>
        </div>
        <div class="form-group clearfix">
            <div class="col-xs-7 position-relative form-item-wrap">
                <span class="input-before glyphicon glyphicon-envelope"></span>
                <input type="text" name="registerCode" class="form-control" placeholder="注册码">
            </div>
            <div class="col-xs-5">
                <a class="btn btn-default get-reg-code-btn" data-toggle="获取注册码">获取注册码</a>
            </div>
        </div>
        <a type="button" class="btn btn-block" id="register-form-btn" data-toggle="注册">注册</a>
    </form>

</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrapValidator.min.js"></script>
<script src="js/common.js"></script>
<script src="js/bgDraw.js"></script>
<script src="js/validate.js"></script>
<script>
</script>
</body>
</html>