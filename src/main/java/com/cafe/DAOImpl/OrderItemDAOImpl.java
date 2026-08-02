package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cafe.DAO.OrderItemDAO;
import com.cafe.Model.OrderItem;
import com.cafe.utility.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO order_item(orderId, productId, quantity, itemTotal) VALUES(?,?,?,?)";

    private static final String GET_QUERY =
            "SELECT * FROM order_item WHERE orderItemId=?";

    private static final String GET_BY_ORDER_QUERY =
            "SELECT * FROM order_item WHERE orderId=?";

    private static final String GET_ALL_QUERY =
            "SELECT * FROM order_item";

    private static final String UPDATE_QUERY =
            "UPDATE order_item SET quantity=?, itemTotal=? WHERE orderItemId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM order_item WHERE orderItemId=?";

    @Override
    public boolean addOrderItem(OrderItem item) {

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

            pstmt.setInt(1, item.getOrderId());
            pstmt.setInt(2, item.getProductId());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setDouble(4, item.getItemTotal());

            return pstmt.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public OrderItem getOrderItem(int orderItemId) {

        OrderItem item = null;

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_QUERY)) {

            pstmt.setInt(1, orderItemId);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {

                item = new OrderItem();

                item.setOrderItemId(rs.getInt("orderItemId"));
                item.setOrderId(rs.getInt("orderId"));
                item.setProductId(rs.getInt("productId"));
                item.setQuantity(rs.getInt("quantity"));
                item.setItemTotal(rs.getDouble("itemTotal"));

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return item;
    }

    @Override
    public List<OrderItem> getOrderItemsByOrder(int orderId) {

        List<OrderItem> list = new ArrayList<>();

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_BY_ORDER_QUERY)) {

            pstmt.setInt(1, orderId);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {

                OrderItem item = new OrderItem();

                item.setOrderItemId(rs.getInt("orderItemId"));
                item.setOrderId(rs.getInt("orderId"));
                item.setProductId(rs.getInt("productId"));
                item.setQuantity(rs.getInt("quantity"));
                item.setItemTotal(rs.getDouble("itemTotal"));

                list.add(item);

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return list;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {

        List<OrderItem> list = new ArrayList<>();

        try(Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_QUERY)) {

            while(rs.next()) {

                OrderItem item = new OrderItem();

                item.setOrderItemId(rs.getInt("orderItemId"));
                item.setOrderId(rs.getInt("orderId"));
                item.setProductId(rs.getInt("productId"));
                item.setQuantity(rs.getInt("quantity"));
                item.setItemTotal(rs.getDouble("itemTotal"));

                list.add(item);

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return list;
    }

    @Override
    public boolean updateOrderItem(OrderItem item) {

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

            pstmt.setInt(1, item.getQuantity());
            pstmt.setDouble(2, item.getItemTotal());
            pstmt.setInt(3, item.getOrderItemId());

            return pstmt.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean deleteOrderItem(int orderItemId) {

        try(Connection con = DBConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

            pstmt.setInt(1, orderItemId);

            return pstmt.executeUpdate() > 0;

        } catch(Exception e) {

            e.printStackTrace();

        }

        return false;
    }

}