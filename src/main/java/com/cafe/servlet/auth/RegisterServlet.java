package com.cafe.servlet.auth;

import java.io.IOException;

import com.cafe.DAO.UserDAO;
import com.cafe.DAOImpl.CartDAOImpl;
import com.cafe.DAOImpl.UserDAOImpl;
import com.cafe.Model.Cart;
import com.cafe.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {

        userDAO = new UserDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        User user = new User();

        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setRole("CUSTOMER");

        boolean status = userDAO.addUser(user);

        if (status) {
        	
        	User registeredUser = userDAO.getUserByEmail(user.getEmail());

            Cart cart = new Cart();
            cart.setUserId(registeredUser.getUserId());

            CartDAOImpl cartDAOImpl = new CartDAOImpl();
			cartDAOImpl.addCart(cart);

        	response.sendRedirect(
        			request.getContextPath()+"/jsp/auth/login.jsp?success=1");

        } else {

            response.sendRedirect(
                    request.getContextPath() + "/jsp/auth/register.jsp");
        }
    }
    
    
    
}
