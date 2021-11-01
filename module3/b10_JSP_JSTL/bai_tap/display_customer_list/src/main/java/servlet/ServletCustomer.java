package servlet;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletCustomer", value = {"/list"})
public class ServletCustomer extends HttpServlet {
    List<Customer> customerList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        customerList.add(new Customer("Nguyen Pham Huy", "20/10/2000", "Viet Nam", "asd"));
        customerList.add(new Customer("Nguyen Toan", "6/5/2000", "Viet Nam", "axcv"));
        customerList.add(new Customer("Nguyen Quy", "1/2/2000", "Viet Nam", "rty"));
        customerList.add(new Customer("Nguyen Binh", "23/1/2000", "Viet Nam", "fgh"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/home.jsp");
        requestDispatcher.forward(request, response);
    }
}
