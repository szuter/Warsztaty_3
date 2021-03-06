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

@WebServlet("/panelAdmin/UserEdit")
public class UserEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();

        int userId = Integer.parseInt(request.getParameter("userId"));
        int userGroupId = Integer.parseInt(request.getParameter("userGroupId"));
        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        userDao.update(new User(userId,userName,userEmail,userPassword,userGroupId));
        List<User> users = userDao.findAll();
        request.setAttribute("userList",users);
        getServletContext().getRequestDispatcher("/WEB-INF/MenageUsers.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user =userDao.read(userId);
        request.setAttribute("user",user);
        getServletContext().getRequestDispatcher("/WEB-INF/UserEdit.jsp").forward(request,response);
    }
}
