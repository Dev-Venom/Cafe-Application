package com.cafe.servlet.customer;

import java.io.IOException;

import com.cafe.DAO.CartDAO;
import com.cafe.DAO.CartItemDAO;
import com.cafe.DAO.ProductDAO;
import com.cafe.DAOImpl.CartDAOImpl;
import com.cafe.DAOImpl.CartItemDAOImpl;
import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.Cart;
import com.cafe.Model.CartItem;
import com.cafe.Model.Product;
import com.cafe.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart/add")
public class AddToCartServlet extends HttpServlet {

    private CartDAO cartDAO;
    private CartItemDAO cartItemDAO;
    private ProductDAO productDAO;

    @Override
    public void init() {

        cartDAO = new CartDAOImpl();
        cartItemDAO = new CartItemDAOImpl();
        productDAO = new ProductDAOImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session = request.getSession(false);

    	if (session == null || session.getAttribute("loggedInUser") == null) {

    	    response.sendRedirect(
    	            request.getContextPath() + "/login");

    	    return;
    	}

    	User user = (User) session.getAttribute("loggedInUser");

        int userId = user.getUserId();

        int productId =
                Integer.parseInt(request.getParameter("productId"));

        Product product =
                productDAO.getProduct(productId);

        if (product == null) {

            response.sendRedirect(
                    request.getContextPath() + "/menu");

            return;
        }

        Cart cart =
                cartDAO.getCartByUserId(userId);

     
        if (cart == null) {

            cart = new Cart();

            cart.setUserId(userId);

            cartDAO.addCart(cart);

            cart = cartDAO.getCartByUserId(userId);
        }

        // Check whether the product already exists in the cart
        CartItem cartItem =
                cartItemDAO.getCartItemByCartAndProduct(
                        cart.getCartId(),
                        productId);

        if (cartItem != null) {

            int newQuantity =
                    cartItem.getQuantity() + 1;

            cartItem.setQuantity(newQuantity);

            cartItem.setItemTotal(
                    newQuantity * product.getPrice());

            cartItemDAO.updateCartItem(cartItem);

        } else {

            CartItem newItem = new CartItem();

            newItem.setCartId(cart.getCartId());

            newItem.setProductId(productId);

            newItem.setQuantity(1);

            newItem.setItemTotal(product.getPrice());

            cartItemDAO.addCartItem(newItem);

        }

        
        response.sendRedirect(
                request.getContextPath() + "/cart");
    }

}