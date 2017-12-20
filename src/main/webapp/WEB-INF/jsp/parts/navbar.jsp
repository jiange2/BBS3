<%--
  Created by IntelliJ IDEA.
  User: JG
  Date: 2017/11/29
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<div class="fade-nav"></div>
<div class="nav-wrap">
    <div class="container">
        <div class="search-box hidden-xs hidden-sm">
            <form class="navbar-search" id="search-form" action="/query">
                <input class="form-control search-query" name="q" placeholder="搜索话题,问题或人">
                <span id="global-search-btn" onclick="$('#search-form').submit();">
                    <i class="glyphicon glyphicon-search"></i>
                </span>
                <div class="search-box-dropdown" hidden>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            请输入关键字进行搜索
                        </div>
                        <div class="panel-footer">
                            <a class="btn btn-success add-post-btn show-post-modal-btn">发起问题</a>
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
                        <a href="#" <c:if test="${param.active == 'index'}">class="active"</c:if>><span class="glyphicon glyphicon-align-left"></span> 主页</a>
                    </li>
                    <li><a href="#" <c:if test="${param.active == 'topic'}">class="active"</c:if>><span class="glyphicon glyphicon-comment"></span> 话题</a></li>
                </ul>
            </div>
        </div>
        <div class="nav-user">
            <ul class="list-inline">
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <li>
                            <a class="btn-login btn btn-primary  token-btn">登录</a>
                        </li>
                        <li>
                            <a href="register" class="btn btn-success">注册</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="dropdown">
                            <a href="#" class="avatar-wrap dropdown-toggle" data-toggle="dropdown"
                               role="button" aria-haspopup="true" aria-expanded="false">
                                <img src="${sessionScope.user.avatar}" class="avatar"/>
                            </a>
                            <div class="dropdown-menu">
                            </div>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
