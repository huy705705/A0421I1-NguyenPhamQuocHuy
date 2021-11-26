package dao.employee;

import model.customer.Customer;
import model.employee.Employee;
import model.employee.User;
import model.employee.UserRole;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
    public boolean insertEmployee(Employee employee, User user, UserRole userRole) throws SQLException;

    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployees();

    public boolean deleteEmployee(int id,String userName) throws SQLException;

    public boolean updateEmployee(Employee oldEmployee,Employee newEmployee,User user,UserRole userRole) throws SQLException;

    public List<Employee> searchEmployeeByCountryAndName (String country,String name) throws SQLException;
    public List<Employee> searchEmployeeByName (String name) throws SQLException;
    public Map<String,String> insertEmployee2(Employee employee);
    public List<Employee> sort () throws SQLException;
}
