package dao.employee;

import model.employee.Employee;
import model.employee.PositionEmployee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionEmployeeDAO implements IPositionEmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";
    private static final String SELECT_ALL_POSITION_EMPLOYEES = "select * from position_employee;";

    public PositionEmployeeDAO() {
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
    public List<PositionEmployee> selectAllPositionEmployees() {
        List<PositionEmployee> positionEmployees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION_EMPLOYEES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                positionEmployees.add(new PositionEmployee(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionEmployees;
    }
}
