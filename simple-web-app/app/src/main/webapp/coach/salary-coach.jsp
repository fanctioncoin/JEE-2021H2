<%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 08.10.2021
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Salary coach</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp"%>
<h1 align="center">
    This is page  the  average salary coach!
</h1>
<h4>
    Средняя зарплата  тренеров:

    ${salary}
</h4>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
        <td>Salary</td>
    </tr>
    <c:forEach items="${listCoaches}" var = "coach">
        <tr>
            <td>${coach.getId()}</td>
            <td>${coach.getName()}</td>
            <td>${coach.getAge()}</td>
            <td>${coach.getSalary()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
