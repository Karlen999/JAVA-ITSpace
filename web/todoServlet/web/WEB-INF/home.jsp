<%@ page import="java.util.List" %>
<%@ page import="model.ToDo" %>
<%@ page import="model.User" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
List<ToDo> todos = (List<ToDo>) request.getAttribute("todos");
    User user = (User) request.getSession().getAttribute("user");
%>
Welcome to <%=user.getName()%> <a href="/logout"> logout </a><br>
<a href="/"> Index</a>

<form action="/addTodo" method="post">
    <input name="title" type="text"/> <br>
    <input name="deadline" type="date"/><br>
    <input type="submit" value="create">
</form>
<ul>
    <%for (ToDo todo : todos) { %>
           <li><%=todo.getTitle()%> - <%= todo.getStatus()%></li>
        <%}%>
</ul>
</body>
</html>
