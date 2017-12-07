<%--
  Created by IntelliJ IDEA.
  User: JG
  Date: 2017/11/29
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .body-bg {
        position: fixed;
        top: 0;
        left: 0;
        z-index: -1;
    }
    #body-bg-canvas {
        background-color: #16a085;
    }
</style>
<script src="js/bgDraw.js"></script>
<div class="body-bg absolute-screen-width-100 absolute-screen-height-100">
    <canvas id="body-bg-canvas">浏览器不支持canvas</canvas>
</div>

</body>
</html>
