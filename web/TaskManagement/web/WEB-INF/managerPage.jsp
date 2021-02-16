<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="model.Task" %><%--
  Created by IntelliJ IDEA.
  User: KARLEN
  Date: 17.02.2021
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager Page</title>
</head>
<body>

<% List<User> users = (List<User>) request.getAttribute("users");%>
<% List<Task> tasks = (List<Task>) request.getAttribute("tasks");%>

<div style="width: 1000px;">
    <div style="width: 40%; float: left">
        Add User:<br><br>
        <form action="/register" method="post">
            <input type="text" name="name" placeholder="please input name"> <br>
            <input type="text" name="surname" placeholder="please input surname"> <br>
            <input type="text" name="email" placeholder="please input email"> <br>
            <input type="password" name="password" placeholder="please input password"> <br>
            <select name="type">
                <option value="USER">USER</option>
                <option value="MANAGER">MANAGER</option>
            </select><br>
            <input type="submit" value="Register">

        </form>
    </div>
    <div style="width: 60%; float: left">
        Add Task:<br><br>
        <form action="/addTask" method="post">
            <input type="text" name="name" placeholder="name"> <br>
            <textarea name="description" placeholder="description"></textarea> <br>
            <input type="date" name="date"> <br>
            <select name="status">
                <option value="NEW">NEW</option>
                <option value="IN_PROGRESS">IN_PROGRESS</option>
                <option value="FINISHED">FINISHED</option>
            </select><br>
            <select name="user_id">
                <%
                    for (User user : users) { %>
                <option value="<%=user.getId()%>"><%=user.getName()%> <%=user.getSurname()%>
                </option>
                <%
                    }
                %>
            </select><br>

            <input type="submit" value="Add">
        </form>
    </div>

</div>
<div>
    All Users:<br>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Surname</td>
            <td>Email</td>
            <td>Type</td>
            <td>Delete user</td>
        </tr>
        <% for (User user : users) {%>
        <tr>
            <td><%=user.getName()%>
            </td>
            <td><%=user.getSurname()%>
            </td>
            <td><%=user.getEmail()%>
            </td>
            <td><%=user.getUserType().name()%>
            </td>

            <td>
                <form action="/deleteUser" method="post">
                    <input type="hidden" name="userId" value="<%=user.getId()%>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
<br><br>

<div>
    All Tasks:<br>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Deadline</td>
            <td>Status</td>
            <td>User</td>
            <td>Change User</td>
            <td>Delete User</td>
        </tr>
        <%
            for (Task task : tasks) {%>
        <tr>
            <td><%=task.getName()%>
            </td>
            <td><%=task.getDescription()%>
            </td>
            <td><%=task.getDeadline()%>
            </td>
            <td><%=task.getStatus().name()%>
            </td>
            <td><%=task.getUser().getName() + " " + task.getUser().getSurname()%>
            </td>

        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
