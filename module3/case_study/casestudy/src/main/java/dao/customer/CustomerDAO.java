package dao.customer;

import model.customer.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO implements ICustomerDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "codegym";

    private static final String SELECT_ALL_CUSTOMERS = "select * from customer;";
    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customer" + "  (customer_type_id, customer_name, customer_birthday," +
            "customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id =?;";
    private static final String UPDATE_CUSTOMERS_SQL = "update customer set customer_type_id=?,customer_name = ?," +
            "customer_birthday= ?," +
            "customer_gender =?,customer_id_card=?,customer_phone=?," +
            "customer_email=?,customer_address=? where customer_id= ?;";
    private static final String DELETE_CUSTOMERS_SQL = "delete from customer where customer_id = ?;";
    private static final String SELECT_CUSTOMERS_BY_NAME = "SELECT * FROM customer WHERE customer_name LIKE ?  ";
    private static final String SELECT_CUSTOMERS_BY_NAME_AND_GENDER = "SELECT * FROM customer WHERE customer_name LIKE ? AND customer_gender=? ;";

    // VALIDATE
    private static final String EMAIL_REGEX="^[a-z]{3,20}\\d{1,9}@[a-z]{3,5}\\.[a-z]{3,5}$";
    private static final String PHONE_REGEX="^090[0-9]{7}|091[0-9]{7}$";




    public CustomerDAO() {
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
    public boolean insertCustomer(Customer customer) throws SQLException {
        System.out.println(INSERT_CUSTOMERS_SQL);
        boolean rowInserted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
            preparedStatement.setInt(1, customer.getTypeId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, Integer.parseInt(customer.getGender()));
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            System.out.println(preparedStatement);
            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowInserted;
    }

    public Map<String, String> insertCustomer2(Customer customer) throws SQLException{
        Map <String,String> mapValidate=new HashMap<>();
        boolean check=true;
        if("".equals(customer.getEmail())){
            check=false;
            mapValidate.put("emailMess","Email cannot be left blank");
        }else if(!validateEmail(customer.getEmail())){
            check=false;
            mapValidate.put("emailMess","Wrong email format");
        }else if("".equals(customer.getPhone())){
            mapValidate.put("phoneMess","Phone cannot be left blank");
        }
        if(check){
            this.insertCustomer(customer);
        }
        return mapValidate;
    }

    public boolean validateEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }
    public boolean validatePhone(String phone) {
        return phone.matches(PHONE_REGEX);
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int typeId = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                String gender = resultSet.getString("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                int typeId = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customers.add(new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL)) {
            statement.setInt(1, id);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL)) {
            statement.setInt(1, customer.getTypeId());
            statement.setString(2, customer.getName());
            statement.setString(3, customer.getBirthday());
            statement.setInt(4, Integer.parseInt(customer.getGender()));
            statement.setString(5, customer.getIdCard());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAddress());
            statement.setInt(9, customer.getId());

            rowUpdated = statement.executeUpdate() > 0;

        }
        return rowUpdated;
    }

    @Override
    public List<Customer> searchCustomerByName(String name) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMERS_BY_NAME)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                int typeId = rs.getInt("customer_type_id");
                String name2 = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customers.add(new Customer(id, typeId, name2, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }


    public List<Customer> searchCustomerByNameAndGender(String name, String gender2) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMERS_BY_NAME_AND_GENDER)) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setInt(2, Integer.parseInt(gender2));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                int typeId = rs.getInt("customer_type_id");
                String name2 = rs.getString("customer_name");
                String birthday = rs.getString("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customers.add(new Customer(id, typeId, name2, birthday, gender, idCard, phone, email, address));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }


    @Override
    public List<Customer> sort() throws SQLException {
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
