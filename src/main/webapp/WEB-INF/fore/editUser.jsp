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

	<div class="panel panel-warning editDiv">
		<div class="panel-heading">修改用户</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="updateUser">
				<table class="editTable">
					<tr>
						<td>用户邮箱</td>
						<td><input  id="email" name="email" value="${user.email}" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>用户密码</td>
						<td><input  id="pwd" name="pwd" value="${user.pwd}" type="password" class="form-control"></td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="id" value="${user.id}">
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>