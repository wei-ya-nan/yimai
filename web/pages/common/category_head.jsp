<%--
  Created by IntelliJ IDEA.
  User: soyon
  Date: 2022/2/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar">
    <ul class="clearfix" id="header_ul">
        <li id="header_first" ${empty requestScope.chileId ? "class='current'" :""}><a href="#">首页</a></li>

        <c:forEach items="${requestScope.parent}" var="parentAll">
            <li  id="header_list"  ${parentAll.parentId == requestScope.chileId?
                    "class='current'" :""}>
                <a id="header_list_href"
                   href="client/goodsServlet?action=page&childId=${parentAll.parentId}">
                        ${parentAll.epcName}
                </a>
            </li>
        </c:forEach>

    </ul>
</div>