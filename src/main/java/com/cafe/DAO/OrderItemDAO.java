package com.cafe.DAO;

import java.util.List;
import com.cafe.Model.OrderItem;

public interface OrderItemDAO {

    boolean addOrderItem(OrderItem orderItem);

    OrderItem getOrderItem(int orderItemId);

    List<OrderItem> getOrderItemsByOrder(int orderId);

    List<OrderItem> getAllOrderItems();

    boolean updateOrderItem(OrderItem orderItem);

    boolean deleteOrderItem(int orderItemId);

}