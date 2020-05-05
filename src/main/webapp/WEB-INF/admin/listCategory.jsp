<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHead.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<script>
    $(function(){
        $("#addForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;
            return true;
        });
    });

</script>

<title>分类管理</title>

<div class="container">
    <h1 class="label label-info" >分类管理</h1>
    <br>
    <br>

    <div class="row">
        <table class="table table-striped table-bordered table-hover  table-condensed">
            <thead>
            <tr class="success">
                <th>ID</th>
                <th>分类名称</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.categoryName}</td>
                    <td><a href="admin_edit_category?id=${category.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a deleteLink="true" href="admin_delete_category?id=${category.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%@include file="../include/admin/adminPage.jsp" %>
    <div class="row">
        <div class="panel panel-warning addDiv">
            <div class="panel-heading">新增分类</div>
            <div class="panel-body">
                <form method="post" id="addForm" action="admin_add_category">
                    <table class="addTable">
                        <tr>
                            <td>分类名称</td>
                            <td><input  id="name" name="categoryName" type="text" class="form-control"></td>
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
</div>