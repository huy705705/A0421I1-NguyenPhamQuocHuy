package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletUser",urlPatterns = {"/users"})
public class ServletUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "search":
                    searchByCountry(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{

        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User newUser=new User(name,email,country);
        userDAO.insertUser(newUser);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/create.jsp");
        dispatcher.forward(request,response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String country=request.getParameter("country");
        User book=new User(id,name,email,country);
        userDAO.updateUser(book);
        RequestDispatcher dispatcher=request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request,response);

    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        String country=request.getParameter("country");
        List<User> listSearchUser=userDAO.search(country);
        request.setAttribute("listSearchUser",listSearchUser);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/search.jsp");
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "sort":
                    sortByName(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("id"));
        User existingUser=userDAO.selectUser(id);
        request.setAttribute("user",existingUser);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        int id=Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        List<User> listUser=userDAO.selectAllUsers();
        request.setAttribute("listUser",listUser);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request,response);
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        List<User> listSortUser=userDAO.sort();
        request.setAttribute("listSortUser",listSortUser);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/sort.jsp");
        dispatcher.forward(request,response);
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser=userDAO.selectAllUsers();
        request.setAttribute("listUser",listUser);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/list.jsp");
        dispatcher.forward(request,response);
    }

}