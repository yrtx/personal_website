<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/fore/foreHead.jsp"%>
<script>
    var InterValObj; //timer变量，控制时间
    var count = 60; //间隔函数，1秒执行
    var curCount;//当前剩余秒数
    var regEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
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
            if(!regEmail.test($("#email").val())) {
                $("span.errorMessage").html("邮箱格式不正确");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            sendMessage();
            //向后台发送处理数据
            var email = $("#email").val();
            $.ajax({
                // type:"POST", //用POST方式传输
                // dataType:"json", //数据格式:JSON
                url:"${pageContext.request.contextPath}/fore/sendCaptcha",
                data:{"email":email},
                success:function(){
					alert("发送成功");
                    //使用完输出流以后调用
                    out.clear();
                    out = pageContext.pushBody();
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    if(errorThrown != null && !errorThrown.empty()) {
                        alert("发送错误请联系技术人员" + errorThrown);
                    }
                }
            });
            return true;
        });

        $(".registerForm").submit(function(){
            var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;

            if(0==$("#name").val().length){
                $("span.errorMessage").html("请输入用户名");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(!regName.test($("#name").val())) {
                $("span.errorMessage").html("用户名格式错误");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
			}
            if(0==$("#email").val().length){
                $("span.errorMessage").html("请输入邮箱");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(!regEmail.test($("#email").val())) {
                $("span.errorMessage").html("邮箱格式不正确");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
			}
            if(0==$("#captcha").val().length){
                $("span.errorMessage").html("请输入验证码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#password").val().length){
                $("span.errorMessage").html("请输入密码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if($("#password").val().length > 20) {
                $("span.errorMessage").html("密码长度不得超过20个字符");
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
    function sendMessage() {
        curCount = count;
        //设置button效果，开始计时
        $("#sendCaptcha").attr("disabled", "true");
        $("#sendCaptcha").val("请在" + curCount + "秒内输入验证码");
        InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
    }
    function SetRemainTime() {
        if (curCount == 0) {
            window.clearInterval(InterValObj);//停止计时器
            $("#sendCaptcha").removeAttr("disabled");//启用按钮
            $("#sendCaptcha").val("发送验证码");
        }
        else {
            curCount--;
            $("#sendCaptcha").val("请在" + curCount + "秒内输入验证码");
        }
    }
</script>

<form method="post" action="${pageContext.request.contextPath}/fore/register" class="registerForm">
	<div class="registerDiv">
		<div class="registerErrorMessageDiv">
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
				<span class="errorMessage"></span>
			</div>
		</div>
		<table class="registerTable" align="center">
			<tr>
				<td class="registerTip registerTableLeftTD">设置用户名/邮箱</td>
				<td class="registerTableRightTD">用户名可以是2-5位中文或者6-16位英文和数字的组合</td>
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
				<td  class="registerTableRightTD">密码长度不得超过20个字符</td>
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
					<input type="button" value="发送验证码" id="sendCaptcha" class="btn btn-default" />
				</td>
				<td class="registerTableRightTD">
					<input id="captcha" name="captcha" type="text" placeholder="请输入验证码" >
				</td>
			</tr>
			<tr>
				<td colspan="2" class="registerButtonTD">
					<a href="${pageContext.request.contextPath}/fore/loginUI"><button>提   交</button></a>
				</td>
			</tr>
		</table>
	</div>
</form>