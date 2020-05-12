<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../include/fore/foreHead.jsp"%>
<script>
    $(function(){
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility","visible");
        </c:if>

        $(".registerForm").submit(function(){
            if(0==$("#fileName").val().length){
                $("span.errorMessage").html("请输入文件名");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#file").val().length){
                $("span.errorMessage").html("请选择文件所属分类");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            alert("文件正在上传，请稍后。" +
				"注意：如果文件体积较大上传时间可能也会相对缓慢");
            return true;
        });


    })
</script>



<form method="post" action="${pageContext.request.contextPath}/fore/uploadFile?usersId=${loginUser.id}" class="registerForm" enctype="multipart/form-data">
	<div class="registerDiv">
		<div class="registerErrorMessageDiv">
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
				<span class="errorMessage"></span>
			</div>
		</div>
		<table class="registerTable" align="center">
			<tr>
				<td  class="registerTip registerTableLeftTD">设置文件名和分类名</td>
				<td></td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">文件名</td>
				<td  class="registerTableRightTD"><input id="fileName" name="fileName" placeholder="请输入文件名" > </td>
			</tr>
			<c:forEach items="${categories}" var="category">
				<tr>
					<td class="registerTableLeftTD">${category.categoryName}</td>
					<td  class="registerTableRightTD"><input type="radio" name="categoryId" value="${category.id}"> </td>
				</tr>
			</c:forEach>
			<tr>
				<td  class="registerTip registerTableLeftTD">上传文件</td>
				<td  class="registerTableRightTD">注意文件大小</td>
			</tr>
			<tr>
				<td class="registerTableLeftTD">选择文件</td>
				<td class="registerTableRightTD"><input id="file" name="upFile" type="file"> </td>
			</tr>

			<tr>
				<td colspan="2" class="registerButtonTD">
					<button>提   交</button>
				</td>
			</tr>
		</table>
	</div>
</form>