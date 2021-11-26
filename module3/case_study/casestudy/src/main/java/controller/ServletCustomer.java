package controller;

import dao.customer.CustomerDAO;
import dao.customer.CustomerTypeDAO;
import model.customer.Customer;
import model.customer.CustomerType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletCustomer", urlPatterns = {"/customers"})
public class ServletCustomer extends HttpServlet {
    private static final long serialVersionUID = 3L;
    private CustomerDAO customerDAO;
    private CustomerTypeDAO customerTypeDAO;

    public void init() {
        customerDAO = new CustomerDAO();
        customerTypeDAO = new CustomerTypeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createCustomer":
                    insertCustomerWithoutValidate(request, response);
                    break;
                case "editCustomer":
                    updateCustomer(request, response);
                    break;
                case "deleteCustomer":
                    deleteCustomer(request, response);
                    break;
                case "searchCustomer":
//                    searchByCountry(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void insertCustomerWithoutValidate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerTypeId, name, birthday, gender, idCard, phone, email, address);
        boolean check = customerDAO.insertCustomer(customer);
        if (check) {
            request.setAttribute("mess", "Insert thanh cong");

        } else {
            request.setAttribute("mess", "Insert KHONG thanh cong");
        }
        List<Customer> customerList = customerDAO.selectAllCustomers();
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/listCustomer.jsp");
        dispatcher.forward(request, response);
    }
    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customerTypeId, name, birthday, gender, idCard, phone, email, address);
//        boolean check = customerDAO.insertCustomer(customer);
//        if (check) {
//            request.setAttribute("mess", "Insert thanh cong");
//
//        } else {
//            request.setAttribute("mess", "Insert KHONG thanh cong");
//        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/listCustomer.jsp");
        RequestDispatcher dispatcher2 = request.getRequestDispatcher("/view/customer/createCustomerValidate.jsp");
        Map<String,String> mapValidateCustomer=customerDAO.insertCustomer2(customer);
        List<Customer> customerList = customerDAO.selectAllCustomers();
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
        if(mapValidateCustomer.isEmpty()){
            request.setAttribute("customerList", customerList);
            request.setAttribute("customerTypeList", customerTypeList);
            dispatcher.forward(request, response);
        }else {
            request.setAttribute("emailMess",mapValidateCustomer.get("emailMess"));
            request.setAttribute("oldCustomer",customer);
            request.setAttribute("customerList", customerList);
            request.setAttribute("customerTypeList", customerTypeList);
            dispatcher2.forward(request,response);
        }
//        List<Customer> customerList = customerDAO.selectAllCustomers();
//        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
//        request.setAttribute("customerList", customerList);
//        request.setAttribute("customerTypeList", customerTypeList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/listCustomer.jsp");
//        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id,customerTypeId,name,birthday,gender,idCard,phone,email,address);
        boolean check = customerDAO.updateCustomer(customer);
        if (check) {
            request.setAttribute("mess", "Update thanh cong");

        } else {
            request.setAttribute("mess", "Update KHONG thanh cong");
        }
        List<Customer> customerList = customerDAO.selectAllCustomers();
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/listCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("delete id: "+id);
        boolean check = customerDAO.deleteCustomer(id);
        if (check) {
            request.setAttribute("mess", "Delete thanh cong");

        } else {
            request.setAttribute("mess", "Delete KHONG thanh cong");
        }
        List<Customer> customerList = customerDAO.selectAllCustomers();
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/listCustomer.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "createCustomer":
                    showCreateCustomerForm(request, response);
                    break;
                case "editCustomer":
                    showEditCustomerForm(request, response);
                    break;
                case "deleteCustomer":
                    showDeleteCustomerForm(request, response);
                    break;
                case "searchCustomerByNameAndGender":
                    searchCustomerByNameAndGender(request, response);
                case "sortCustomer":
//                    sortCustomerByName(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showCreateCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/createCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("edit");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerDAO.selectCustomer(id);
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();

        request.setAttribute("customer", existingCustomer);
        request.setAttribute("customerTypeList", customerTypeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/editCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteCustomerForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("delete");
        int id= Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerDAO.selectCustomer(id);
        request.setAttribute("customer", existingCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/deleteCustomer.jsp");
        dispatcher.forward(request, response);
    }

//    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        String name=request.getParameter("customerName");
//        List<Customer> customerList=customerDAO.searchCustomerByName(name);
//        if (!customerList.isEmpty()) {
//            request.setAttribute("mess", "Search thanh cong");
//
//        } else {
//            request.setAttribute("mess", "Khong co ket qua nao");
//        }
//        request.setAttribute("customerList",customerList);
//        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
//        request.setAttribute("customerTypeList", customerTypeList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/searchCustomerByName.jsp");
//        dispatcher.forward(request, response);
//        System.out.println("searchCustomerByCountry with country: "+name);
//    }
    private void searchCustomerByNameAndGender(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("Name: "+request.getParameter("customerName"));
        System.out.println("Gender: "+request.getParameter("customerGender"));
        String name=request.getParameter("customerName");
        String gender=request.getParameter("customerGender");
        List<Customer> customerList=new ArrayList<>();
        if(name==""&&gender!="2"){
             customerList=customerDAO.searchCustomerByNameAndGender(name,gender);
        }else if(name!=""&&gender.equals("2")){
            customerList=customerDAO.searchCustomerByName(name);
        }else if(name!=""&&gender!="2"){
            customerList=customerDAO.searchCustomerByNameAndGender(name,gender);
        }
        if (!customerList.isEmpty()) {
            request.setAttribute("mess", "Search thanh cong");

        } else {
            request.setAttribute("mess", "Khong co ket qua nao");
        }
        request.setAttribute("customerList",customerList);
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/searchCustomerByName.jsp");
        dispatcher.forward(request, response);
        System.out.println("searchCustomerByCountry with country: "+name);
    }
    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> customerList = customerDAO.selectAllCustomers();
        List<CustomerType> customerTypeList = customerTypeDAO.selectAllCustomersType();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/customer/listCustomer.jsp");
        dispatcher.forward(request, response);
    }
}
