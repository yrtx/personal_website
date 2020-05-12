<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHead.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>

<title>编辑角色</title>
<script>
    $(function(){

        $("#editForm").submit(function(){
            if(!checkEmpty("name","分类名称"))
                return false;

            return true;
        });
    });

</script>

<div class="workingArea">

	<ol class="breadcrumb">
		<li><a href="admin_list_category">所有分类</a></li>
		<li class="active">编辑分类</li>
	</ol>

	<div class="panel panel-warning editDiv">
		<div class="panel-heading">编辑分类</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="admin_update_category" enctype="multipart/form-data">
				<table class="editTable">
					<tr>
						<td>分类名称</td>
						<td><input  id="name" name="categoryName" value="${category.categoryName}" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>分类图片</td>
						<td><input  id="img" name="img" type="file" multiple="image/*" class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="id" value="${category.id}">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>