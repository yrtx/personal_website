<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHead.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>


<title>文件管理</title>

<div class="container">
    <h1 class="label label-info" >文件管理</h1>
    <br>
    <br>

    <div class="row">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>文件名</th>
                <th>创建时间</th>
                <th>所属分类</th>
                <th>上传用户</th>
                <th>下载量</th>
                <th>点击更改状态</th>
                <th>评论管理</th>
                <th>操作</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="webFile">
                <tr>
                    <td>${webFile.id}</td>
                    <td>${webFile.fileName}</td>
                    <td>${webFile.createDate}</td>
                    <td>${webFile.category.categoryName}</td>
                    <td>${webFile.user.userName}</td>
                    <td>${webFile.downloadNum}</td>
                    <td>
                        <a id="isAllow" class="${webFile.isAllow == 'N' ? 'btn btn-danger' : 'btn btn-success'}" href="isAllow?id=${webFile.id}&isAllow=${webFile.isAllow}">${webFile.isAllow == 'N' ? '未上架' : '已上架'}</a>
                    </td>
                    <td><a href="admin_list_review?id=${webFile.id}"><span class="glyphicon glyphicon-record"></span></a></td>
                    <td><a deleteLink="true" href="admin_delete_webFile?id=${webFile.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <%@include file="../include/admin/adminPage.jsp" %>

</div>