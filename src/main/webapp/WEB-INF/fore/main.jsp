<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 28384
  Date: 2020/4/29
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/fore/foreHead.jsp"%>
<html>
<head>
    <title>前台主页</title>

</head>
<body>
    <div class="container">
        <div class="row" style="float:right">
            <a href="uploadFileUI" class="btn btn-link">上传文件</a>
            <c:if test="${loginUser == null}">
                <a href="loginUI" class="btn btn-link">登录</a>
                <a href="registerUI" class="btn btn-link">注册</a>
            </c:if>
            <c:if test="${loginUser != null}">
                <a href="editUser?id=${loginUser.id}" class="btn btn-link">您好,${loginUser.userName}</a>
                <a href="logout" class="btn btn-link">退出</a>

            </c:if>

        </div>
        <div class="row" align="center">
            <a class="btn btn-link" href="main"><h1>星火创意工坊（电子小组）</h1></a>
        </div>
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div style="width:500px;float:left;margin:0 auto" align="center">
                    <a href="listWebFileItemByCategory?id=${category.id}">
                        <img width="300" height="200" src="${pageContext.request.contextPath}/img/${category.id}.jpg" class="img-circle">
                        <h2>${category.categoryName}</h2>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
