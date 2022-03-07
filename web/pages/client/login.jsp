<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>易买网 - 首页</title>
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
	<div class="help">
		<c:if test="${empty sessionScope.user}" >

			<a href="pages/client/login.jsp">登录</a>
			<a href="pages/client/register.jsp">注册</a>
			<a href="guestbook.jsp">留言</a>
		</c:if>
		<c:if test="${not empty sessionScope.user}">
			<a href="#" class="shopping">购物车</a>
			<a href="index.jsp">退出</a>

		</c:if>
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
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
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到易买网</h1>
			<form id="loginForm" method="post" action="user" onsubmit="return checkForm(this)">
				<input type="hidden" name="action" value="login">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="userName" placeholder="请输入用户名"
								   onfocus="FocusItem(this)"
								   onblur="CheckItem(this);" value="${requestScope.username}"/><span></span><div
								style="color:
								   red">${ empty
								   requestScope.msg ? "":requestScope.msg }</div></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" placeholder="请输入密码"
								   onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input class="text verycode" type="text" name="veryCode" onfocus="FocusItem(this)"
								   onblur="CheckItem(this);" /><img id="veryCode" src="kaptcha.jpg" /><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="立即登录" /></label></td>
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
<script type="text/javascript">
	var code = document.getElementById("veryCode");
	code.onclick=function () {
		this.src = "${basePath}kaptcha.jpg?d=" + new Date();
	}
</script>
</html>
