package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.CartItem;
import com.cafe.Model.CartItemDetails;

public interface CartItemDAO {

	boolean addCartItem(CartItem cartItem);

	CartItem getCartItem(int cartItemId);

	List<CartItem> getCartItemsByCartId(int cartId);

	List<CartItem> getAllCartItems();

	boolean updateCartItem(CartItem cartItem);

	boolean deleteCartItem(int cartItemId);

	boolean clearCartItems(int cartId);

	boolean isProductInCart(int cartId, int productId);
	
	List<CartItemDetails> getCartItemsWithProductDetails(int cartId);
}