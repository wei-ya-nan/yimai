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
	<div id="logo"><img src="static/images/logo.gif" /></div>
	<%@include file="/pages/common/index_login.jsp"%>
	
</div>
<div id="childNav">
	<%@include file="/pages/common/category_head.jsp"%>
</div>
<%@include file="/pages/common/position.jsp"%>
<div id="main" class="wrap">
	<div class="lefter">
		<%@include file="/pages/common/category.jsp"%>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			
			<ul>

				<c:forEach items="${requestScope.page.items}" var="pages">
					<li>
						<dl>
							<dt>${pages.content}</dt>
							<dd class="author">网友：${pages.name} <span class="timer">${pages.createDate}</span></dd>
							<dd>${pages.replay}</dd>
						</dl>
					</li>
				</c:forEach>
				
				
			</ul>
			<div class="clear"></div>
			<%@include file="/pages/common/page_nav.jsp"%>
			<div id="reply-box">
				<form method="post" action="manage/order?action=commitGustBook">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="guestName" /></td>
						</tr>

						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
