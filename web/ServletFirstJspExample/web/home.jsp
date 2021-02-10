<%@ page import="model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: KARLEN
  Date: 09.02.2021
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    User user = (User) request.getAttribute("user");
    List<User> users = (List<User>) request.getAttribute("allUsers");
    if (user != null) {
%>
Welcome <%=user.getName() %> <%=user.getSurname()%>
<%}%>
All users
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Surname</td>
        <td>Email</td>
        <td>delete</td>
    </tr>

    <%for (User user1 : users) { %>
    <tr>
        <td><%=user1.getId()%>
        </td>
        <td><%=user1.getName()%>
        </td>
        <td><%=user1.getSurname()%>
        </td>
        <td><%=user1.getEmail()%>
        </td>
        <td><a href="/removeUser?id=<%=user1.getId()%>">delete</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
