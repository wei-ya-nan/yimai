<%@ page import="com.easybuy.service.impl.ProductCategoryServiceImpl" %>
<%@ page import="com.easybuy.entity.ProductCategory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.easybuy.service.ProductCategoryService" %>
<%@ page import="com.sun.xml.internal.ws.client.RequestContext" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=utf-8"/>
    <title>易买网 - 首页</title>
    <%@include file="/pages/common/header.jsp" %>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="static/images/logo.gif"/></div>
   <%@include file="/pages/common/index_login.jsp"%>
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
</div>
<div id="childNav">
    <div class="wrap">
        <ul class="clearfix">


            <li class="first"><a href="#">音乐</a></li>
            <li><a href="#">影视</a></li>
            <li><a href="#">少儿</a></li>
            <li><a href="#">动漫</a></li>
            <li><a href="#">小说</a></li>
            <li><a href="#">外语</a></li>
            <li><a href="#">数码相机</a></li>
            <li><a href="#">笔记本</a></li>
            <li><a href="#">羽绒服</a></li>
            <li><a href="#">秋冬靴</a></li>
            <li><a href="#">运动鞋</a></li>
            <li><a href="#">美容护肤</a></li>
            <li><a href="#">家纺用品</a></li>
            <li><a href="#">婴幼奶粉</a></li>
            <li><a href="#">饰品</a></li>
            <li class="last"><a href="#">Investor Relations</a></li>
        </ul>
    </div>
</div>
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
<div id="main" class="wrap">
    <div class="lefter">
        <div class="box">
            <h2>商品分类</h2>
            <dl>

                  <c:forEach items="${requestScope.all}" var="all">
                    <c:if test="${all.epcID == all.parentId}">
                       <c:set var="id" value="${all.parentId}"></c:set>
                       <dt><a id="cate_parent" href="#">${all.epcName}</a></dt>
                    <c:forEach items="${requestScope.all}" var="childAll">
                    <c:if test="${childAll.parentId == id && childAll.epcID !=id}">
                       <dd><a href="client/goodsServlet?action=page&epcID=${childAll.epcID}">${childAll.epcName}</a></dd>

                    </c:if>

                    </c:forEach>
                    </c:if>

                    </c:forEach>



        </div>
        <div class="spacer"></div>
        <div class="last-view">
            <h2>最近浏览</h2>
            <dl class="clearfix">
                    <dt><img  style="height: 20px;width: 20px"
                              src="static/images/product/${cookie.get("productImg")}"/></dt>
                    <dd><a href="client/goodsServlet?action=productView&prodId=${cookie.get("id").value}">
                            ${cookie.get("productName").value}</a></dd>


            </dl>
            <%--            <script type="text/javascript">--%>
            <%--                document.write("Cookie中记录的购物车商品ID：" + getCookie("product") + "，可以在动态页面中进行读取");--%>
            <%--            </script>--%>
        </div>
    </div>
    <div class="main">
        <div class="product-list">
            <h2>全部商品</h2>

            <div class="clear"></div>
            <ul class="product clearfix">
                <c:forEach items="${requestScope.page.items}" var="goods">
                    <li>
                        <dl>
                            <dt><a href="client/goodsServlet?action=productView&prodId=${goods.id}"
                                   target="_blank"><img
                                    src="static/images/product/${goods.fileName}"/></a></dt>
                            <dd class="title"><a href="client/goodsServlet?action=productView&prodId=${goods.id}" target="_blank">${goods.name}</a></dd>
                            <dd class="price">${goods.price}</dd>
                        </dl>
                    </li>
                </c:forEach>


            </ul>
            <div class="clear"></div>
            <%@include file="/pages/common/page_nav.jsp" %>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
<script type="text/javascript">





</script>
</body>
</html>
