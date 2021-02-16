package servlet;

import manager.UserManager;
import model.User;
import model.UserType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userRegister")
public class UserRegisterServlet extends HttpServlet {

    private UserManager userManager = new UserManager();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String type = req.getParameter("type");

        StringBuilder msg = new StringBuilder();

        if (name == null || name.length() ==0){
            msg.append("Name field is required <br>");
        }
        if (surname == null || surname.length() ==0){
            msg.append("Surname field is required <br>");
        }
        if (email == null || email.length() ==0){
            msg.append("email field is required <br>");
        } else if (userManager.getByEmail(email) != null){
            msg.append("email already exists <br>");
        }
        if (password == null || password.length() ==0){
            msg.append("Password field is required <br>");
        }

        if (msg.toString().equals("")){
            User user = User.builder()
                    .name(name)
                    .surname(surname)
                    .email(email)
                    .password(password)
                    .userType(UserType.valueOf(type))
                    .build();
            userManager.Register(user);

            resp.sendRedirect("/managerPage");
        }
    }
}
