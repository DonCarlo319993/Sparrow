package controller;


import dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "usersServlet", urlPatterns = {"/users"})
public class UsersServlet extends HttpServlet {

    private UserDAO userDao = new UserDAO();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Set<String> followedUsers = userDao.getFollowedUsers((String) request.getSession().getAttribute("username"));
//        Set<String> notFollowedUsers = userDao.getNotFollowedUsers((String) request.getSession().getAttribute("username"));
//        request.setAttribute("followedUsers", followedUsers);
//        request.setAttribute("notFollowedUsers", notFollowedUsers);

        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
