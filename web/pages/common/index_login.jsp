<%--
  Created by IntelliJ IDEA.
  User: soyon
  Date: 2022/2/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="help">
    <c:if test="${empty sessionScope.user}">

        <a href="pages/client/login.jsp">登录</a>
        <a href="pages/client/register.jsp">注册</a>
    </c:if>
    <c:if test="${not empty sessionScope.user}">
        <a href="user?action=logOut">退出</a>
        <a href="pages/client/shopping.jsp" class="shopping">购物车</a>
        <a href="manage/order?action=guestBook">留言</a>

    </c:if>
</div>