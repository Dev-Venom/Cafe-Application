package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.Orders;

public interface OrdersDAO {

	boolean addOrder(Orders order);

	Orders getOrder(int orderId);

	List<Orders> getOrdersByUserId(int userId);

	List<Orders> getAllOrders();

	boolean updateOrder(Orders order);

	boolean deleteOrder(int orderId);
}