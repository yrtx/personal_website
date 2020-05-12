<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHead.jsp"%>

<title>编辑角色</title>
<script>
    $(function(){
        $("#sendCaptcha").click(function () {
            var email = $("#noemail").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/fore/sendCaptcha",
                data:{"email":email},
            });
        });


        $("#editForm").submit(function(){
            if(!checkEmpty("noemail","邮箱"))
                return false;
            if(!checkEmpty("captcha","验证码"))
                return false;
            if(!checkEmpty("pwd","密码"))
                return false;
            return true;
        });
    });

</script>

<div class="workingArea">

	<div class="panel panel-warning editDiv">
		<div class="panel-heading">修改用户</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="${pageContext.request.contextPath}/fore/updateUser">
				<table class="editTable">
					<tr>
						<td>请输入邮箱</td>
						<td><input  id="email" name="noemail" type="text" class="form-control"></td>
					</tr>
					<tr>
                        <td><button class="btn btn-default" id="sendCaptcha">获取验证码</button></td>
                        <td><input  id="captcha" name="captcha" type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>新的密码</td>
						<td><input  id="pwd" name="pwd" type="password" class="form-control"></td>
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