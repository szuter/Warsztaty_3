package pl.coderslab.dao;

import pl.coderslab.model.Group;
import pl.coderslab.db.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {
    private static final String CREATE_GROUP_QUERY =
            "INSERT INTO user_group(group_name) VALUES (?)";
    private static final String READ_GROUP_QUERY =
            "SELECT * FROM user_group where id = ?";
    private static final String UPDATE_GROUP_QUERY =
            "UPDATE user_group SET group_name = ? where id = ?";
    private static final String DELETE_GROUP_QUERY =
            "DELETE FROM user_group WHERE id = ?";
    private static final String FIND_ALL_GROUPS_QUERY =
            "SELECT * FROM user_group";

    public Group create(Group group) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_GROUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, group.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                group.setId(resultSet.getInt(1));
            }
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Group read(int groupId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_GROUP_QUERY);
            statement.setInt(1, groupId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("group_name"));
                return group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Group group) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_GROUP_QUERY);
            statement.setString(1, group.getName());
            statement.setInt(2, group.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int groupId) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_GROUP_QUERY);
            statement.setInt(1, groupId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Group> findAll() {
        try (Connection connection = DbUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_GROUPS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            List<Group> users = new ArrayList<>();
            while (resultSet.next()) {
                Group group = new Group();
                group.setId(resultSet.getInt("id"));
                group.setName(resultSet.getString("group_name"));
                users.add(group);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
