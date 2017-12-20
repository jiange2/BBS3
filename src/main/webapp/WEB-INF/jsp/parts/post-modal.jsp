<%--
  Created by IntelliJ IDEA.
  User: JG
  Date: 2017/12/2
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="post-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog  modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">发表帖子</h4>
            </div>
            <div class="modal-body editor post-form-wrap">
                <form id="post-form">
                    <input type="text" name="token" value="${requestScope.token}" hidden>
                    <div class="form-group">
                        <input type="text" class="form-control" name="title" placeholder="标题">
                    </div>
                    <div id="post-content"></div>
                </form>
                <span class="count-tip">还剩<span class="count-left">1000</span>字</span>
                <span class="uploading-img" hidden>
                        <img src="img/loading.gif" style="width: 50px;height: 50px">
                </span>
            </div>
            <div class="modal-footer">
                <div class="pull-left"></div>
                <div class="pull-right">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary post-submit-btn">提交</button>
                </div>
            </div>
        </div>
    </div>
</div>

