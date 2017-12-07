<%--
  Created by IntelliJ IDEA.
  User: JG
  Date: 2017/12/3
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="fixed-btn-group">
        <ul class="list-unstyled">
            <c:choose>
                <c:when test="${user !=null}">
                    <li>
                        <a class="add-post-btn btn btn-default" data-container="body" data-toggle="tooltip" data-placement="left" data-original-title="发表帖子">
                            <span class="glyphicon glyphicon-plus"></span>
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a class="btn btn-default btn-login" data-container="body" data-toggle="tooltip" data-placement="left" data-original-title="发表帖子">
                            <span class="glyphicon glyphicon-plus"></span>
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
            <li>
                <a class="back-to-top-btn btn btn-default" data-container="body" data-toggle="tooltip" data-placement="left" data-original-title="回到顶部">
                    <span class="glyphicon glyphicon-arrow-up"></span>
                </a>
            </li>
        </ul>
    </div>
</body>
</html>
