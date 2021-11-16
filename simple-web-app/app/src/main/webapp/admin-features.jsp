<%--
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
<%--<#list roles as role>--%>
<%--<div>--%>
<%--    <label>  <input type="checkbox" name="${role}"  ${role} </label>--%>
<%--</div>--%>
<%--</#list>--%>
<table border=1px solid #A4A4A4>
    <tr>
        <td>
        <table border="2">
            <tr>
                <td>Coaches </td>
            </tr>
            <tr>
                <td>ID</td>
                <td>Login </td>
                <td>Password</td>
                <td>Role </td>
                <td>Name</td>
                <td>Age</td>
                <td>Salary</td>
                <td>Action</td>
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
        </td>
    <td>
        <table border="2">
            <tr>
                <td>Students </td>
            </tr>
            <tr>
                <td>ID</td>
                <td>login </td>
                <td>password</td>
                <td>role </td>
                <td>Name</td>
                <td>Age</td>
                <td>Band</td>
                <td>Coach</td>
                <td>Topic-1</td>
                <td>Topic-2</td>
                <td>Topic-3</td>
                <td>Topic-4</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${studentMap}" var = "student">
                <tr>
                    <td>${student.key}</td>
                    <td>${student.value.getCredUser().getLogin()} </td>
                    <td>${student.value.getCredUser().getPassword()} </td>
                    <td>${student.value.getCredUser().getRole()} </td>
                    <td>${student.value.getName()}</td>
                    <td>${student.value.getAge()}</td>
                    <td>${student.value.band.name}</td>
                    <td>${student.value.band.coach.name}</td>
                    <td>${student.value.getMarks().get(0)}</td>
                    <td>${student.value.getMarks().get(1)}</td>
                    <td>${student.value.getMarks().get(2)}</td>
                    <td>${student.value.getMarks().get(3)}</td>
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
                        <form action="${pageContext.request.contextPath}/delete-coach" method="post">
                            <input type="hidden" name="id" value="${student.key}">
                            <input type="submit" value="Удалить" style="float:left">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </td>
    </tr>
</table>

</body>
</html>
