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

@WebServlet("/panelAdmin/ExerciseEdit")
public class ExerciseEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        int exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
        String exerciseTitle = request.getParameter("exerciseTitle");
        String exerciseDescription = request.getParameter("exerciseDescription");
        exerciseDao.update(new Exercise(exerciseId, exerciseTitle, exerciseDescription));
        List<Exercise> exercises = exerciseDao.findAll();
        request.setAttribute("exerciseList", exercises);
        getServletContext().getRequestDispatcher("/WEB-INF/MenageExercises.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExerciseDao exerciseDao = new ExerciseDao();
        int exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
        Exercise exercise = exerciseDao.read(exerciseId);
        request.setAttribute("exercise", exercise);
        getServletContext().getRequestDispatcher("/WEB-INF/ExerciseEdit.jsp").forward(request, response);
    }
}
