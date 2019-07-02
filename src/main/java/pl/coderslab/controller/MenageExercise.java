package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/panelAdmin/MenageExercise")
public class MenageExercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> exercises = exerciseDao.findAll();
        request.setAttribute("exerciseList",exercises);
        getServletContext().getRequestDispatcher("/WEB-INF/MenageExercises.jsp").forward(request,response);
    }
}
