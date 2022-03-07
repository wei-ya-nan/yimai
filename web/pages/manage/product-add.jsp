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
		<h2>添加商品</h2>
		<div class="manage">
			<form action="manage/user?action=addProductCommit" method="post" enctype="multipart/form-data">

				<table class="form">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="productName" value="" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId">
								<c:forEach items="${requestScope.categorys}" var="items">
									<option value="${items.epcID}">${items.epcName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" /></td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="productPrice" /> 元</td>
					</tr>
					<tr>
						<td class="field">详情：</td>
						<td><input type="text" class="text" name="description" /></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="stock" /></td>
					</tr>
					<tr>
						<td class="field">条码号：</td>
						<td><input type="text" class="text" name="code" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
