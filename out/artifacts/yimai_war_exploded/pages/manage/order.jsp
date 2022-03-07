<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8"/>
	<title>后台管理 - 易买网</title>
	<%@include file="/pages/common/manage_header.jsp" %>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="static/images/logo.gif" /></div>
	<div class="help"><a href="client/goodsServlet?action=page">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="pages/manage/index.jsp">首页</a></li>
			<li><a href="manage/user?action=userPage">用户</a></li>
			<li><a href="manage/user?action=product">商品</a></li>
			<li class="current"><a href="manage/order?action=order">订单</a></li>
			<li><a href="manage/order?action=comment">留言</a></li>
			<li><a href="manage/order?action=news">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<%@include file="/pages/common/manage_left.jsp"%>
	</div>
	<div class="main">
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form method="post" action="manage/order?action=query">
					订单号：<input type="text" class="text" name="orderId" id="orderId"/>
					订货人：<input type="text" class="text" name="userName" id="orderName"/>
					<label class="ui-blue">
						<input type="submit" name="submit" value="查询" id="query"/>
					</label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:if test="${not empty requestScope.queryOne}">
					<tr>
						<td class="first w4 c">${requestScope.queryOne.id}</td>
						<td class="w1 c">${requestScope.queryOne.userName}</td>
						<td>${requestScope.queryOne.address}</td>
						<td class="w1 c">${requestScope.queryOne.status ==1 ? "发货":"待审核"}</td>
						<td class="w1 c"><a href="manage/order?action=orderModify&id=${requestScope.queryOne.id}">修改</a>
							<a class="delete_order" href="manage/order?action=deleteOrder&id=${requestScope.queryOne.id}">删除
							</a></td>
					</tr>
				</c:if>
				<c:forEach items="${requestScope.page.items}" var="orders">
					<tr>
						<td class="first w4 c">${orders.id}</td>
						<td class="w1 c">${orders.userName}</td>
						<td>${orders.address}</td>
						<td class="w1 c">${orders.status ==1 ? "发货":"待审核"}</td>
						<td class="w1 c"><a href="manage/order?action=orderModify&id=${orders.id}">修改</a>
							<a class="delete_order" href="manage/order?action=deleteOrder&id=${orders.id}">删除
							</a></td>
					</tr>
				</c:forEach>

			</table>
			<%@include file="/pages/common/page_nav.jsp"%>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
<script type="text/javascript">
	$(function () {
		$("a.delete_order").click(function () {
				return confirm("是否删除");
		});
		$("#query").click(function () {
			if($("#orderId").val() == null || $("#orderId").val() == "" || $("#orderName").val() == ""){
				alert("请输入订单号或订货人");
				return false;
			}
		})
	})

</script>
</body>
</html>
