package dao.employee;

import model.employee.Role;
import model.employee.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDAO implements IUserRoleDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";
    private static final String SELECT_ALL_USER_ROLES = "select * from user_role;";

    public UserRoleDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<UserRole> selectAllUserRoles() {
        List<UserRole> userRoles = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER_ROLES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("role_id");
                String name = rs.getString("user_name");
                userRoles.add(new UserRole(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userRoles;
    }
}
