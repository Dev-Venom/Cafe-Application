package com.cafe.filter;

import java.io.IOException;

import com.cafe.DAO.CartDAO;
import com.cafe.DAO.CartItemDAO;
import com.cafe.DAOImpl.CartDAOImpl;
import com.cafe.DAOImpl.CartItemDAOImpl;
import com.cafe.Model.Cart;
import com.cafe.Model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(
    urlPatterns = {
        "/home",
        "/cart",
        "/checkout",
        "/orders",
        "/profile"
    }
)
public class AuthenticationFilter extends HttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;

        HttpSession session =
                req.getSession(false);

        User loggedInUser = null;

        if(session != null) {

            loggedInUser =
                (User) session.getAttribute("loggedInUser");

        }
        
        if (loggedInUser != null) {

            CartDAO cartDAO = new CartDAOImpl();
            CartItemDAO cartItemDAO = new CartItemDAOImpl();

            Cart cart = cartDAO.getCartByUserId(loggedInUser.getUserId());

            int cartCount = 0;

            if (cart != null) {

                cartCount = cartItemDAO.getCartItemCount(cart.getCartId());

            }

            request.setAttribute("cartCount", cartCount);

        }

        if(loggedInUser == null) {

            res.sendRedirect(
                req.getContextPath()
                + "/pages/auth/login.jsp");

            return;

        }

        chain.doFilter(request, response);

    }

}