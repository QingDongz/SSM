<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/5
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="${ctx}/xinhuameiyu">
    用户名：<input type="text" name="username"/><br/>
    真实姓名：<input type="text" name="name"/><br/>
    客户端：PC:<input type="radio" checked="checked" name="client" value="pc" />
    H5:<input type="radio" name="client" value="weixin" /><br/>
    手机号：<input type="text" name="mobile"/><br/>
    <input type="submit" value="生成网址"/><br/>
</form>
测试网址：<a href="${token}">跳转地址</a><br/>
真实地址：${token}<br/>
用户名：${username}<br/>
真实姓名：${name}<br/>
手机号：${mobile}<br/>
客户端：${client}<br/>
<br/><br/>
注：若缺少用户名，则按客户端进行跳转至引导注册页面

</body>
</html>
