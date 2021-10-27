<%@ page import="by.academy.web.model.Role" %>
<%@ page import="by.academy.web.model.Person" %><%--
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
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h1 align="center">
    This is page for Lists students!
</h1>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Age</td>
        <td>Group</td>
        <td>Topic-1</td>
        <td>Topic-2</td>
        <td>Topic-3</td>
        <td>Topic-4</td>
    </tr>

    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.getId()}</td>
            <td>${student.getName()}</td>
            <td>${student.getAge()}</td>
            <td>${student.getGroupName()}</td>
            <td>${student.getMarks().get(0)}</td>
            <td>${student.getMarks().get(1)}</td>
            <td>${student.getMarks().get(2)}</td>
            <td>${student.getMarks().get(3)}</td>
            <td>
                <form action="update-student" method="post">
                    <input type="hidden" name="id" value="${student.getId()}">
                    <input type="hidden" name="name" value="${student.getName()}">
                    <input type="hidden" name="age" value="${student.getAge()}">
                    <input type="hidden" name="group" value="${student.getGroupName()}">
                    <input type="hidden" name="marks1" value="${student.getMarks().get(0)}">
                    <input type="hidden" name="marks2" value="${student.getMarks().get(1)}">
                    <input type="hidden" name="marks3" value="${student.getMarks().get(2)}">
                    <input type="hidden" name="marks4" value="${student.getMarks().get(3)}">

<%--                Пришлось чутка кода в jsp написать, чтобы у студентов не было записи "ИЗМЕНИТЬ"--%>
<%--                 В фильтрах все четко прописал, чтобы не дай бог по URL кто не забрел!   --%>

<%--                    <%Person person = (Person) session.getAttribute("login");%>--%>
<%--                    <% if (person.getCredUser().getRole().equals(Role.ADMIN) || person.getCredUser().getRole().equals(Role.COACH)--%>
<%--                            || person.getCredUser().getRoles().equals("ADMIN")--%>
<%--                            || person.getCredUser().getRoles().equals("COACH")) { %>--%>
                    <input type="submit" value="Изменить" style="float:left">
<%--                    <%}%>--%>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
