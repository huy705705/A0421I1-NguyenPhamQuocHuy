package dao.customer;

import model.customer.Customer;
import model.customer.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerTypeDAO {
    public void insertCustomerType(CustomerType customerType) throws SQLException;

    public CustomerType selectCustomerType(int id);

    public List<CustomerType> selectAllCustomersType();

    public boolean deleteCustomerType(int id) throws SQLException;

    public boolean updateCustomerType(CustomerType customerType) throws SQLException;

    public List<CustomerType> searchCustomerType (String country) throws SQLException;

    public List<CustomerType> sortCustomerType () throws SQLException;
}
