package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cafe.DAO.CartItemDAO;
import com.cafe.Model.CartItem;
import com.cafe.Model.CartItemDetails;
import com.cafe.utility.DBConnection;

public class CartItemDAOImpl implements CartItemDAO {

	private static final String INSERT_QUERY = "INSERT INTO cart_item(cartId, productId, quantity, itemTotal) VALUES(?,?,?,?)";

	private static final String GET_QUERY = "SELECT * FROM cart_item WHERE cartItemId=?";

	private static final String GET_BY_CART_QUERY = "SELECT * FROM cart_item WHERE cartId=?";

	private static final String GET_ALL_QUERY = "SELECT * FROM cart_item";

	private static final String UPDATE_QUERY = "UPDATE cart_item SET cartId=?, productId=?, quantity=?, itemTotal=? WHERE cartItemId=?";

	private static final String DELETE_QUERY = "DELETE FROM cart_item WHERE cartItemId=?";

	private static final String CLEAR_CART_QUERY = "DELETE FROM cart_item WHERE cartId=?";

	private static final String GET_BY_CART_PRODUCT_QUERY =
	        "SELECT * FROM cart_item WHERE cartId=? AND productId=?";
	
	private static final String GET_CART_ITEMS_WITH_PRODUCTS =
			"SELECT ci.cartItemId, p.productId, p.productName, p.image, p.price, ci.quantity, ci.itemTotal "
			+ "FROM cart_item ci "
			+ "INNER JOIN product p "
			+ "ON ci.productId = p.productId "
			+ "WHERE ci.cartId=?";
	
	@Override
	public boolean addCartItem(CartItem cartItem) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

			pstmt.setInt(1, cartItem.getCartId());
			pstmt.setInt(2, cartItem.getProductId());
			pstmt.setInt(3, cartItem.getQuantity());
			pstmt.setDouble(4, cartItem.getItemTotal());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public CartItem getCartItem(int cartItemId) {

		CartItem cartItem = null;

		try (Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_QUERY)) {

			pstmt.setInt(1, cartItemId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				cartItem = new CartItem();

				cartItem.setCartItemId(rs.getInt("cartItemId"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setItemTotal(rs.getDouble("itemTotal"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cartItem;
	}

	@Override
	public List<CartItem> getCartItemsByCartId(int cartId) {

		List<CartItem> cartItems = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(GET_BY_CART_QUERY)) {

			pstmt.setInt(1, cartId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				CartItem cartItem = new CartItem();

				cartItem.setCartItemId(rs.getInt("cartItemId"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setItemTotal(rs.getDouble("itemTotal"));

				cartItems.add(cartItem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cartItems;
	}

	@Override
	public List<CartItem> getAllCartItems() {

		List<CartItem> cartItems = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL_QUERY)) {

			while (rs.next()) {

				CartItem cartItem = new CartItem();

				cartItem.setCartItemId(rs.getInt("cartItemId"));
				cartItem.setCartId(rs.getInt("cartId"));
				cartItem.setProductId(rs.getInt("productId"));
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setItemTotal(rs.getDouble("itemTotal"));

				cartItems.add(cartItem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cartItems;
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

			pstmt.setInt(1, cartItem.getCartId());
			pstmt.setInt(2, cartItem.getProductId());
			pstmt.setInt(3, cartItem.getQuantity());
			pstmt.setDouble(4, cartItem.getItemTotal());
			pstmt.setInt(5, cartItem.getCartItemId());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteCartItem(int cartItemId) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

			pstmt.setInt(1, cartItemId);

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean clearCartItems(int cartId) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(CLEAR_CART_QUERY)) {

			pstmt.setInt(1, cartId);

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	
	
	

	
	@Override
	public CartItem getCartItemByCartAndProduct(int cartId, int productId) {

	    CartItem cartItem = null;

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt =
	                 con.prepareStatement(GET_BY_CART_PRODUCT_QUERY)) {

	        pstmt.setInt(1, cartId);
	        pstmt.setInt(2, productId);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {

	            cartItem = new CartItem();

	            cartItem.setCartItemId(rs.getInt("cartItemId"));
	            cartItem.setCartId(rs.getInt("cartId"));
	            cartItem.setProductId(rs.getInt("productId"));
	            cartItem.setQuantity(rs.getInt("quantity"));
	            cartItem.setItemTotal(rs.getDouble("itemTotal"));

	        }

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return cartItem;
	}
	
	@Override
	public List<CartItemDetails> getCartItemDetails(int cartId) {

	    List<CartItemDetails> list = new ArrayList<>();

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt =
	                 con.prepareStatement(GET_CART_ITEMS_WITH_PRODUCTS)) {

	        pstmt.setInt(1, cartId);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {

	            CartItemDetails item = new CartItemDetails();

	            item.setCartItemId(rs.getInt("cartItemId"));
	            item.setProductId(rs.getInt("productId"));
	            item.setProductName(rs.getString("productName"));
	            item.setImage(rs.getString("image"));
	            item.setPrice(rs.getDouble("price"));
	            item.setQuantity(rs.getInt("quantity"));
	            item.setItemTotal(rs.getDouble("itemTotal"));

	            list.add(item);
	        }

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return list;
	}

	
	
}