<%--
  Created by IntelliJ IDEA.
  User: soyon
  Date: 2022/2/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="box">
    <dl>
        <dt>用户管理</dt>
        <dd><em><a href="pages/manage/user-add.jsp">新增</a></em><a href="manage/user?action=userPage">用户管理</a></dd>
        <dt>商品信息</dt>
        <dd><em><a href="manage/user?action=addClass">新增</a></em><a href="manage/user?action=productClass">分类管理
        </a></dd>
        <dd><em><a href="manage/user?action=addProduct">新增</a></em><a href="manage/user?action=product">商品管理
        </a></dd>
        <dt>订单管理</dt>
        <dd><a href="manage/order?action=order">订单管理</a></dd>
        <dt>留言管理</dt>
        <dd><a href="manage/order?action=comment">留言管理</a></dd>
        <dt>新闻管理</dt>
        <dd><em><a href="pages/manage/news-add.jsp">新增</a></em><a href="manage/order?action=news">新闻管理</a></dd>
    </dl>
</div>