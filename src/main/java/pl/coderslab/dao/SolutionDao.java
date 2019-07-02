package pl.coderslab.dao;

import pl.coderslab.model.Solution;
import pl.coderslab.db.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {
    private static final String CREATE_SOLUTION_QUERY =
            "insert into solution(created,updated,description,users_id,exercise_id) values(now(),?,?,?,?);";
    private static final String READ_SOLUTION_QUERY =
            "SELECT * FROM solution where id = ?";
    private static final String UPDATE_SOLUTION_QUERY =
            "UPDATE solution SET description = ?, users_id = ?, exercise_id = ?, updated = now() where id = ?";
    private static final String DELETE_SOLUTION_QUERY =
            "DELETE FROM solution WHERE id = ?";
    private static final String FIND_ALL_SOLUTION_QUERY =
            "SELECT * FROM solution";
    private static final String FIND_ALL_BY_USER_ID =
            "select * from solution where users_id = ?;";
    private static final String FIND_ALL_BY_EXERCISE_ID =
            "select * from solution where exercise_id = ?;";
    private static final String FIND_LAST_ADDED_SOLUTIONS = "select * from solution order by created desc limit ?";

    public Solution create(Solution solution) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_SOLUTION_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, solution.getUpdated());
            statement.setString(2, solution.getDescription());
            statement.setInt(3, solution.getUser_id());
            statement.setInt(4, solution.getExercise_id());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                solution.setId(resultSet.getInt(1));
            }
            return solution;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solution read(int userId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setDescription(resultSet.getString("description"));
                solution.setUser_id(resultSet.getInt("users_id"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setCreated(resultSet.getString("created"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void update(Solution solution) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setString(1, solution.getDescription());
            statement.setInt(2, solution.getUser_id());
            statement.setInt(3, solution.getExercise_id());
            statement.setInt(4, solution.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int solutionId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Solution> findAll() {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_SOLUTION_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Solution> solutions = new ArrayList<>();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setDescription(resultSet.getString("description"));
                solution.setUser_id(resultSet.getInt("users_id"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setCreated(resultSet.getString("created"));
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Solution> findAllByUserId(int userId) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_USER_ID);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            List<Solution> solutions = new ArrayList<>();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setDescription(resultSet.getString("description"));
                solution.setUser_id(resultSet.getInt("users_id"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setCreated(resultSet.getString("created"));
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Solution> findAllByExerciseId(int exerciseId) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_EXERCISE_ID);
            statement.setInt(1, exerciseId);
            ResultSet resultSet = statement.executeQuery();
            List<Solution> solutions = new ArrayList<>();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setDescription(resultSet.getString("description"));
                solution.setUser_id(resultSet.getInt("users_id"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setCreated(resultSet.getString("created"));
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Solution> findLastSolutions(int range) {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_LAST_ADDED_SOLUTIONS);
            statement.setInt(1, range);
            ResultSet resultSet = statement.executeQuery();
            List<Solution> solutions = new ArrayList<>();
            while (resultSet.next()) {
                Solution solution = new Solution();
                solution.setId(resultSet.getInt("id"));
                solution.setDescription(resultSet.getString("description"));
                solution.setUser_id(resultSet.getInt("users_id"));
                solution.setExercise_id(resultSet.getInt("exercise_id"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setCreated(resultSet.getString("created"));
                solutions.add(solution);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
}
