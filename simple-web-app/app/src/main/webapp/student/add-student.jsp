<%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 14.10.2021
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h1 align="center">
    This is page for adding the user!
</h1>
<table border="2">
    <tr>

        <td><b>Login</b></td>
        <td><b>Password</b></td>
        <td><b>Name</b></td>
        <td><b>Age</b></td>
        <td><b>Band</b></td>
        <td><b>Action</b></td>
    </tr>

    <tr>

        <form action="student" method="post">
            <td><input required type="text" name="login" placeholder="Логин"></td>
            <td><input required type="text" name="password" placeholder="Пароль"></td>
            <td><input required type="text" name="name" placeholder="Имя Фамилия"></td>
            <td><input required type="text" name="age" placeholder="Возраст"></td>

            <td>
                <table border="1">
                    <c:forEach items="${listBand}" var="band">
                        <tr>
                            <td><label><input required type="radio" checked name="raz" value="${band.name}"/>${band.name} </label> <br></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td><input type="submit" value="Сохранить"></td>
        </form>
    </tr>

</table>
</body>
</html>
