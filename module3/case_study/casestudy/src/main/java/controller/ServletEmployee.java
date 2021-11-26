package controller;

import dao.employee.*;
import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.*;

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

@WebServlet(name = "ServletEmployee",urlPatterns = {"/employees"})
public class ServletEmployee extends HttpServlet {
    private static final long serialVersionUID = 3L;
    private EmployeeDAO employeeDAO;
    private PositionEmployeeDAO positionEmployeeDAO;
    private EducationDegreeDAO educationDegreeDAO;
    private DivisionDAO divisionDAO;
    private UserDAO userDAO;
    private RoleDAO roleDAO;
    private UserRoleDAO userRoleDAO;
    public void init(){
        employeeDAO=new EmployeeDAO();
        positionEmployeeDAO=new PositionEmployeeDAO();
        educationDegreeDAO=new EducationDegreeDAO();
        divisionDAO=new DivisionDAO();
        userDAO=new UserDAO();
        roleDAO=new RoleDAO();
        userRoleDAO=new UserRoleDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createEmployee":
                    insertEmployee(request, response);
                    break;
                case "editEmployee":
                    updateEmployee(request, response);
                    break;
                case "deleteEmployee":
                    deleteEmployee(request, response);
                    break;
                case "searchEmployee":
//                    searchByCountry(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId= Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId= Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId= Integer.parseInt(request.getParameter("divisionId"));
        String userName = request.getParameter("userName");
        int  role = Integer.parseInt(request.getParameter("roleId"));
        User user=new User(userName,"123123");
        UserRole userRole=new UserRole(role,userName);
        Employee employee= new Employee(name,birthday,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId,userName);
        boolean check = employeeDAO.insertEmployee(employee,user,userRole);
        if (check) {
            request.setAttribute("mess", "Insert thanh cong");

        } else {
            request.setAttribute("mess", "Insert KHONG thanh cong");
        }
        List<Employee> employeeList=employeeDAO.selectAllEmployees();
        List<PositionEmployee> positionEmployeeList=positionEmployeeDAO.selectAllPositionEmployees();
        List<EducationDegree> educationDegreeList=educationDegreeDAO.selectAllEducationDegrees();
        List<Division> divisionList=divisionDAO.selectAllDivisions();

        request.setAttribute("employeeList",employeeList);
        request.setAttribute("positionEmployeeList",positionEmployeeList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/listEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        Double salary = Double.valueOf(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId= Integer.parseInt(request.getParameter("employeePositionId"));
        int educationDegreeId= Integer.parseInt(request.getParameter("employeeEducationDegreeId"));
        int divisionId= Integer.parseInt(request.getParameter("employeeDivisionId"));
        String userName = request.getParameter("userName");
        int  role = Integer.parseInt(request.getParameter("employeeRoleId"));
        Employee oldEmployee=employeeDAO.selectEmployee(id);
        User user=new User(userName,"123123");
        UserRole userRole=new UserRole(role,userName);
        Employee newEmployee= new Employee(id,name,birthday,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId,userName);
        boolean check = employeeDAO.updateEmployee(oldEmployee,newEmployee,user,userRole);
        if (check) {
            request.setAttribute("mess", "Update thanh cong");

        } else {
            request.setAttribute("mess", "Update KHONG thanh cong");
        }
        List<Employee> employeeList=employeeDAO.selectAllEmployees();
        List<PositionEmployee> positionEmployeeList=positionEmployeeDAO.selectAllPositionEmployees();
        List<EducationDegree> educationDegreeList=educationDegreeDAO.selectAllEducationDegrees();
        List<Division> divisionList=divisionDAO.selectAllDivisions();

        request.setAttribute("employeeList",employeeList);
        request.setAttribute("positionEmployeeList",positionEmployeeList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/listEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("delete :"+id);
        Employee employee=employeeDAO.selectEmployee(id);
        String userName=employee.getEmployeeUserName();
        boolean check = employeeDAO.deleteEmployee(id,userName);
        if (check) {
            request.setAttribute("mess", "Delete thanh cong");

        } else {
            request.setAttribute("mess", "Delete KHONG thanh cong");
        }
        List<Employee> employeeList=employeeDAO.selectAllEmployees();
        List<PositionEmployee> positionEmployeeList=positionEmployeeDAO.selectAllPositionEmployees();
        List<EducationDegree> educationDegreeList=educationDegreeDAO.selectAllEducationDegrees();
        List<Division> divisionList=divisionDAO.selectAllDivisions();
        List<User> userList=userDAO.selectAllUsers();
        List<Role> roleList=roleDAO.selectAllRoles();
        List<UserRole> userRoles=userRoleDAO.selectAllUserRoles();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("positionEmployeeList",positionEmployeeList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("userList",userList);
        request.setAttribute("roleList",roleList);
        request.setAttribute("userRoles",userRoles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/listEmployee.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "createEmployee":
                    showCreateEmployeeForm(request, response);
                    break;
                case "editEmployee":
                    showEditEmployeeForm(request, response);
                    break;
                case "deleteEmployee":
                    showDeleteEmployeeForm(request, response);

                    break;
                case "sortEmployee":
//                    sortEmployeeByName(request, response);
                    break;
                case "searchEmployeeByCountryAndName":
                    searchEmployeeByCountryAndName(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showCreateEmployeeForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        List<PositionEmployee> positionEmployeeList=positionEmployeeDAO.selectAllPositionEmployees();
        List<EducationDegree> educationDegreeList=educationDegreeDAO.selectAllEducationDegrees();
        List<Division> divisionList=divisionDAO.selectAllDivisions();
        List<User> userList=userDAO.selectAllUsers();
        List<Role> roleList=roleDAO.selectAllRoles();
        List<UserRole> userRoles=userRoleDAO.selectAllUserRoles();
        request.setAttribute("positionEmployeeList",positionEmployeeList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("userList",userList);
        request.setAttribute("roleList",roleList);
        request.setAttribute("userRoles",userRoles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/createEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println("edit: "+id);
        Employee employee=employeeDAO.selectEmployee(id);
        List<PositionEmployee> positionEmployeeList=positionEmployeeDAO.selectAllPositionEmployees();
        List<EducationDegree> educationDegreeList=educationDegreeDAO.selectAllEducationDegrees();
        List<Division> divisionList=divisionDAO.selectAllDivisions();
        List<User> userList=userDAO.selectAllUsers();
        List<Role> roleList=roleDAO.selectAllRoles();
        List<UserRole> userRoleList=userRoleDAO.selectAllUserRoles();
        request.setAttribute("employee",employee);
        request.setAttribute("positionEmployeeList",positionEmployeeList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("userList",userList);
        request.setAttribute("roleList",roleList);
        request.setAttribute("userRoleList",userRoleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/editEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteEmployeeForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println("delete "+id);
        Employee existingEmployee=employeeDAO.selectEmployee(id);
        request.setAttribute("employee",existingEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/deleteEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void searchEmployeeByCountryAndName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        String name=request.getParameter("employeeName");
        String country=request.getParameter("employeeCountry");
        System.out.println(name+country);
        List<Employee> employeeList=new ArrayList<>();
        if(name!=""&&country.equals("")){
            employeeList=employeeDAO.searchEmployeeByName(name);
        }else if (name!=""&&country!=""){
            employeeList=employeeDAO.searchEmployeeByCountryAndName(country,name);
        }else if(name.equals("")&&country!=""){
            employeeList=employeeDAO.searchEmployeeByCountryAndName(country,name);
        }
        if (!employeeList.isEmpty()) {
            request.setAttribute("mess", "Search thanh cong");

        } else {
            request.setAttribute("mess", "Khong co ket qua nao");
        }
        request.setAttribute("employeeList",employeeList);
        List<PositionEmployee> positionEmployeeList=positionEmployeeDAO.selectAllPositionEmployees();
        List<EducationDegree> educationDegreeList=educationDegreeDAO.selectAllEducationDegrees();
        List<Division> divisionList=divisionDAO.selectAllDivisions();
        List<User> userList=userDAO.selectAllUsers();
        List<Role> roleList=roleDAO.selectAllRoles();
        List<UserRole> userRoles=userRoleDAO.selectAllUserRoles();
        request.setAttribute("positionEmployeeList",positionEmployeeList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("userList",userList);
        request.setAttribute("roleList",roleList);
        request.setAttribute("userRoles",userRoles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/listEmployee.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        List<Employee> employeeList=employeeDAO.selectAllEmployees();
        List<PositionEmployee> positionEmployeeList=positionEmployeeDAO.selectAllPositionEmployees();
        List<EducationDegree> educationDegreeList=educationDegreeDAO.selectAllEducationDegrees();
        List<Division> divisionList=divisionDAO.selectAllDivisions();
        List<User> userList=userDAO.selectAllUsers();
        List<Role> roleList=roleDAO.selectAllRoles();
        List<UserRole> userRoles=userRoleDAO.selectAllUserRoles();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("positionEmployeeList",positionEmployeeList);
        request.setAttribute("educationDegreeList",educationDegreeList);
        request.setAttribute("divisionList",divisionList);
        request.setAttribute("userList",userList);
        request.setAttribute("roleList",roleList);
        request.setAttribute("userRoles",userRoles);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/employee/listEmployee.jsp");
        dispatcher.forward(request, response);
    }
}
