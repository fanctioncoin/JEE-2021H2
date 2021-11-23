<%--
  Created by IntelliJ IDEA.
  User: Победитель
  Date: 03.10.2021
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<style>--%>
<%--    @import url("/resources/style.css");--%>
<%--</style>--%>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<br>
<div align="center">
    <h1>Вход в систему</h1>
    <form action="login" method="post">
        Пользователь: <input required  type="text" name="login" size="10"><br>
        <p margin-top="5%">
            Пароль: <input required  type="password" name="password" size="10"><br>
        </p>
        <table>
            <tr>
                <small>
                    <input type="submit" value="Войти  в систему">
                </small>
        </table>
    </form>
</div>
<br>
</body>
</html>
