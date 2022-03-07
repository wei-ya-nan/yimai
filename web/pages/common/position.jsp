<%--
  Created by IntelliJ IDEA.
  User: soyon
  Date: 2022/2/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="position" class="wrap">
    您现在的位置：<a href="index.jsp">易买网</a>
    <c:forEach items="${requestScope.all}" var="all2">
    <c:if test="${empty requestScope.chileId}">
    <c:if test="${all2.epcID == requestScope.epcId }">
    &gt; <a href="product-list.jsp">${all2.epcName}
    </c:if>
    <c:if test="${ not empty requestScope.chileId && all2.parentId == requestScope.chileId}">
    &gt;${all2.epcName}
    </c:if>
    </c:if>
    </c:forEach>

</div>