<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHead.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>后台主页</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h1 class="h1">分类数：${categoryNum}</h1>
        <h1 class="h1">文件数：${webFileNum}</h1>
        <h1 class="h1">评论数：${reviewNum}</h1>
        <h1 class="h1">用户数：${userNum}</h1>
    </div>
</div>
</body>
</html>
