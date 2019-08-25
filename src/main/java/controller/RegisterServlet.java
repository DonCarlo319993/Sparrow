package controller;

import model.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "registerServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String PASSWORD_REPEATED = "passwordRepeated";
    private static final String REMEMBER = "remember";
    private static final String LAST_NAME = "lastname" ;
    private static final String EMAIL ="email" ;

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/view/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(USERNAME);
        String lastName = req.getParameter(LAST_NAME);
        String password = req.getParameter(PASSWORD);
        String passwordRepeated = req.getParameter(PASSWORD_REPEATED);
        String email = req.getParameter(EMAIL);

        if (!password.equals(passwordRepeated)){
            req.setAttribute("hasError", "true");
            req.setAttribute("error", "Passwords does not match!");
            req.getRequestDispatcher("WEB-INF/view/register.jsp").forward(req, resp);
        }else {
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setEmail(email);
            user.getDateOfRegistration();
            user.setDateOfRegistration(new Date());
            if (userService.registerUser(user)){
                req.getRequestDispatcher("login").forward(req, resp);
            }else {
                req.setAttribute("hasError", "true");
                req.setAttribute("error", "Email is already used in our database!");
                req.getRequestDispatcher("WEB-INF/view/register.jsp").forward(req, resp);
            }
        }
    }
}
