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
    <%@include file="/pages/common/index_login.jsp" %>
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
<div id="position" class="wrap">
    您现在的位置：<a href="pages/client/index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
    <div id="shopping">
        <form action="manage/order?action=shopping" method="post">
            <table>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>购买数量</th>
                    <th>操作</th>
                </tr>
                <tr id="product_id_1">
                    <c:if test="${ empty sessionScope.cart.itemsMap}">
                        <td style="font-size: large">购物车还没有商品,快去浏览宝贝吧</td>
                    </c:if>

                    <c:if test="${not empty sessionScope.cart}">
                    <c:forEach items="${sessionScope.cart.itemsMap}" var="entry">
                    <td class="thumb"><img src="static/images/product/${entry.value.fileName}"
                                           style="height: 50px;width: 50px"/>
                        <a href="product-view.jsp">
                                ${entry.value.name}</a></td>
                    <td class="price" id="price_id_1">
                        <span>${entry.value.price}</span>
                            <%--                        <input type="hidden" value="99"/>--%>
                    </td>
                    <td class="number">
                        <dl>
                            <dt><input id="number_id_"+${entry.value.id} type="text" name="number"
                                       productOnId="${entry.value.id}" value="${entry.value.count}"/></dt>
                        </dl>
                    </td>
                    <td class="delete"><a href="client/cart?action=deleteCartById&productOneId=${entry.value.id}">删除</a>
                    </td>
                </tr>
                </c:forEach>
                </c:if>

            </table>
            <c:if test="${not empty sessionScope.cart.itemsMap}">
                <div id="cart_totalCount">您的购物车中共有${sessionScope.cart.cartTotalCount}件商品</div>
            </c:if>
            <div class="button"><input type="submit" value=""/></div>
        </form>
    </div>
    <%--	<script type="text/javascript">--%>
    <%--		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");--%>
    <%--	</script>--%>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
<script type="text/javascript">
    $(function () {
        $("input[type='text']").change(function () {
            var attr = $(this).attr("productOnId");
            var number = this.value;
            alert(attr);
            $.getJSON("http://localhost:8080/buy/client/cart", "action=updateAjaxCount&productOneId=" + attr + "&number=" + number, function (data) {
                $(this).text(data.itemsMap.count);
                $("#cart_totalCount").text("您的购物车有" + data.cartTotalCount + "件商品")
            });
        });
        $("td.delete").click(function () {
            return confirm("您确定删除" +
                $(this).parent().parent().children().find("td:first").children().find("a:last").text() + "吗，亲")
        })

    });

</script>
</body>
</html>
