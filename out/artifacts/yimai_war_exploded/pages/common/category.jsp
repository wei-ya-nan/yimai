<%--
  Created by IntelliJ IDEA.
  User: soyon
  Date: 2022/2/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="box">
    <h2>商品分类</h2>
    <dl>
        <c:forEach items="${requestScope.all}" var="all">
        <c:if test="${all.epcID == all.parentId}">
            <c:set var="id" value="${all.parentId}"></c:set>
        <dt><a id="cate_parent" href="#">${all.epcName}</a></dt>
        <c:forEach items="${requestScope.all}" var="childAll">
        <c:if test="${childAll.parentId == id && childAll.epcID !=id}">
        <dd><a href="client/goodsServlet?action=page&epcID=${childAll.epcID}">${childAll.epcName}</a>
        </dd>
        </c:if>
        </c:forEach>
        </c:if>

        </c:forEach>



</div>