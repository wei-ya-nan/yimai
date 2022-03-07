<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=utf-8"/>
    <title>易买网 - 商品详情</title>
    <%@include file="/pages/common/header.jsp" %>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="static/images/logo.gif"/></div>
    <%@include file="/pages/common/index_login.jsp"%>
    <%@include file="/pages/common/category_head.jsp" %>
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
<%@include file="/pages/common/position.jsp" %>
<div id="main" class="wrap">
    <div class="lefter">
        <%@include file="/pages/common/category.jsp" %>
    </div>
    <div id="product" class="main">
        <h1>${requestScope.productOne.name}</h1>
        <div class="infos">
            <div
                    class="thumb"><img src="static/images/product/${requestScope.productOne.fileName}"
                                       style="width:300px ;height: 300px"></div>
            <div class="buy">
                <p>商城价：<span class="price">${requestScope.productOne.price}</span></p>
                <p>库　存：有货</p>
                <p>库　存：有货</p>
                <p>库　存：有货</p>
                <p>库　存：有货</p>
                <div class="button"><input type="button" name="button" value=""  onclick="goBuy(1)"/>
                    <a productOneId="${requestScope.productOne.id}" id="addToCart"
                       href="client/cart?action=addItem&productOneId=${requestScope.productOne.id}">放入购物车
                    </a>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="introduce">
            <h2><strong>商品详情</strong></h2>
            <div class="text">
                ${requestScope.productOne.description}<br/>

            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
<script type="text/javascript">
    // $(function () {
    //     $("#addToCart").click(function () {
    //         var productOneId = $(this).attr("productOneId");
    //
    //         $.getJSON("http://localhost:8080/buy/client/goodsServlet","action=addAjaxItemToCart&productOneId="
    //             + productOneId, function
    //             (data) {
    //             alert("成功将" + data.lastName.toString()+"加入购物车,亲！！！");
    //         })
    //     });
    // });

</script>
</body>
</html>
