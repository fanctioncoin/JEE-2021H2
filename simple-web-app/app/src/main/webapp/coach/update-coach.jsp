<%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 07.10.2021
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update  coach</title>
  <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp"%>

<h3 align="center">
  Редактировать пользователя
</h3>

<form action="user-coach" method="post">
  <input type="hidden" name = "id" value="${param.id}">
  <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
  <input type="text" name="age" value="${param.age}" placeholder=${param.age}>
  <input type="text" name="salary" value="${param.salary}" placeholder=${param.salary}>
  <input type="hidden" name="_method" value="put">
  <input type="submit" value="Обновить">
</form>
</body>
</html>
