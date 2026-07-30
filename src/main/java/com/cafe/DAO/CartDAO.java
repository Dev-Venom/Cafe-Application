package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.Cart;

public interface CartDAO {

	boolean addCart(Cart cart);

	Cart getCart(int cartId);

	Cart getCartByUserId(int userId);

	List<Cart> getAllCarts();

	boolean updateCart(Cart cart);

	boolean deleteCart(int cartId);

	boolean isCartExists(int userId);
}