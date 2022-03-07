<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<li class="current"><a href="manage/user?action=product">商品</a></li>
			<li><a href="manage/order?action=order">订单</a></li>
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
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>

				<c:forEach items="${requestScope.all}" var="all">

					<c:if test="${all.epcID == all.parentId}">
						<tr>
						<c:set var="id" value="${all.parentId}"></c:set>
						<td class="first w4 c">${all.parentId}</td>
						<td>${all.epcName}</td>
						<td class="w1 c"><a href="manage/user?action=parentCategory&id=${all.epcID}">修改</a>
							<a class="delete_category" href="manage/user?action=deleteCategory&id=${all.epcID}"
							   categoryId="${all.epcID}">删除</a></td>
						</tr>
						<c:forEach items="${requestScope.all}" var="childAll">
							<tr>
							<c:if test="${childAll.parentId == id && childAll.epcID !=id}">
								<td class="first w4 c">${childAll.epcID}</td>
								<td class="childClass">${childAll.epcName}</td>
								<td class="w1 c"><a href="manage/user?action=parentCategory&id=${childAll.epcID}">修改</a>
									<a class="delete_category"
									   href="manage/user?action=deleteCategory&id=${childAll.epcID}"
									   categoryId="${childAll.epcID}">删除</a></td>
							</c:if>
							</tr>
						</c:forEach>
					</c:if>
				</c:forEach>
			</table>
		</div>
		</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
<script type="text/javascript">
	$(function () {
		$("a.delete_category").click(function () {
			return confirm("是否删除");
		})
	});
</script>
</body>
</html>
