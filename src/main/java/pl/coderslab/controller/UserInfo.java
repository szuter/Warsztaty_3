package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        SolutionDao solutionDao = new SolutionDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.read(userId);
        List<Solution> solutions = solutionDao.findAllByUserId(userId);
        List<Exercise> exercises = exerciseDao.findAll();
        request.setAttribute("listOfSolutionsByUserId", solutions);
        request.setAttribute("listOfExercises", exercises);
        request.setAttribute("user",user);

        getServletContext().getRequestDispatcher("/WEB-INF/UserInfo.jsp").forward(request,response);

    }
}
