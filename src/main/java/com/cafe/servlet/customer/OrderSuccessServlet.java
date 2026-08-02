package com.cafe.servlet.customer;

import java.io.IOException;

import com.cafe.DAO.OrdersDAO;
import com.cafe.DAOImpl.OrdersDAOImpl;
import com.cafe.Model.Orders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/order-success")
public class OrderSuccessServlet extends HttpServlet {

    private OrdersDAO ordersDAO;

    @Override
    public void init() {

        ordersDAO = new OrdersDAOImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String orderIdParam = request.getParameter("orderId");

        if (orderIdParam == null) {

            response.sendRedirect(
                    request.getContextPath() + "/home");

            return;
        }

        int orderId = Integer.parseInt(orderIdParam);

        Orders order = ordersDAO.getOrder(orderId);

        if (order == null) {

            response.sendRedirect(
                    request.getContextPath() + "/home");

            return;
        }

        request.setAttribute("order", order);

        request.getRequestDispatcher(
                "/pages/customer/order-success.jsp")
                .forward(request, response);

    }

}