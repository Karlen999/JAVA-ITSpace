package servlet;

import manager.TaskManager;
import model.Task;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/userPage")
public class UserPageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        TaskManager taskManager = new TaskManager();
        List<Task> allTaskByUser = taskManager.getAllTaskByUser(user.getId());
        req.setAttribute("tasks", allTaskByUser);
        req.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(req,resp);

    }
}
