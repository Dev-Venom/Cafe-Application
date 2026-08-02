package com.cafe.servlet.customer;

import java.io.IOException;

import com.cafe.DAO.CartItemDAO;
import com.cafe.DAO.ProductDAO;
import com.cafe.DAOImpl.CartItemDAOImpl;
import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.CartItem;
import com.cafe.Model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart/update")
public class UpdateCartQuantityServlet extends HttpServlet {

    private CartItemDAO cartItemDAO;
    private ProductDAO productDAO;

    @Override
    public void init() {

        cartItemDAO = new CartItemDAOImpl();
        productDAO = new ProductDAOImpl();

    }
    
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String cartItemIdParam = request.getParameter("cartItemId");
    	String action = request.getParameter("action");

    	if (cartItemIdParam == null || action == null) {

    	    response.sendRedirect(
    	            request.getContextPath() + "/cart");

    	    return;
    	}

    	int cartItemId = Integer.parseInt(cartItemIdParam);
    	
    	CartItem cartItem = cartItemDAO.getCartItem(cartItemId);

    	if (cartItem == null) {

    	    response.sendRedirect(
    	            request.getContextPath() + "/cart");

    	    return;
    	}
    	
    	Product product = productDAO.getProduct(cartItem.getProductId());

    	int quantity = cartItem.getQuantity();

    	if ("increase".equals(action)) {

    	    if (quantity < product.getStock()) {

    	        quantity++;

    	    }

    	} else if ("decrease".equals(action)) {

    	    quantity--;

    	}

    	if (quantity <= 0) {

    	    cartItemDAO.deleteCartItem(cartItemId);

    	} else {

    	    cartItem.setQuantity(quantity);
    	    cartItem.setItemTotal(quantity * product.getPrice());

    	    cartItemDAO.updateCartItem(cartItem);

    	}

    	response.sendRedirect(
    	        request.getContextPath() + "/cart");

    }
    
    

}
