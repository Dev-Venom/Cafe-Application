package com.cafe.servlet.customer;

import java.io.IOException;
import java.util.List;

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

        String id = request.getParameter("productId");

        if(id == null){

            response.sendRedirect(
                    request.getContextPath()+"/menu");

            return;
        }

        int productId = Integer.parseInt(id);

        Product product = productDAO.getProduct(productId);

        System.out.println("Product ID = " + productId);
        System.out.println("Product = " + product);

        if(product == null){

            response.sendRedirect(
                    request.getContextPath()+"/menu");

            return;
        }
        
        List<Product> relatedProducts =
                productDAO.getProductsByCategory(
                        product.getCategoryId(),
                        product.getProductId());

        request.setAttribute("product", product);
        request.setAttribute("relatedProducts", relatedProducts);

        request.getRequestDispatcher(
                "/pages/menu/product-details.jsp")
                .forward(request, response);

    }

}