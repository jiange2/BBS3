<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrapValidator.min.js"></script>
    <script src="js/common.js"></script>
</head>
<body>

<!-- 背景 -->
<jsp:include page="parts/background.jsp"/>
<jsp:include page="parts/navbar.jsp"/>
<!-- 登录模态框 -->
<c:if test="${user == null}">
    <jsp:include page="parts/login-model.jsp"/>
</c:if>
<jsp:include page="parts/error-modal.jsp"/>
<!-- 右下按钮组 -->
<jsp:include page="parts/fix-btn-group.jsp"/>

<!-- 提交模态框 -->
<jsp:include page="parts/post-modal.jsp"/>
<div class="container-wrap">
    <div class="container">
        <div class="content-wrap clearfix">
            <div class="main-content col-sm-12 col-md-9">
                <div class="nav-tabs-wrap">
                    <ul class="nav nav-pills nav-justified">
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
                    </div>
                </div>
                <ul class="nav nav-pills nav-justified page-select">
                    <li><a href="#">&laquo;</a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>
            <div class="side-bar hidden-xs hidden-sm col-md-3">
                <div class="page-header">
                    <h5>热门帖子
                        <small><a href="#" class="pull-right">更多>></a></small>
                    </h5>
                </div>
                <div class="page-header">
                    <h5>热门用户
                        <small><a href="#" class="pull-right">更多>></a></small>
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
</body>
</html>