<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="by.academy.web.model.Student" %><%--
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
    Редактировать оценки ${param.name}
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
<%--            Необходимо чутка,понимаю что это плохо, java вставки для нормального отображения и подсказок,
                полей для редактирования оценок, так как разное кол-во оценок
--%>
        <%  StringBuilder stringBuilder = new StringBuilder();%>
        <%  for (int i = 1; i <= disciplines.size(); i++) {%>
        <%      String result = "marks" + stringBuilder.append(i).toString();%>
            <td><input required  type="text" name=<%=result%>  </td>
            <%   stringBuilder.delete(0, stringBuilder.length());%>
            <%  } %>
            <td><input type="submit" value="Сохранить"></td>
        </form>








    </tr>
</table>
</body>
</html>
