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
    <title>Show Band</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<%@include file="/fragment/header.jsp" %>
<h1 align="center">
    This is page for Lists students!
    Please chose name band!
</h1>

<form action="student" method="get">
    <input type="submit" name="name_band" value="GLS_01_02">
</form>

<form action="student" method="get">
    <input type="submit" name="name_band" value="GLK_03_02">
</form>

</body>
</html>
