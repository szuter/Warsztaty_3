package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GroupInfo")
public class GroupInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupDao groupDao = new GroupDao();
        int groupId = Integer.parseInt(request.getParameter("GroupId"));
        Group group = groupDao.read(groupId);
        request.setAttribute("groupInfo",group);
        UserDao userDao = new UserDao();
        List<User> users = userDao.findAllByGroupId(groupId);
        request.setAttribute("listOfUsersByGroupId",users);
        getServletContext().getRequestDispatcher("/WEB-INF/GroupInfo.jsp").forward(request,response);

    }
}
