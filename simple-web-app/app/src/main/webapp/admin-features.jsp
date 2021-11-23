<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="by.academy.web.model.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 09.10.2021
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin features</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h3 align="center"> Admin is the God!</h3>
<table border=1px solid #A4A4A4>
    <tr>
        <td>
        <table border="2">
            <tr>
                <td><b>Coaches</b> </td>
            </tr>
            <tr>
                <td><b> ID</b></td>
                <td><b>Login</b> </td>
                <td><b>Password</b></td>
                <td><b>Role </b></td>
                <td><b>Name</b></td>
                <td><b>Age</b></td>
                <td><b>Salary</b></td>
                <td><b>Action</b></td>
            </tr>
       <c:forEach items="${coachMap}" var = "coach">
            <tr>
           <td>${coach.key}</td>
           <td>${coach.value.getCredUser().getLogin()} </td>
           <td>${coach.value.getCredUser().getPassword()} </td>
           <td>${coach.value.getCredUser().getRole()} </td>
           <td>${coach.value.getName()}</td>
           <td>${coach.value.getAge()}</td>
           <td>${coach.value.getSalary()}</td>
           <td>
           <form action = "update-coach" method="post">
           <input type="hidden" name="id" value="${coach.key}">
           <input type="hidden" name="name" value="${coach.value.getName()}">
           <input type="hidden" name="age" value="${coach.value.getAge()}">
           <input type="hidden" name="salary" value="${coach.value.getSalary()}">
           <input type="submit" value="Изменить" style="float:left">
           </form>
           <form action="${pageContext.request.contextPath}/delete-coach" method="post">
           <input type="hidden" name="id" value="${coach.key}">
           <input type="submit" value="Удалить" style="float:left">
           </form></td>
            </tr>
       </c:forEach>
        </table>
            <form action = "${pageContext.request.contextPath}/add-coach">
                <input type="submit" value="Добавить нового тренера">
            </form>
        </td>
    <td>
        <table border="2">
            <tr>
                <td><b>Students</b> </td>
            </tr>

            <tr>
                <td><b>ID</b></td>
                <td><b>login </b></td>
                <td><b>password</b></td>
                <td><b>Role </b></td>
                <td><b>Name</b></td>
                <td><b>Age</b></td>
                <td><b>Band</b></td>
                <td><b>Coach</b></td>
            </tr>
<%--                Так как у разных студентов может быть разное количество предметов изучаемых будем выводить для каждого шапку
                    потому как ваш подопечный не хочет разбивать на разные таблицы с одинаковым набором предметов в шапке, а хочу
                    вывести всех в одной.
 --%>       <tr>
                <c:forEach items="${studentMap}" var = "student">
                <td>&emsp;</td>
                <td>&emsp;</td>
                <td>&emsp;</td>
                <td>&emsp;</td>
                <td>&emsp;</td>
                <td>&emsp;</td>
                <td>&emsp;</td>
                <td>&emsp;</td>

                <c:forEach items="${student.value.band.disciplines}" var = "dis">
                           <td><b><c:out value="${dis}"/></b></td>
                </c:forEach>

                <td><b>Action</b></td>
             </tr>
              <tr>
                    <td>${student.key}</td>
                    <td>${student.value.getCredUser().getLogin()} </td>
                    <td>${student.value.getCredUser().getPassword()} </td>
                    <td>${student.value.getCredUser().getRole()} </td>
                    <td>${student.value.getName()}</td>
                    <td>${student.value.getAge()}</td>
                    <td>${student.value.band.name}</td>
                    <td>${student.value.band.coach.name}</td>

                <c:forEach items="${student.value.getMarks()}" var = "marks">
                    <td><c:out value="${marks}"/></td>
                </c:forEach>

                    <td>
                        <form action="update-student" method="post">
                            <input type="hidden" name="id" value="${student.key}">
                            <input type="hidden" name="login" value="${student.value.getCredUser().getLogin()}">
                            <input type="hidden" name="password" value="${student.value.getCredUser().getPassword()}">
                            <input type="hidden" name="role" value="${student.value.getCredUser().getRole()}">
                            <input type="hidden" name="name" value="${student.value.getName()}">
                            <input type="hidden" name="age" value="${student.value.getAge()}">
                            <input type="hidden" name="group" value="${student.value.band.name}">
                            <input type="hidden" name="group" value="${student.value.band.coach.name}">
                            <input type="hidden" name="marks1" value="${student.value.getMarks().get(0)}">
                            <input type="hidden" name="marks2" value="${student.value.getMarks().get(1)}">
                            <input type="hidden" name="marks3" value="${student.value.getMarks().get(2)}">
                            <input type="hidden" name="marks4" value="${student.value.getMarks().get(3)}">
                            <input type="submit" value="Изменить" style="float:left">
                        </form>
                        <form action="${pageContext.request.contextPath}/delete-student" method="post">
                            <input type="hidden" name="id" value="${student.key}">
                            <input type="submit" value="Удалить" style="float:left">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action = "${pageContext.request.contextPath}/add-student">
            <input type="submit" value="Добавить нового студента">
        </form>
    </td>
    </tr>
</table>
</body>
</html>
