package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/panelAdmin/MenageGroup")
public class MenageGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupDao groupDao = new GroupDao();
        List<Group> groups = groupDao.findAll();
        request.setAttribute("groupList",groups);
        getServletContext().getRequestDispatcher("/WEB-INF/MenageGroups.jsp").forward(request,response);
    }
}
