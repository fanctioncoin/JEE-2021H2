<%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 08.10.2021
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete coach</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp"%>
<br>
Вы действительно  хотите удалить пользователя ${param.id}?

<form action="student" method="post">
<input type="hidden" name="id" value="${param.id}">
<input type="hidden" name="method" value="delete">
<input type="submit" value="Удалить">
</form>
</body>
</html>
