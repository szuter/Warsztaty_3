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

@WebServlet("/panelAdmin/ExerciseAdd")
public class ExerciseAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = new Exercise();
        String exerciseTitle = request.getParameter("exerciseTitle");
        String exerciseDescription = request.getParameter("exerciseDescription");
        exercise.setDescription(exerciseDescription);
        exercise.setTitle(exerciseTitle);
        exerciseDao.create(exercise);
        List<Exercise> exercises = exerciseDao.findAll();
        request.setAttribute("exerciseList", exercises);
        getServletContext().getRequestDispatcher("/WEB-INF/MenageExercises.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ExerciseAdd.jsp").forward(request, response);
    }
}
