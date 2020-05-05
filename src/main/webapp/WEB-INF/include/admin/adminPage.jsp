<%--
  Created by IntelliJ IDEA.
  User: AIS
  Date: 2019/8/25
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 提示分页信息行 -->
<div class="row">
    <!-- 分页文字信息 ：拿到控制器处理请求时封装在pageInfo里面的分页信息-->
    <div class="col-md-6">
        当前${pageInfo.pageNum}页,共${pageInfo.pages }页,总${pageInfo.total }条记录
    </div>
    <!-- 分页码 -->
    <div class="col-md-6">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <!--
                            1.pageContext.request.contextPath表示当前项目路径，采用的是绝对路径表达方式。一般为http:localhost:8080/项目名 。
                            2.首页，末页的逻辑：pn=1访问第一次，pn=${pageInfo.pages}访问最后一页
                -->
                <li>
                    <a href="?pageNum=1${other}">首页</a>
                </li>
                <!-- 如果还有前页就访问当前页码-1的页面， -->
                <c:if test="${pageInfo.hasPreviousPage}">
                    <li>
                        <a href="?pageNum=${pageInfo.pageNum-1}${other}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <li>
                    <!--遍历所有导航页码，如果遍历的页码页当前页码相等就高亮显示，如果不相等就普通显示  -->

                    <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                        <c:if test="${num==pageInfo.pageNum }">
                            <li class="active"><a href="#">${num}</a></li>
                        </c:if>
                        <c:if test="${num!=pageInfo.pageNum }">
                            <li><a href="?pageNum=${num}${other}">${num}</a></li>
                        </c:if>
                    </c:forEach>

                </li>
                <!-- 如果还有后页就访问当前页码+1的页面， -->
                <c:if test="${pageInfo.hasNextPage}">
                    <li>
                        <a href="?pageNum=${pageInfo.pageNum+1}${other}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="?pageNum=${pageInfo.pages}${other}">末页</a></li>
            </ul>
        </nav>
    </div>
</div>

