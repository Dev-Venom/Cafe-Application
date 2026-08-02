package com.cafe.DAO;

import java.util.List;
import com.cafe.Model.Orders;

public interface OrdersDAO {

    int addOrder(Orders order);

    Orders getOrder(int orderId);

    List<Orders> getOrdersByUser(int userId);

    List<Orders> getAllOrders();

    boolean updateOrder(Orders order);

    boolean deleteOrder(int orderId);

}