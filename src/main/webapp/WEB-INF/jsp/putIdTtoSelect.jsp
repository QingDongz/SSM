<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/5
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择ID查询用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user" method="get">
    <input type="text" name="str"/><br/>
    <input type="submit" name="提交"/>
</form>
</body>
</html>
