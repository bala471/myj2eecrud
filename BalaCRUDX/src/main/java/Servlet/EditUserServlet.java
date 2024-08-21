package Servlet;

import DAO.UserDao;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EditUserServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setCountry(country);

        UserDao.update(user);
        response.sendRedirect("list");
    }
}
