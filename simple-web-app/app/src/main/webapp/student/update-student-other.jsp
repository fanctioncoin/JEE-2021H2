<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 11.10.2021
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Student</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp" %>

<h3 align="center">
    Редактировать студента ${param.name}
</h3>
<table border="2">
    <tr>
        <% List<String> disciplines = (List<String>) session.getAttribute("disciplines");%>
        <%for(String s: disciplines) { %>
        <td><%=s%></td>
        <%} %>
    </tr>
    <tr>
        <form action="student" method="post">
            <input type="hidden" name="method" value="update">
            <input type="hidden" name="id" value="${param.id}">
            <input type="hidden" name="name" value="${param.name}">
            <input type="hidden" name="age" value="${param.age}">
            <input type="hidden" name="name_band" value="${param.group}">
            <td><input type="text" name="marks1" value="${param.marks1}" placeholder=${param.marks1}></td>
            <td><input type="text" name="marks2" value="${param.marks2}" placeholder=${param.marks2}></td>
            <td><input type="text" name="marks3" value="${param.marks3}" placeholder=${param.marks3}></td>
            <td><input type="text" name="marks4" value="${param.marks4}" placeholder=${param.marks4}></td>
            <td><input type="submit" value="Сохранить"></td>
        </form>
    </tr>
</table>
</body>
</html>
