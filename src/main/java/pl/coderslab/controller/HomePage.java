package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class HomePage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        UserDao userDao = new UserDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        int range = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
        List<Solution> solutions = solutionDao.findLastSolutions(range);
        List<User> users = userDao.findAll();
        List<Exercise> exercises = exerciseDao.findAll();
        request.setAttribute("listOfSolutions", solutions);
        request.setAttribute("listOfUsers", users);
        request.setAttribute("listOfExercises", exercises);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
