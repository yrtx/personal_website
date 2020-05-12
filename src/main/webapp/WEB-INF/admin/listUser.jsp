<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHead.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<title>用户管理</title>

<div class="container">
    <h1 class="label label-info" >用户管理</h1>
    <br>
    <br>

    <div class="row">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>用户名</th>
                <th>用户邮箱</th>
                <th>用户角色管理</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <td><a href="admin_edit_user_role?id=${user.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%@include file="../include/admin/adminPage.jsp" %>
</div>