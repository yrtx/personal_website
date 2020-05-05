<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHead.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function(){
        $("#addForm").submit(function(){
            if(!checkEmpty("name","角色名称"))
                return false;
            return true;
        });
    });


</script>

<title>评论管理</title>

<div class="container">
    <h1 class="label label-info" >评论管理</h1>
    <br>
    <br>

    <div class="row">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>评论内容</th>
                <th>时间</th>
                <th>用户</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="review">
                <tr>
                    <td>${review.id}</td>
                    <td>${review.content}</td>
                    <td>${review.createDate}</td>
                    <td>${review.user.userName}</td>
                    <td><a deleteLink="true" href="admin_delete_review?id=${review.id}&fileId=${review.fileId}"><span class="glyphicon glyphicon-trash"></span></a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%@include file="../include/admin/adminPage.jsp" %>
</div>