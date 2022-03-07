
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=utf-8"/>
<title>后台管理 - 易买网</title>
	<%
		String basePath = request.getScheme()
				+ "://"
				+ request.getServerName()
				+ ":"
				+ request.getServerPort()
				+ request.getContextPath()
				+ "/";

		pageContext.setAttribute("basePath",basePath);
	%>

	<!--写base标签，永远固定相对路径跳转的结果-->
	<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" />
<script type="text/javascript" src="static/scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="static/images/logo.gif" /></div>
	<div class="help"><a href="client/goodsServlet?action=page">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="pages/manage/index.jsp">首页</a></li>
			<li class="current"><a href="manage/user?action=userPage">用户</a></li>
			<li><a href="manage/user?action=product">商品</a></li>
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
		<h2>新增用户</h2>
		<div class="manage">
			<form action="manage/user?action=addUser" method="post">
				<table class="form">
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="userName" value="" /></td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text" class="text" name="name" value="" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="password" value="" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="sex" value="男" checked="checked" />男 <input type="radio"
																								  name="sex"
																								  value="女" />女</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<input type="date" name="birthDay">

						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="mobile" value="" /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="address" value="" /></td>
					</tr>
					<tr>
						<td class="field">头像：</td>
						<td><input type="file" class="text" name="photo" /></td>
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
