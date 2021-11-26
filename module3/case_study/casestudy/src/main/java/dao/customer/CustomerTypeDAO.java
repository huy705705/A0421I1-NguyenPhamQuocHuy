package dao.customer;

import model.customer.Customer;
import model.customer.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeDAO implements ICustomerTypeDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";
    private static final String SELECT_ALL_CUSTOMERS_TYPE = "select * from customer_type;";

    public CustomerTypeDAO() {
    }
    protected Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertCustomerType(CustomerType customerType) throws SQLException {

    }

    @Override
    public CustomerType selectCustomerType(int id) {
        return null;
    }

    @Override
    public List<CustomerType> selectAllCustomersType() {
        List<CustomerType> customerTypes=new ArrayList<>();
        try (Connection connection=getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_CUSTOMERS_TYPE)){
            System.out.println(preparedStatement);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int typeId=rs.getInt("customer_type_id");
                String name=rs.getString("customer_type_name");
                customerTypes.add(new CustomerType(typeId,name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypes;

    }

    @Override
    public boolean deleteCustomerType(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCustomerType(CustomerType customerType) throws SQLException {
        return false;
    }

    @Override
    public List<CustomerType> searchCustomerType(String country) throws SQLException {
        return null;
    }

    @Override
    public List<CustomerType> sortCustomerType() throws SQLException {
        return null;
    }
}
