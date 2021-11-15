<%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 04.10.2021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List coaches</title>
</head>
<body>
<%@include file="/fragment/header.jsp"%>
<h3 align="center"> List coaches!</h3>
<h4>
    Средняя  зарплата тренеров:

${salary}
</h4>
<table border="2">
    <tr>
        <td>ID</td>
        <td>login </td>
        <td>password</td>
        <td>role </td>
        <td>Name</td>
        <td>Age</td>
        <td>Salary</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${listCoaches}" var = "coach">
        <tr>
            <td>${coach.getId()}</td>
            <td>${coach.getCredUser().getLogin()} </td>
            <td>${coach.getCredUser().getPassword()} </td>
            <td>${coach.getCredUser().getRole()} </td>
            <td>${coach.getName()}</td>
            <td>${coach.getAge()}</td>
            <td>${coach.getSalary()}</td>
            <td>
                <form action = "update-coach" method="post">
                    <input type="hidden" name="id" value="${coach.getId()}">
                    <input type="hidden" name="name" value="${coach.getName()}">
                    <input type="hidden" name="age" value="${coach.getAge()}">
                    <input type="hidden" name="salary" value="${coach.getSalary()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="${pageContext.request.contextPath}/delete-coach" method="post">
                    <input type="hidden" name="id" value="${coach.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>
<br>
<form action = "${pageContext.request.contextPath}/add-coach">
    <input type="submit" value="Добавить нового пользователя">
</form>
</body>
</html>
