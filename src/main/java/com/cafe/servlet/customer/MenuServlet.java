package com.cafe.servlet.customer;

import java.io.IOException;
import java.util.List;

import com.cafe.DAO.ProductDAO;
import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.Product;
import com.cafe.DAO.CategoryDAO;
import com.cafe.DAOImpl.CategoryDAOImpl;
import com.cafe.Model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;

    @Override
    public void init() {

    	productDAO = new ProductDAOImpl();
    	categoryDAO = new CategoryDAOImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> products = productDAO.getAllProducts();
        List<Category> categories = categoryDAO.getAllCategories();

        System.out.println("Products Loaded: " + products.size());
        System.out.println("Categories Loaded: " + categories.size());

        request.setAttribute("products", products);
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/pages/menu/menu.jsp")
               .forward(request, response);
    }
}