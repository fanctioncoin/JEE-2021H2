
<%@ page import="by.academy.web.model.Person" %>
<%@ page import="by.academy.web.model.Student" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 08.10.2021
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Students</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h1 align="center">
    This is page for Lists students band ${param.name_band}!
</h1>
<table border="2">
    <tr>
        <td><b>ID</b></td>
        <td><b>Name</b></td>
        <td><b>Age</b></td>
        <td><b>Band</b></td>
        <td><b>Coach</b></td>
        <c:forEach items="${students.get(0).band.disciplines}" var = "dis">
            <td><b><c:out value="${dis}"/></b></td>
        </c:forEach>

    </tr>
        <tr>
        <c:forEach items="${students}" var="student" >
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getAge()}</td>
            <td>${student.band.name}</td>
            <td>${student.band.coach.name}</td>
            <c:forEach items="${student.getMarks()}" var = "marks">
                <td><c:out value="${marks}"/></td>
            </c:forEach>
            <td>
                <form action="update-student" method="post">
                    <input type="hidden" name="id" value="${student.getId()}">
                    <input type="hidden" name="name" value="${student.name}">

<%--                Пришлось чутка кода в jsp написать, чтобы у студентов  и у других тренеров не было записи "ИЗМЕНИТЬ"--%>
<%--                 В фильтрах все четко прописал, чтобы не дай бог по URL кто не забрел!   --%>
                    <% List<Student> student = (List<Student>) request.getAttribute("students");%>
                    <%Person person = (Person) session.getAttribute("login");%>
                    <% if (person.getCredUser().getRole().equals("ADMIN")
                            || (student.get(0).getBand().getCoach().getName().equals(person.getName())))
                            { %>
                    <input type="submit" value="Изменить" style="float:left">
                    <%}%>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
