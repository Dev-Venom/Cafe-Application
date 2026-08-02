package com.cafe.servlet.customer;

import java.io.IOException;
import java.util.List;

import com.cafe.DAO.AddressDAO;
import com.cafe.DAO.CartDAO;
import com.cafe.DAO.CartItemDAO;
import com.cafe.DAO.OrderItemDAO;
import com.cafe.DAO.OrdersDAO;
import com.cafe.DAO.ProductDAO;
import com.cafe.DAOImpl.AddressDAOImpl;
import com.cafe.DAOImpl.CartDAOImpl;
import com.cafe.DAOImpl.CartItemDAOImpl;
import com.cafe.DAOImpl.OrderItemDAOImpl;
import com.cafe.DAOImpl.OrdersDAOImpl;
import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.Cart;
import com.cafe.Model.CartItem;
import com.cafe.Model.OrderItem;
import com.cafe.Model.Orders;
import com.cafe.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/place-order")
public class PlaceOrderServlet extends HttpServlet {
	
	private OrdersDAO ordersDAO;
	private OrderItemDAO orderItemDAO;
	private CartDAO cartDAO;
	private CartItemDAO cartItemDAO;
	private ProductDAO productDAO;
	private AddressDAO addressDAO;
	
	@Override
	public void init() {

	    ordersDAO = new OrdersDAOImpl();
	    orderItemDAO = new OrderItemDAOImpl();

	    cartDAO = new CartDAOImpl();
	    cartItemDAO = new CartItemDAOImpl();

	    productDAO = new ProductDAOImpl();
	    addressDAO = new AddressDAOImpl();

	}

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
    	
    	HttpSession session = request.getSession(false);

    	if(session == null){

    	    response.sendRedirect(request.getContextPath()+"/login");

    	    return;
    	}

    	User user =
    	(User)session.getAttribute("loggedInUser");

    	if(user == null){

    	    response.sendRedirect(request.getContextPath()+"/login");

    	    return;
    	}
    	
    	String paymentMethod =
    			request.getParameter("paymentMethod");

    			String addressIdParam =
    			request.getParameter("addressId");

    			if(paymentMethod == null || addressIdParam == null){

    			    response.sendRedirect(request.getContextPath()+"/checkout");

    			    return;
    			}

    			int addressId =
    			Integer.parseInt(addressIdParam);
    			
    			Cart cart =
    					cartDAO.getCartByUserId(user.getUserId());

    					if(cart == null){

    					    response.sendRedirect(request.getContextPath()+"/cart");

    					    return;
    					}
    					
    					List<CartItem> cartItems =
    							cartItemDAO.getCartItemsByCartId(cart.getCartId());

    							if(cartItems.isEmpty()){

    							    response.sendRedirect(request.getContextPath()+"/cart");

    							    return;
    							}
    							
    							double totalAmount = 0.0;

    							for (CartItem item : cartItems) {

    							    totalAmount += item.getItemTotal();

    							}
    							
    							Orders order = new Orders();

    							order.setUserId(user.getUserId());
    							order.setAddressId(addressId);
    							order.setTotalAmount(totalAmount);
    							order.setPaymentMethod(paymentMethod);
    							order.setOrderStatus("PENDING");
    							
    							int orderId = ordersDAO.addOrder(order);

    							if (orderId == -1) {

    							    response.sendRedirect(
    							            request.getContextPath() + "/checkout");

    							    return;
    							}
    							
    							for (CartItem cartItem : cartItems) {

    							    OrderItem orderItem = new OrderItem();

    							    orderItem.setOrderId(orderId);
    							    orderItem.setProductId(cartItem.getProductId());
    							    orderItem.setQuantity(cartItem.getQuantity());
    							    orderItem.setItemTotal(cartItem.getItemTotal());

    							    orderItemDAO.addOrderItem(orderItem);

    							}
    							
    							response.sendRedirect(
    							        request.getContextPath()
    							        + "/order-success?orderId=" + orderId);

    }
    
    
    

}