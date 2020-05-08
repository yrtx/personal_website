<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/fore/foreHead.jsp"%>
<script>
    $(function(){
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility","visible");
        </c:if>

        $("#sendCaptcha").click(function () {
            if(0==$("#email").val().length) {
                alert("请先输入邮箱");
                return false;
            }
            var email = $("#email").val();
            $.ajax({
                url:"${pageContext.request.contextPath}/fore/sendCaptcha",
                data:{"email":email}
            });
        });

        $(".registerForm").submit(function(){
            if(0==$("#name").val().length){
                $("span.errorMessage").html("请输入用户名");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#email").val().length){
                $("span.errorMessage").html("请输入邮箱");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#password").val().length){
                $("span.errorMessage").html("请输入密码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#captcha").val().length){
                $("span.errorMessage").html("请输入验证码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#repeatpassword").val().length){
                $("span.errorMessage").html("请输入重复密码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if($("#password").val() !=$("#repeatpassword").val()){
                $("span.errorMessage").html("重复密码不一致");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            return true;
        });


    })
</script>

<form method="post" action="register" class="registerForm">
	<div class="registerDiv">
		<div class="registerErrorMessageDiv">
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
				<span class="errorMessage"></span>
			</div>
		</div>
		<table class="registerTable" align="center">
			<tr>
				<td  class="registerTip registerTableLeftTD">设置用户名/邮箱</td>
				<td></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">登陆名</td>
				<td  class="registerTableRightTD"><input id="name" name="userName" placeholder="请输入用户名" > </td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">邮箱</td>
				<td  class="registerTableRightTD"><input id="email" name="email" placeholder="请输入邮箱" > </td>
			</tr>
			<tr>
				<td  class="registerTip registerTableLeftTD">设置登陆密码</td>
				<td  class="registerTableRightTD">登陆时验证，保护账号信息</td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">登陆密码</td>
				<td class="registerTableRightTD"><input id="password" name="pwd" type="password"  placeholder="设置你的登陆密码" > </td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">密码确认</td>
				<td class="registerTableRightTD"><input id="repeatpassword" type="password"   placeholder="请再次输入你的密码" > </td>
			</tr>
			<tr>
				<td  class="registerTip registerTableLeftTD">邮箱验证码</td>
			</tr>
			<tr>
				<td align="right">
					<a id="sendCaptcha" class="btn btn-default">获取验证码</a>
				</td>
				<td class="registerTableRightTD">
					<input id="captcha" name="captcha" type="text" placeholder="请输入验证码" >
				</td>
			</tr>
			<tr>
				<td colspan="2" class="registerButtonTD">
					<a href="loginUI"><button>提   交</button></a>
				</td>
			</tr>
		</table>
	</div>
</form>