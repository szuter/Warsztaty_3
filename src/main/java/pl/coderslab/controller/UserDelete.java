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

@WebServlet("/panelAdmin/UserDelete")
public class UserDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        int userId = Integer.parseInt(request.getParameter("userId"));
        userDao.delete(userId);
        List<User> users = userDao.findAll();
        request.setAttribute("userList",users);
        getServletContext().getRequestDispatcher("/WEB-INF/MenageUsers.jsp").forward(request,response);

    }
}
