<%--
  Created by IntelliJ IDEA.
  User: KARLEN
  Date: 09.02.2021
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/register" method="post">

    name: <input type="text" name="name"> <br>
    surname: <input type="text" name="surname"> <br>
    email: <input type="text" name="email"> <br>
    password: <input type="password" name="password"> <br>
                <input type="submit" value="Register">
    </form>
</body>
</html>
