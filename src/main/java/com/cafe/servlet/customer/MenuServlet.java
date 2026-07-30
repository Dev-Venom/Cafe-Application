package com.cafe.servlet.customer;

import java.io.IOException;
import java.util.List;

import com.cafe.DAO.ProductDAO;
import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.Product;
import com.cafe.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() {

        productDAO = new ProductDAOImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null ||
           session.getAttribute("loggedInUser") == null) {

            response.sendRedirect(
                    request.getContextPath()
                    +"/jsp/auth/login.jsp");

            return;

        }

        List<Product> products =
                productDAO.getAllProducts();

        request.setAttribute("products", products);

        request.getRequestDispatcher(
                "/jsp/customer/menu.jsp")
                .forward(request,response);

    }

}