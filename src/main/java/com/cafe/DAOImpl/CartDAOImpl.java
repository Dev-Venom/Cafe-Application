package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cafe.DAO.CartDAO;
import com.cafe.Model.Cart;
import com.cafe.utility.DBConnection;

public class CartDAOImpl implements CartDAO {

	private static final String INSERT_QUERY = "INSERT INTO cart(userId) VALUES(?)";

	private static final String GET_QUERY = "SELECT * FROM cart WHERE cartId=?";

	private static final String GET_BY_USER_QUERY = "SELECT * FROM cart WHERE userId=?";

	private static final String GET_ALL_QUERY = "SELECT * FROM cart";

	private static final String UPDATE_QUERY = "UPDATE cart SET userId=? WHERE cartId=?";

	private static final String DELETE_QUERY = "DELETE FROM cart WHERE cartId=?";

	@Override
	public boolean addCart(Cart cart) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

			pstmt.setInt(1, cart.getUserId());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Cart getCart(int cartId) {

		Cart cart = null;

		try (Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_QUERY)) {

			pstmt.setInt(1, cartId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				cart = new Cart();

				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(rs.getInt("userId"));

				Timestamp ts = rs.getTimestamp("createdAt");
				if (ts != null) {
					cart.setCreatedAt(ts.toLocalDateTime());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cart;
	}

	@Override
	public Cart getCartByUserId(int userId) {

		Cart cart = null;

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_BY_USER_QUERY)) {

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				cart = new Cart();

				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(rs.getInt("userId"));

				Timestamp ts = rs.getTimestamp("createdAt");
				if (ts != null) {
					cart.setCreatedAt(ts.toLocalDateTime());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cart;
	}

	@Override
	public List<Cart> getAllCarts() {

		List<Cart> carts = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL_QUERY)) {

			while (rs.next()) {

				Cart cart = new Cart();

				cart.setCartId(rs.getInt("cartId"));
				cart.setUserId(rs.getInt("userId"));

				Timestamp ts = rs.getTimestamp("createdAt");
				if (ts != null) {
					cart.setCreatedAt(ts.toLocalDateTime());
				}

				carts.add(cart);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return carts;
	}

	@Override
	public boolean updateCart(Cart cart) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getCartId());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteCart(int cartId) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

			pstmt.setInt(1, cartId);

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean isCartExists(int userId) {
		
		return false;
	}
}