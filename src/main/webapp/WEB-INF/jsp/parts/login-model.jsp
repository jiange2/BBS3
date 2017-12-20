<%--
  Created by IntelliJ IDEA.
  User: JG
  Date: 2017/11/29
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/parts/login-modal.js"></script>
<div id="login-model" class="modal enter-post fade bs-example-modal-sm" tabindex="-1" role="dialog"
     aria-labelledby="mySmallModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <div class="modal-header">
                <h3 class="modal-title" id="myModalLabel">登录<small class="subTitle"></small></h3>
            </div>
            <div class="modal-body">
                <div class="login-form-wrap form-wrap">
                    <form id="login-form">
                        <input type="text" name="token" value="${requestScope.token}" hidden>
                        <div class="form-group input-group-lg">
                            <span class="input-before glyphicon glyphicon-user"></span>
                            <input type="text" class="form-control" name="username"
                                   placeholder="请输入用户名"
                                   aria-describedby="sizing-addon1">
                        </div>
                        <div class="form-group input-group-lg">
                            <span class="input-before glyphicon glyphicon-lock"></span>
                            <input type="password" class="form-control" name="password"
                                   placeholder="请输入密码"
                                   aria-describedby="sizing-addon1">
                            <span class="input-after"><a href="#">忘记密码?</a></span>
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
                        <a class="btn btn-success  submit-btn btn-block login-btn">登录</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>