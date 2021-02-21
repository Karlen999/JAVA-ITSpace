package servlet;

import manager.TaskManager;
import manager.UserManager;
import model.Status;
import model.Task;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/addTask")
public class AddTaskServlet extends HttpServlet {

    private TaskManager taskManager = new TaskManager();
    private UserManager userManager = new UserManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String date = req.getParameter("date");
        String status = req.getParameter("status");
        User user =  userManager.getById(Integer.parseInt(req.getParameter("user_id")));

        try {
            taskManager.add(Task.builder()
                    .name(name)
                    .description(description)
                    .deadline(sdf.parse(date))
                    .status(Status.valueOf(status))
                    .user(user)
                    .build());

            resp.sendRedirect("/managerPage");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
