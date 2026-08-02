package com.cafe.servlet.customer;

import java.io.IOException;

import com.cafe.DAO.CartItemDAO;
import com.cafe.DAOImpl.CartItemDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/cart/remove")
public class RemoveCartItemServlet extends HttpServlet {
	
	
	private CartItemDAO cartItemDAO;

	@Override
	public void init() {

	    cartItemDAO = new CartItemDAOImpl();

	}

	@Override
	protected void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	        throws ServletException, IOException {

	    System.out.println("===== RemoveCartItemServlet =====");

	    String id = request.getParameter("cartItemId");

	    System.out.println("ID = " + id);

	    if (id == null) {

	        response.sendRedirect(request.getContextPath() + "/cart");
	        return;
	    }

	    int cartItemId = Integer.parseInt(id);

	    System.out.println("Deleting Cart Item : " + cartItemId);

	    boolean deleted = cartItemDAO.deleteCartItem(cartItemId);

	    System.out.println("Deleted = " + deleted);

	    response.sendRedirect(request.getContextPath() + "/cart");
	}
    
    

}

