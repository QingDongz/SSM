<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/15
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<json:object>
    <json:property name="total" value="${total}"/>
    <json:property name="code" value="${code}"/>
    <json:property name="message" value="${message}"/>
    <json:array name="userList">
        <c:forEach items="${userList}" var="user">
            <json:object>
                <json:property name="id" value="${user.id}"/>
                <json:property name="username" value="${user.username}"/>
                <json:property name="password" value="${user.password}"/>
            </json:object>
        </c:forEach>
    </json:array>

</json:object>
