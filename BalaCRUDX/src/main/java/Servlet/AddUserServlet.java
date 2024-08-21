package Servlet;

import DAO.UserDao;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddUserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);

        UserDao.save(user);
        response.sendRedirect("list");
    }
}
