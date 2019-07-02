package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/panelAdmin/UserAdd")
public class UserAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User user = new User();
        int userGroupId = Integer.parseInt(request.getParameter("userGroupId"));
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        user.setUserName(userName);
        user.setEmail(userEmail);
        user.setGroupId(userGroupId);
        user.setPassword(userPassword);
        userDao.create(user);
        List<User> users = userDao.findAll();
        request.setAttribute("userList", users);
        getServletContext().getRequestDispatcher("/WEB-INF/MenageUsers.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/UserAdd.jsp").forward(request, response);
    }
}
