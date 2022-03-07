<%--
  Created by IntelliJ IDEA.
  User: soyon
  Date: 2022/2/19
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--写base标签，永远固定相对路径跳转的结果-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网 - 首页</title>
    <%

        String basePath = request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + "/";
        pageContext.setAttribute("basePath", basePath);
    %>
    <!--写base标签，永远固定相对路径跳转的结果-->
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="static/css/style.css" />
    <script type="text/javascript" src="static/scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="static/images/logo.gif" /></div>

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
<div id="main" class="wrap">
    <div class="lefter">
        <%@include file="/pages/common/category.jsp" %>
        <div class="spacer"></div>
        <div class="last-view">
            <h2>最近浏览</h2>
            <dl class="clearfix">
                <dt><img src="static/images/product/0_tiny.gif" /></dt>
                <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
                <dt><img src="static/images/product/0_tiny.gif" /></dt>
                <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
            </dl>
        </div>
    </div>
    <div class="main">
        <div class="price-off">
            <h2>今日特价</h2>
            <ul class="product clearfix">
                <c:forEach items="${requestScope.page.items}" var="pages">
                    <li>
                        <dl>
                            <dt><a href="client/goodsServlet?action=productView&prodId=${pages.id}"
                                target="_blank"><img src="static/images/product/${pages.fileName}" /></a></dt>
                            <dd class="title"><a href="product-view.jsp" target="_blank">${pages.name}</a></dd>
                            <dd class="price">${pages.price}</dd>
                        </dl>
                    </li>


                </c:forEach>

            </ul>
        </div>
        <div class="side">
            <div class="news-list">
                <h4>最新公告</h4>
                <ul>
                    <li><a href="/pages/client/news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                </ul>
            </div>
            <div class="spacer"></div>
            <div class="news-list">
                <h4>新闻动态</h4>
                <ul>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                    <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                </ul>
            </div>
        </div>
        <div class="spacer clear"></div>
        <div class="hot">
            <h2>热卖推荐</h2>
            <ul class="product clearfix">
                <c:forEach items="${requestScope.page.items}" var="pages">
                    <li>
                        <dl>
                            <dt><a href="client/goodsServlet?action=productView&prodId=${pages.id}"
                                   target="_blank"><img src="static/images/product/${pages.fileName}" /></a></dt>
                            <dd class="title"><a href="product-view.jsp" target="_blank">${pages.name}</a></dd>
                            <dd class="price">${pages.price}</dd>
                        </dl>
                    </li>


                </c:forEach>

            </ul>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

