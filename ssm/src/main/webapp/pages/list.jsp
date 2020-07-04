<%--
  Created by IntelliJ IDEA.
  User: 小马林
  Date: 2020/7/4
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach var="item" items="${accounts}">
    <ul style="list-style: none">
        <li>账户名:${item.name}</li>
        <li>金额:${item.money}</li>
    </ul>
</c:forEach>






</body>
</html>
