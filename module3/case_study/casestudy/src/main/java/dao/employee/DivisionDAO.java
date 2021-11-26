package dao.employee;

import model.employee.Division;
import model.employee.EducationDegree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionDAO implements IDivisionDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";
    private static final String SELECT_ALL_DIVISIONS = "select * from division;";

    public DivisionDAO() {
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
    public List<Division> selectAllDivisions() {
        List<Division> divisions = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISIONS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("division_id");
                String name = rs.getString("division_name");
                divisions.add(new Division(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisions;
    }
}
