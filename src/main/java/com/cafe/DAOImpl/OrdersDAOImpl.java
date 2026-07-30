package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cafe.DAO.OrdersDAO;
import com.cafe.Model.Orders;
import com.cafe.utility.DBConnection;

public class OrdersDAOImpl implements OrdersDAO {

	private static final String INSERT_QUERY = "INSERT INTO orders(userId, addressId, totalAmount, paymentMethod, orderStatus) VALUES(?,?,?,?,?)";

	private static final String GET_QUERY = "SELECT * FROM orders WHERE orderId=?";

	private static final String GET_BY_USER_QUERY = "SELECT * FROM orders WHERE userId=?";

	private static final String GET_ALL_QUERY = "SELECT * FROM orders";

	private static final String UPDATE_QUERY = "UPDATE orders SET userId=?, addressId=?, totalAmount=?, paymentMethod=?, orderStatus=? WHERE orderId=?";

	private static final String DELETE_QUERY = "DELETE FROM orders WHERE orderId=?";

	@Override
	public boolean addOrder(Orders order) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getAddressId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getPaymentMethod());
			pstmt.setString(5, order.getOrderStatus());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Orders getOrder(int orderId) {

		Orders order = null;

		try (Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_QUERY)) {

			pstmt.setInt(1, orderId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				order = new Orders();

				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setAddressId(rs.getInt("addressId"));
				order.setTotalAmount(rs.getDouble("totalAmount"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				order.setOrderStatus(rs.getString("orderStatus"));

				Timestamp ts = rs.getTimestamp("orderDate");
				if (ts != null) {
					order.setOrderDate(ts.toLocalDateTime());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;
	}

	@Override
	public List<Orders> getOrdersByUserId(int userId) {

		List<Orders> orders = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_BY_USER_QUERY)) {

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Orders order = new Orders();

				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setAddressId(rs.getInt("addressId"));
				order.setTotalAmount(rs.getDouble("totalAmount"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				order.setOrderStatus(rs.getString("orderStatus"));

				Timestamp ts = rs.getTimestamp("orderDate");
				if (ts != null) {
					order.setOrderDate(ts.toLocalDateTime());
				}

				orders.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public List<Orders> getAllOrders() {

		List<Orders> orders = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL_QUERY)) {

			while (rs.next()) {

				Orders order = new Orders();

				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setAddressId(rs.getInt("addressId"));
				order.setTotalAmount(rs.getDouble("totalAmount"));
				order.setPaymentMethod(rs.getString("paymentMethod"));
				order.setOrderStatus(rs.getString("orderStatus"));

				Timestamp ts = rs.getTimestamp("orderDate");
				if (ts != null) {
					order.setOrderDate(ts.toLocalDateTime());
				}

				orders.add(order);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public boolean updateOrder(Orders order) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getAddressId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getPaymentMethod());
			pstmt.setString(5, order.getOrderStatus());
			pstmt.setInt(6, order.getOrderId());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteOrder(int orderId) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

			pstmt.setInt(1, orderId);

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}