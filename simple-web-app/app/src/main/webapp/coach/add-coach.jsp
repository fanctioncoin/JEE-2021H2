<%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 07.10.2021
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<%@include file="/fragment/header.jsp"%>
<h1 align="center">
    This is page for adding the coach!
</h1>
<form action = "user-coach" method="post">
    <input required type="text" name="login" placeholder="Логин">
    <input required type="text" name="password" placeholder="Пароль">
    <input required type="text" name="name" placeholder="Имя">
    <input required type="text" name="age" placeholder="Возраст">
    <input required type="text" name="salary" placeholder="Зарплата">
    <input type="submit" value="Сохранить">
</form>
</body>
</html>
