package dao.employee;

import model.employee.EducationDegree;
import model.employee.PositionEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDAO implements IEducationDegreeDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";
    private static final String SELECT_ALL_EDUCATION_DEGREES = "select * from education_degree;";

    public EducationDegreeDAO() {
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
    public List<EducationDegree> selectAllEducationDegrees() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("education_degree_id");
                String name = rs.getString("education_degree_name");
                educationDegrees.add(new EducationDegree(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegrees;
    }
}
