package com.cafe.servlet.customer;

import java.io.IOException;
import java.util.List;

import com.cafe.DAO.CategoryDAO;
import com.cafe.DAO.ProductDAO;
import com.cafe.DAOImpl.CategoryDAOImpl;
import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.Category;
import com.cafe.Model.Product;
import com.cafe.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private CategoryDAO categoryDAO;
    
    private ProductDAO productDAO;

    @Override
    public void init() {

        categoryDAO = new CategoryDAOImpl();
     
        productDAO = new ProductDAOImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null){

            response.sendRedirect(
                    request.getContextPath()
                    +"/jsp/auth/login.jsp");

            return;

        }

        User user =
                (User)session.getAttribute("loggedInUser");

        if(user == null){

            response.sendRedirect(
                    request.getContextPath()
                    +"/jsp/auth/login.jsp");

            return;

        }

        List<Category> categories =
                categoryDAO.getAllCategories();

        request.setAttribute(
                "categories",
                categories);

        request.getRequestDispatcher(
                "/jsp/customer/home.jsp")
                .forward(request,response);
        
        List<Product> products = productDAO.getAllProducts();

        request.setAttribute("products", products);

    }
    
  

   

}