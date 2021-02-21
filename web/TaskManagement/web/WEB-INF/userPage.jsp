<%@ page import="model.Task" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: KARLEN
  Date: 17.02.2021
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List<Task> tasks = (List<Task>) request.getAttribute("tasks");
    User user = (User) session.getAttribute("user");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

%><br>
<br>
Welcome <%=user.getName()%> <% if (user.getPictureUrl() != null) {%>
<img src="/image?path=<%=user.getPictureUrl()%>" width="50"> <%}%>
<br>
<a href="/logout">logout</a>

<div>
    All Tasks:<br>
    <table border="1">
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Deadline</td>
            <td>Status</td>
            <td>User</td>
            <td>Change Status</td>
            <td>Delete Task</td>
        </tr>
        <%
            for (Task task : tasks) {%>
        <tr>
            <td><%=task.getName()%>
            </td>
            <td><%=task.getDescription()%>
            </td>
            <td><%=sdf.format(task.getDeadline())%>
            </td>
            <td><%=task.getStatus().name()%>
            </td>
            <td><%=task.getUser().getName() + " " + task.getUser().getSurname()%>
            </td>
            <td>
                <form action="/changeStatus" method="post">
                    <input type="hidden" name="taskId" value="<%= task.getId()%>">
                    <select name="status">
                        <option value="NEW">NEW</option>
                        <option value="IN_PROGRESS">IN_PROGRESS</option>
                        <option value="FINISHED">FINISHED</option>
                    </select><input type="submit" value="Ok">
                </form>
            </td>
            <td>
                <form action="/deleteTask" method="post">
                    <input type="hidden" name="taskId" value="<%=task.getId()%>">
                    <input type="submit" value="Delete">
                </form>
            </td>

        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
