package com.cafe.servlet.customer;


import java.io.IOException;
import java.util.List;

import com.cafe.DAO.CartDAO;
import com.cafe.DAO.CartItemDAO;
import com.cafe.DAOImpl.CartDAOImpl;
import com.cafe.DAOImpl.CartItemDAOImpl;
import com.cafe.Model.Cart;
import com.cafe.Model.CartItemDetails;
import com.cafe.Model.User;
import com.cafe.DAO.AddressDAO;
import com.cafe.DAOImpl.AddressDAOImpl;
import com.cafe.Model.Address;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private CartDAO cartDAO;
    private CartItemDAO cartItemDAO;
    private AddressDAO addressDAO;

    @Override
    public void init() {

        cartDAO = new CartDAOImpl();
        cartItemDAO = new CartItemDAOImpl();
        addressDAO = new AddressDAOImpl();

    }
    
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
    	
    	User user =
    			(User)request.getSession()
    			             .getAttribute("loggedInUser");

    			if(user == null){

    			    response.sendRedirect(
    			            request.getContextPath() + "/login");

    			    return;
    			}
    			
    			Cart cart = cartDAO.getCartByUserId(user.getUserId());

    			if(cart == null){

    			    response.sendRedirect(
    			            request.getContextPath() + "/cart");

    			    return;
    			}
    			
    			List<CartItemDetails> cartItems =
    			        cartItemDAO.getCartItemDetails(cart.getCartId());
    			
    			double subtotal = 0;

    			for(CartItemDetails item : cartItems){

    			    subtotal += item.getItemTotal();

    			}
    			
    			List<Address> addresses =
    			        addressDAO.getAddressByUser(user.getUserId());

    			request.setAttribute("addresses", addresses);
    			
    			request.setAttribute("cartItems", cartItems);
    			request.setAttribute("subtotal", subtotal);

    			request.getRequestDispatcher(
    			        "/pages/customer/checkout.jsp")
    			        .forward(request, response);

    }

}