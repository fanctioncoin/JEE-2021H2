<%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 03.10.2021
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header </title>
    <style type="text/css">
        .block1 {
            background: #ccc;
            padding: 5px;
            border: solid 1px black;
            margin-bottom: 6px;
        }
    </style>
</head>
<body>
<div class="block1">
    <table>
        <tr>
            <form action="home.jsp">
                <input type="submit" name="home" value="Home">
            </form>

        <tr>
            <form action="user-coach" method="get">
                <input type="submit" name="list" value="List coaches">
            </form>

        <tr>
            <form action="user-coach" method="get">
                <input type="submit" name="salarylist" value="List salary">
            </form>
        <tr>
            <form action="main" method="get">
                <input type="submit" name="studentslist" value="List students">
            </form>
        <tr>
            <form action="main" method="get">
                <input type="submit" name="adminFeatures" value="Admin features">
            </form>

    </table>
    <form action="main" method="get">
        <div align="right">
            <input type="submit" name="exit" value="Exit">
        </div>
    </form>

</div>
</body>
</html>
