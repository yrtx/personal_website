<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 28384
  Date: 2020/5/1
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/fore/foreHead.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="row" style="float:right">
            <c:if test="${loginUser == null}">
                <a href="${pageContext.request.contextPath}/fore/loginUI" class="btn btn-link">登录</a>
                <a href="${pageContext.request.contextPath}/fore/registerUI" class="btn btn-link">注册</a>
            </c:if>
            <c:if test="${loginUser != null}">
                <a href="#" class="btn btn-link">您好,${loginUser.userName}</a>
                <a href="${pageContext.request.contextPath}/fore/logout" class="btn btn-link">退出</a>
            </c:if>
        </div>
        <div class="row" align="center">
            <a class="btn btn-link" href="main"><h1>星火创意工坊（电子小组）</h1></a>
        </div>
        <div class="row">
            <table align="center">
                <c:if test="${pageInfo.list.size() <= 0}">
                    <h2 align="center">该分类暂时没有文件</h2>
                </c:if>
                <c:if test="${pageInfo.list.size() > 0}">
                    <c:forEach items="${pageInfo.list}" var="webFile">
                        <tr>
                            <td width="240" align="center">
                                <a href="${pageContext.request.contextPath}/fore/listWebFileItem?id=${webFile.id}">
                                    <img class="img-circle" src="${pageContext.request.contextPath}/img/fileImg.jpg"  width="200" height="180"><br/>
                                    文件名：${webFile.fileName}<br/>
                                    下载量：${webFile.downloadNum}
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
    </div>
</body>
</html>
