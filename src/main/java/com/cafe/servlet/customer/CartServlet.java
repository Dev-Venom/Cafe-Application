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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private CartDAO cartDAO;
    private CartItemDAO cartItemDAO;

    @Override
    public void init() {

        cartDAO = new CartDAOImpl();
        cartItemDAO = new CartItemDAOImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        User user =
                (User)session.getAttribute("loggedInUser");

        Cart cart =
                cartDAO.getCartByUserId(
                        user.getUserId());

        List<CartItemDetails> cartItems =
                cartItemDAO.getCartItemsWithProductDetails(cart.getCartId());

        request.setAttribute(
                "cartItems",
                cartItems);

        request.getRequestDispatcher(
                "/jsp/customer/cart.jsp")
                .forward(request,response);

    }

}