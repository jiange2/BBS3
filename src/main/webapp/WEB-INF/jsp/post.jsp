<%--
  Created by IntelliJ IDEA.
  User: JG
  Date: 2017/12/9
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>帖子内容</title>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>帖子内容</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/post.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]><script src="js/html5shiv.min.js"></script><script src="js/respond.min.js"></script><![endif]-->
    <!-- jQuery -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrapValidator.min.js"></script>
    <script src="js/toastr.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/post.js"></script>
</head>
<body>
<!-- 背景 -->
<jsp:include page="parts/background.jsp"/>
<jsp:include page="parts/navbar.jsp"/>
<!-- 登录模态框 -->
<c:if test="${user == null}">
    <jsp:include page="parts/login-model.jsp"/>
</c:if>
<!-- 右下按钮组 -->
<jsp:include page="parts/fix-btn-group.jsp"/>
<div class="container-wrap">
    <div class="container">
        <div class="content-wrap clearfix">
            <div class="main-content col-sm-12 col-md-9">
                <div class="page-header post-title">
                    <h3>${post.title}<small></small></h3>
                </div>
                <div class="post-content">
                    <div class="content">${post.content}</div>
                    <div class="footer">
                        <span class="date"><span>${post.postTime}</span></span>
                        <span><a href="#"><i class="glyphicon glyphicon-comment"></i> ${post.replyCount}条回复</a></span>
                    </div>
                </div>
                <div class="reply-content">
                    <div class="reply-head"><h3>${post.replyCount}个回复</h3></div>
                    <div class="reply-list">
                        <div class="reply-item">
                        <div class="item-head  clearfix">
                            <a class="avatar"><img src="img/ava.png"></a>
                            <div class="title">
                                <p>用户名-个人站</p>
                                <p></p>
                            </div>
                        </div>
                        <div class="item-content">
                            <div class="item-body">
                                <p>1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111</p>
                            </div>
                            <div class="item-footer">
                                <a class="btn btn-default" href="#" role="button">
                                    <span class="glyphicon glyphicon-thumbs-up"></span>
                                    <b class="count">0</b>
                                </a>
                                <a class="btn btn-default show-comment-btn" role="button">
                                    <span class="glyphicon glyphicon-comment"></span>
                                    <b class="count">0</b>
                                </a>
                                <p class="date pull-right"><span>2015-06-12</span></p>
                            </div>
                        </div>
                        <div class="reply-comment-wrap" hidden>
                            <div class="reply-comment panel panel-default">
                                <div class="panel-body">
                                    <div class="comments-body">
                                        <div class="comment-item clearfix">
                                            <a class="avatar"><img src="img/ava.png"></a>
                                            <div class="title">
                                                <p class="comment-user">用户名-个人站• 2014-10-16 06:51</p>
                                                <p class="comment-content">123</p>
                                            </div>
                                        </div>
                                        <div class="comment-item clearfix">
                                            <a class="avatar"><img src="img/ava.png"></a>
                                            <div class="title">
                                                <p class="comment-user">用户名-个人站</p>
                                                <p class="comment-content">123</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                        <div class="reply-item">
                            <div class="item-head  clearfix">
                                <a class="avatar"><img src="img/ava.png"></a>
                                <div class="title">
                                    <p>用户名-个人站</p>
                                    <p></p>
                                </div>
                            </div>
                            <div class="item-content">
                                <div class="item-body">
                                    <p>1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111</p>
                                </div>
                                <div class="item-footer">
                                    <a class="btn btn-default" href="#" role="button">
                                        <span class="glyphicon glyphicon-thumbs-up"></span>
                                        <b class="count">0</b>
                                    </a>
                                    <a class="btn btn-default show-comment-btn" role="button">
                                        <span class="glyphicon glyphicon-comment"></span>
                                        <b class="count">0</b>
                                    </a>
                                    <p class="date pull-right"><span>2015-06-12</span></p>
                                </div>
                            </div>
                            <div class="reply-comment-wrap" hidden>
                                <div class="reply-comment panel panel-default">
                                    <div class="panel-body">
                                        <div class="comments-body">
                                            <div class="comment-item clearfix">
                                                <a class="avatar"><img src="img/ava.png"></a>
                                                <div class="title">
                                                    <p class="comment-user">用户名-个人站</p>
                                                    <p class="comment-content">123</p>
                                                </div>
                                            </div>
                                            <div class="comment-item clearfix">
                                                <a class="avatar"><img src="img/ava.png"></a>
                                                <div class="title">
                                                    <p class="comment-user">用户名-个人站</p>
                                                    <p class="comment-content">123</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="reply-item">
                        <div class="item-head  clearfix">
                            <a class="avatar"><img src="img/ava.png"></a>
                            <div class="title">
                                <p>用户名-个人站</p>
                                <p></p>
                            </div>
                        </div>
                        <div class="item-content">
                            <div class="item-body">
                                <p>1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111</p>
                            </div>
                            <div class="item-footer">
                                <a class="btn btn-default" href="#" role="button">
                                    <span class="glyphicon glyphicon-thumbs-up"></span>
                                    <b class="count">0</b>
                                </a>
                                <a class="btn btn-default show-comment-btn" role="button">
                                    <span class="glyphicon glyphicon-comment"></span>
                                    <b class="count">0</b>
                                </a>
                                <p class="date pull-right"><span>2015-06-12</span></p>
                            </div>
                        </div>
                        <div class="reply-comment-wrap" hidden>
                            <div class="reply-comment panel panel-default">
                                <div class="panel-body">
                                    <div class="comments-body">
                                        <div class="comment-item clearfix">
                                            <a class="avatar"><img src="img/ava.png"></a>
                                            <div class="title">
                                                <p class="comment-user">用户名-个人站• 2014-10-16 06:51</p>
                                                <p class="comment-content">123</p>
                                            </div>
                                        </div>
                                        <div class="comment-item clearfix">
                                            <a class="avatar"><img src="img/ava.png"></a>
                                            <div class="title">
                                                <p class="comment-user">用户名-个人站</p>
                                                <p class="comment-content">123</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                        <div class="reply-item">
                            <div class="item-head  clearfix">
                                <a class="avatar"><img src="img/ava.png"></a>
                                <div class="title">
                                    <p>用户名-个人站</p>
                                    <p></p>
                                </div>
                            </div>
                            <div class="item-content">
                                <div class="item-body">
                                    <p>1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111</p>
                                </div>
                                <div class="item-footer">
                                    <a class="btn btn-default" href="#" role="button">
                                        <span class="glyphicon glyphicon-thumbs-up"></span>
                                        <b class="count">0</b>
                                    </a>
                                    <a class="btn btn-default show-comment-btn" role="button">
                                        <span class="glyphicon glyphicon-comment"></span>
                                        <b class="count">0</b>
                                    </a>
                                    <p class="date pull-right"><span>2015-06-12</span></p>
                                </div>
                            </div>
                            <div class="reply-comment-wrap" hidden>
                                <div class="reply-comment panel panel-default">
                                    <div class="panel-body">
                                        <div class="comments-body">
                                            <div class="comment-item clearfix">
                                                <a class="avatar"><img src="img/ava.png"></a>
                                                <div class="title">
                                                    <p class="comment-user">用户名-个人站</p>
                                                    <p class="comment-content">123</p>
                                                </div>
                                            </div>
                                            <div class="comment-item clearfix">
                                                <a class="avatar"><img src="img/ava.png"></a>
                                                <div class="title">
                                                    <p class="comment-user">用户名-个人站</p>
                                                    <p class="comment-content">123</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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