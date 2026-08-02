package com.cafe.filter;

import java.io.IOException;

import com.cafe.Model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter implements Filter {

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

        if (session != null) {
            loggedInUser =
                    (User) session.getAttribute("loggedInUser");
        }

        if (loggedInUser == null) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/pages/auth/login.jsp");

            return;
        }

        if (!"ADMIN".equals(loggedInUser.getRole())) {

            res.sendRedirect(
                    req.getContextPath()
                    + "/home");

            return;
        }

        chain.doFilter(request, response);

    }

}