package com.cafe.servlet.auth;

import java.io.IOException;

import com.cafe.DAO.UserDAO;
import com.cafe.DAOImpl.UserDAOImpl;
import com.cafe.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {

        userDAO = new UserDAOImpl();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                          

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userDAO.getUserByEmail(email);

        if(user != null &&
                user.getPassword().equals(password)) {
        	
        	System.out.println("Entered Password : " + password);
        	System.out.println("Password Matched");

            HttpSession session = request.getSession();

            session.setAttribute("loggedInUser", user);

            if(user.getRole().equals("ADMIN")) {
            	
            	System.out.println("Admin login");

                response.sendRedirect(
                        request.getContextPath()+"/admin/home");

            }
            else  {
            	
            	System.out.println("Customer login");

                response.sendRedirect(
                        request.getContextPath()+"/home");

            }

        }
        else {

            response.sendRedirect(
                    request.getContextPath()
                    +"/jsp/auth/login.jsp?error=1");

        }

    }

}