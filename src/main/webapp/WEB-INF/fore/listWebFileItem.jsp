<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 28384
  Date: 2020/4/30
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/fore/foreHead.jsp"%>
<html>
<head>
    <title>文件</title>
    <script>
        $(function(){
            $("#addForm").submit(function(){
                if(!checkEmpty("name","评论内容"))
                    return false;
                return true;
            });
        });

    </script>
</head>
<body>
    <div class="container">
        <div class="row" style="float:right">
            <c:if test="${loginUser == null}">
                <a href="loginUI" class="btn btn-link">登录</a>
                <a href="registerUI" class="btn btn-link">注册</a>
            </c:if>
            <c:if test="${loginUser != null}">
                <a href="#" class="btn btn-link">您好,${loginUser.userName}</a>
                <a href="logout" class="btn btn-link">退出</a>
            </c:if>

        </div>
        <div class="row" align="center">
            <a class="btn btn-link" href="main"><h1>星火创意工坊（电子小组）</h1></a>
        </div>
        <div class="row" align="center">
            <h1>${webFile.fileName}</h1>
            <h3>上传用户：${webFile.user.userName}</h3>
            <h3>上传时间：${webFile.createDate}</h3>
            <a href="downloadFile?id=${webFile.id}" class="btn btn-link">单击下载</a>
        </div>
        <div class="row" align="center">
            <div class="panel panel-warning addDiv">
                <div class="panel-body" style="width: 800px">
                    <form method="post" id="addForm" action="addReview?fileId=${webFile.id}&userId=${loginUser.id}">
                        <table class="addTable">
                            <tr>
                                <td>
                                    <textarea id="name" name="content" class="form-control" rows="3" placeholder="如果对你有帮助就添加一个评论吧"></textarea>
                                </td>
                            </tr>
                            <tr class="submitTR">
                                <td colspan="2" align="center">
                                    <button type="submit" class="btn btn-success">提 交</button>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <table class="table table-striped table-bordered table-hover  table-condensed">
                <c:forEach items="${pageInfo.list}" var="review">
                    <tr align="center">
                        <td align="center" width="150px">${review.user.userName}<br/>${review.createDate}</td>
                        <td>${review.content}
                            <c:if test="${review.userId == loginUser.id}">
                                <a href="deleteReview?id=${review.id}&fileId=${review.fileId}">
                                    <span class="glyphicon glyphicon-trash" style="float: right"></span>
                                </a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <jsp:include page="../include/fore/forePage.jsp"></jsp:include>
    </div>
</body>
</html>
