<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navitagorDiv">
	<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<a class="navbar-brand" href="admin_main">我的后台</a>
		
		<a class="navbar-brand" href="admin_list_category">分类管理</a>
		<a class="navbar-brand" href="admin_list_webFile">文件管理</a>
		<a class="navbar-brand" href="admin_list_user">用户管理</a>
		<c:if test="${adminLoginUser != null}">
			<span style="float: right">
				<a href="#" class="btn btn-link">您好,${adminLoginUser.userName}</a>
				<a href="admin_logout" class="btn btn-link">退出</a>
			</span>
		</c:if>
	</nav>
</div>