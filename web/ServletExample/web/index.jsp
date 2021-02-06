<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
Hello world!! <br>
<h1> Գրանցում </h1>
<form action="/register" method="post">
    Անուն։ <input type="text" name="name"> <br>
    Ազգանուն։ <input type="text" name="surname"> <br>
    email: <input type="text" name="email"> <br>
    password: <input type="password" name="password"> <br>
    <input type="submit" value="Գրանցել">
</form>
</body>
</html>
