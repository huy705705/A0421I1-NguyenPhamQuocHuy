package dao.customer;

import model.customer.Customer;
import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerDAO {
    public boolean insertCustomer(Customer customer) throws SQLException;
    public Map<String,String> insertCustomer2(Customer customer)throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomers();

    public boolean deleteCustomer(int id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public List<Customer> searchCustomerByName(String country) throws SQLException;

    public List<Customer> sort () throws SQLException;
}
