<%--
  Created by IntelliJ IDEA.
  User: 小马林
  Date: 2020/7/4
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Welcome</h2>
    <h3>生成一个账户</h3>
    <form action="/save" method="post">
        <input type="text" name="name" placeholder="账户"><br>
        <input type="text" name="money" placeholder="金额 ">
        <input type="submit" value="保存">
    </form>
    <br>
    <h3>更新金额</h3>
    <form action="/update" method="post">
        <input type="text" name="name" placeholder="账户"><br>
        <input type="text" name="money" placeholder="金额 ">
        <input type="submit" value="更新">
    </form>
    <br>
    <h3>删除一个账户</h3>
    <form action="/del" method="get">
        <input type="text" name="id" placeholder="账户id">
        <input type="submit" value="删除">
    </form>
    <br>
    <h3>查询一个账户</h3>
    <form action="/find" method="get">
        <input type="text" name="id" placeholder="账户id">
        <input type="submit" value="查询">
    </form>
    <br>
    <h3>查看所有账户信息</h3>
    <a href="/list">点击查看</a>

    <h3>异常测试</h3>
    <a href="/5xx">服务器端异常5xx</a><br>
    <a href="/4xx">客户端异常4xx</a>


</body>
</html>
