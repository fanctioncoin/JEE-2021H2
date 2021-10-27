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
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h3 align="center"> Admin is the God!</h3>
<#list roles as role>
<div>
    <label>  <input type="checkbox" name="${role}"  ${role} </label>
</div>
</#list>
<table border=1px solid #A4A4A4>
    <tr>
        <td>
        <table border="2">
            <tr>
                <td>Coaches </td>
            </tr>
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
                <td>Group</td>
                <td>Topic-1</td>
                <td>Topic-2</td>
                <td>Topic-3</td>
                <td>Topic-4</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${students}" var = "student">
                <tr>
                    <td>${student.getId()}</td>
                    <td>${student.getCredUser().getLogin()} </td>
                    <td>${student.getCredUser().getPassword()} </td>
                    <td>${student.getCredUser().getRole()} </td>
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
                            <input type="hidden" name="login" value="${student.getCredUser().getLogin()}">
                            <input type="hidden" name="password" value="${student.getCredUser().getPassword()}">
                            <input type="hidden" name="role" value="${student.getCredUser().getRole()}">
                            <input type="hidden" name="name" value="${student.getName()}">
                            <input type="hidden" name="age" value="${student.getAge()}">
                            <input type="hidden" name="group" value="${student.getGroupName()}">
                            <input type="hidden" name="marks1" value="${student.getMarks().get(0)}">
                            <input type="hidden" name="marks2" value="${student.getMarks().get(1)}">
                            <input type="hidden" name="marks3" value="${student.getMarks().get(2)}">
                            <input type="hidden" name="marks4" value="${student.getMarks().get(3)}">
                            <input type="submit" value="Изменить" style="float:left">
                        </form>
                        <form action="${pageContext.request.contextPath}/delete-coach" method="post">
                            <input type="hidden" name="id" value="${student.getId()}">
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
