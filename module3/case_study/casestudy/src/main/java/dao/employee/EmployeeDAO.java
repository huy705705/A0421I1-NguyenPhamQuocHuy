package dao.employee;

import model.customer.Customer;
import model.employee.Employee;
import model.employee.User;
import model.employee.UserRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDAO implements IEmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";
    private static final String SELECT_ALL_EMPLOYEES = "select * from employee;";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id =?;";
    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employee" + "  (employee_name,employee_birthday,employee_id_card," +
            "employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id," +
            "user_name) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_USER_ROLES_SQL = "insert into user_role values (?,?);";
    private static final String INSERT_USER_SQL = "insert into user values (?,?);";
    private static final String UPDATE_USERS_SQL = "update user set username=?,password=? where username=?;";
    private static final String UPDATE_USER_ROLES_SQL = "update user_role set role_id=?,user_name=? where user_name=?;";
    private static final String UPDATE_EMPLOYEES_SQL = "update employee set employee_name=?,employee_birthday=?,employee_id_card=?," +
            "employee_salary=?,employee_phone=?,employee_email=?," +
            "employee_address=?,position_id=?,education_degree_id=?,division_id=?,user_name=? where employee_id=?;";
    private static final String DELETE_EMPLOYEES_SQL = "delete from employee where employee_id = ?;";
    private static final String DELETE_USER_SQL = "delete from user where username = ?;";
    private static final String SELECT_EMPLOYEE_BY_NAME_AND_COUNTRY = "SELECT * FROM employee WHERE employee_name LIKE ? AND employee_address like ? ;";
    private static final String SELECT_EMPLOYEE_BY_NAME= "SELECT * FROM employee WHERE employee_name LIKE ?;";


    public EmployeeDAO() {
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
    public boolean insertEmployee(Employee employee, User user, UserRole userRole) throws SQLException {
        System.out.println(INSERT_EMPLOYEES_SQL);
        boolean rowInserted = false;
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatementInsertUser = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatementInsertUser.setString(1, user.getUserName());
            preparedStatementInsertUser.setString(2, user.getPassword());
            int rowAffect = preparedStatementInsertUser.executeUpdate();
            PreparedStatement preparedStatementInsertUserRole = connection.prepareStatement(INSERT_USER_ROLES_SQL);
            preparedStatementInsertUserRole.setInt(1, userRole.getRoleId());
            preparedStatementInsertUserRole.setString(2, userRole.getUserName());
//
            rowAffect += preparedStatementInsertUserRole.executeUpdate();

            if (rowAffect == 2) {
                PreparedStatement preparedStatementInsertEmployee = connection.prepareStatement(INSERT_EMPLOYEES_SQL);
                preparedStatementInsertEmployee.setString(1, employee.getEmployeeName());
                preparedStatementInsertEmployee.setString(2, employee.getEmployeeBirthday());
                preparedStatementInsertEmployee.setString(3, employee.getEmployeeIdCard());
                preparedStatementInsertEmployee.setDouble(4, employee.getEmployeeSalary());
                preparedStatementInsertEmployee.setString(5, employee.getEmployeePhone());
                preparedStatementInsertEmployee.setString(6, employee.getEmployeeEmail());
                preparedStatementInsertEmployee.setString(7, employee.getEmployeeAddress());
                preparedStatementInsertEmployee.setInt(8, employee.getEmployeePositionId());
                preparedStatementInsertEmployee.setInt(9, employee.getEmployeeEducationDegreeId());
                preparedStatementInsertEmployee.setInt(10, employee.getEmployeeDivisionId());
                preparedStatementInsertEmployee.setString(11, employee.getEmployeeUserName());
//                thieu id
                System.out.println(preparedStatementInsertEmployee);
                rowAffect += preparedStatementInsertEmployee.executeUpdate();
            }


//            preparedStatementInsertEmployee.setString(1, employee.getEmployeeName());
//            preparedStatementInsertEmployee.setString(2, employee.getEmployeeBirthday());
//            preparedStatementInsertEmployee.setString(3, employee.getEmployeeIdCard());
//            preparedStatementInsertEmployee.setDouble(4, employee.getEmployeeSalary());
//            preparedStatementInsertEmployee.setString(5, employee.getEmployeePhone());
//            preparedStatementInsertEmployee.setString(6, employee.getEmployeeEmail());
//            preparedStatementInsertEmployee.setString(7, employee.getEmployeeAddress());
//            preparedStatementInsertEmployee.setInt(8, employee.getEmployeePositionId());
//            preparedStatementInsertEmployee.setInt(9, employee.getEmployeeEducationDegreeId());
//            preparedStatementInsertEmployee.setInt(10, employee.getEmployeeDivisionId());
//            preparedStatementInsertEmployee.setString(11, employee.getEmployeeUserName());
//            System.out.println(preparedStatementInsertEmployee);
//            rowInserted = preparedStatement.executeUpdate() > 0;


            if (rowAffect == 3) {
                connection.commit();
                rowInserted = true;
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowInserted;
    }

    public Map<String, String> insertEmployee2(Employee employee) {
        return null;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id2 = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String userName = resultSet.getString("user_name");
                employee = new Employee(id2, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("user_name");
                employees.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id,String userName) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatementInsertUser = connection.prepareStatement(DELETE_USER_SQL);
            preparedStatementInsertUser.setString(1,userName);
            int rowAffect = preparedStatementInsertUser.executeUpdate();

//            PreparedStatement preparedStatementInsertUserRole = connection.prepareStatement(UPDATE_USER_ROLES_SQL);
//            preparedStatementInsertUserRole.setInt(1, userRole.getRoleId());
//            preparedStatementInsertUserRole.setString(2, userRole.getUserName());
//            preparedStatementInsertUserRole.setString(3, oldEmployee.getEmployeeUserName());

//
//            rowAffect += preparedStatementInsertUserRole.executeUpdate();

//            if (rowAffect == 1) {
//                PreparedStatement preparedStatementInsertEmployee = connection.prepareStatement(DELETE_EMPLOYEES_SQL);
//                preparedStatementInsertEmployee.setInt(1,id);
//                System.out.println(preparedStatementInsertEmployee);
//                rowAffect += preparedStatementInsertEmployee.executeUpdate();
//            }

            if (rowAffect == 1) {
                connection.commit();
                rowDeleted = true;
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee oldEmployee,Employee newEmployee,User user,UserRole userRole) throws SQLException {
        boolean rowInserted = false;
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);


            PreparedStatement preparedStatementInsertUser = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatementInsertUser.setString(1, user.getUserName());
            preparedStatementInsertUser.setString(2, user.getPassword());
            preparedStatementInsertUser.setString(3, oldEmployee.getEmployeeUserName());



            int rowAffect = preparedStatementInsertUser.executeUpdate();


//            PreparedStatement preparedStatementInsertUserRole = connection.prepareStatement(UPDATE_USER_ROLES_SQL);
//            preparedStatementInsertUserRole.setInt(1, userRole.getRoleId());
//            preparedStatementInsertUserRole.setString(2, userRole.getUserName());
//            preparedStatementInsertUserRole.setString(3, oldEmployee.getEmployeeUserName());

//
//            rowAffect += preparedStatementInsertUserRole.executeUpdate();

            if (rowAffect == 1) {
                PreparedStatement preparedStatementInsertEmployee = connection.prepareStatement(UPDATE_EMPLOYEES_SQL);
                preparedStatementInsertEmployee.setString(1, newEmployee.getEmployeeName());
                preparedStatementInsertEmployee.setString(2, newEmployee.getEmployeeBirthday());
                preparedStatementInsertEmployee.setString(3, newEmployee.getEmployeeIdCard());
                preparedStatementInsertEmployee.setDouble(4, newEmployee.getEmployeeSalary());
                preparedStatementInsertEmployee.setString(5, newEmployee.getEmployeePhone());
                preparedStatementInsertEmployee.setString(6, newEmployee.getEmployeeEmail());
                preparedStatementInsertEmployee.setString(7, newEmployee.getEmployeeAddress());
                preparedStatementInsertEmployee.setInt(8, newEmployee.getEmployeePositionId());
                preparedStatementInsertEmployee.setInt(9, newEmployee.getEmployeeEducationDegreeId());
                preparedStatementInsertEmployee.setInt(10, newEmployee.getEmployeeDivisionId());
                preparedStatementInsertEmployee.setString(11, newEmployee.getEmployeeUserName());
                preparedStatementInsertEmployee.setInt(12, newEmployee.getEmployeeId());
                System.out.println(preparedStatementInsertEmployee);
                rowAffect += preparedStatementInsertEmployee.executeUpdate();
            }

            if (rowAffect == 2) {
                connection.commit();
                rowInserted = true;
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowInserted;
    }
    @Override
    public List<Employee> searchEmployeeByName(String name) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name2 = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("user_name");
                employees.add(new Employee(id, name2, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> searchEmployeeByCountryAndName(String country,String name) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME_AND_COUNTRY)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%"+name+"%");
            preparedStatement.setString(2, "%"+country+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name2 = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("user_name");
                employees.add(new Employee(id, name2, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public List<Employee> sort() throws SQLException {
        return null;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
