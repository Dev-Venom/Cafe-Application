package com.cafe.servlet.customer;

import java.io.IOException;

import com.cafe.DAO.ProductDAO;
import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class ProductDetailsServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() {

        productDAO = new ProductDAOImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int productId =
                Integer.parseInt(
                request.getParameter("id"));

        Product product =
                productDAO.getProduct(productId);

        request.setAttribute("product", product);

        request.getRequestDispatcher(
                "/jsp/customer/product-details.jsp")
                .forward(request,response);

    }

}
