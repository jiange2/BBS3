<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>论坛主页</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <style>
        .body-bg{
            position: fixed;
            top: 0;
            left: 0;
            z-index: -1;
        }
        #body-bg-canvas{
            background-color: #16a085;
        }
    </style>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="body-bg absolute-screen-width-100 absolute-screen-height-100">
    <canvas id="body-bg-canvas">浏览器不支持canvas</canvas>
</div>
<div class="fade-nav"></div>
<div class="nav-wrap">
    <div class="container">
        <div class="search-box hidden-xs hidden-sm">
            <form class="navbar-search" id="search-form" action="/query">
                <input class="form-control search-query" name="q" placeholder="搜索话题,问题或人">
                <span id="global-search-btn" onclick="$('#search-form').submit();">
                    <i class="glyphicon glyphicon-search"></i>
                </span>
                <div class="dropdown" hidden>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            请输入关键字进行搜索
                        </div>
                        <div class="panel-footer">
                            <a class="btn btn-success">发起问题</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="navbar navbar-default nav-menu">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#menu-collapse" aria-expanded="true">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse absolute-screen-width-100" id="menu-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" class="active"><span class="glyphicon glyphicon-align-left"></span> 主页</a>
                    </li>
                    <li><a href="#"><span class="glyphicon glyphicon-comment"></span> 话题</a></li>
                </ul>
            </div>
        </div>
        <div class="nav-user">
            <ul class="list-inline">
                <li class="position-relative">
                    <a href="#" class="btn-login btn btn-primary">登录</a>
                    <div class="login-form-wrap" hidden>
                        <form id="login-form">
                            <div class="input-group input-group-lg">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span>
                            </span>
                                <input type="text" class="form-control" name="username" placeholder="请输入用户名"
                                       aria-describedby="sizing-addon1">
                            </div>
                            <div class="input-group input-group-lg">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-lock"></span>
                            </span>
                                <input type="password" class="form-control" name="password" placeholder="请输入密码"
                                       aria-describedby="sizing-addon1">
                            </div>
                            <a class="btn btn-success btn-block">登录</a>
                        </form>
                    </div>
                    <div class="arrow-up" hidden></div>
                </li>
                <li>
                    <a href="register" class="btn btn-success">注册</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="container-wrap">
    <div class="container">
        <div class="content-wrap clearfix">
            <div class="main-content col-sm-12 col-md-9">
                <div class="nav-tabs-wrap">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#">最新</a></li>
                        <li><a href="#">推荐</a></li>
                        <li><a href="#">热门</a></li>
                        <li><a href="#">等待回复</a></li>
                    </ul>
                </div>
                <div class="post-list">
                    <div class="post-list-body">
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                        <div class="post-item clearfix">
                            <a class="avatar pull-left">
                                <img src="img/ava.png">
                            </a>
                            <div class="post-content">
                                <p class="post-title"><a href="#">有没有办法修改一下博客网页上面的字体</a></p>
                                <p class="post-sub">
                                    <a href="#"><span class="badge">主题</span></a>
                                    <span>
                                    • <a href="#">user</a> 发起了问题 • 1 人关注 • 0 个回复 • 325 次浏览 • 2017-10-07 15:47
                                </span>
                                    <a href="#" class="pull-right">回复</a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <ul class="pagination pull-right">
                    <li><a href="#">&laquo;</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
            <div class="side-bar hidden-xs hidden-sm col-md-3">
                <div class="page-header">
                    <h5>热门帖子
                        <small><a href="#" class="pull-right">更多</a></small>
                    </h5>
                </div>
                <div class="page-header">
                    <h5>热门用户
                        <small><a href="#" class="pull-right">更多</a></small>
                    </h5>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="footer-wrap">
    <div class="footer">
        Copyright © 2017<span class="hidden-xs"> - 京ICP备xxxxxxx号, All Rights Reserved</span>
        <span class="hide">Powered By
            <a href="http://www.wecenter.com/?copyright" target="blank">WeCenter 3.0 Beta 2</a>
        </span>
    </div>
</div>

</body>
</html>
<!-- jQuery -->
<script src="js/jquery-3.2.1.min.js"></script>
<!-- Bootstrap js -->
<script src="js/bootstrap.min.js"></script>
<script src="js/common.js"></script>
<script src="js/bgDraw.js"></script>
</body>
</html>