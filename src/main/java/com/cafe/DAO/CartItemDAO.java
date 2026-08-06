package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.CartItem;
import com.cafe.Model.CartItemDetails;

public interface CartItemDAO {

    boolean addCartItem(CartItem cartItem);

    CartItem getCartItem(int cartItemId);

    CartItem getCartItemByCartAndProduct(int cartId, int productId);

    List<CartItem> getCartItemsByCartId(int cartId);

    List<CartItem> getAllCartItems();

    List<CartItemDetails> getCartItemDetails(int cartId);

    boolean updateCartItem(CartItem cartItem);

    boolean deleteCartItem(int cartItemId);

    boolean clearCartItems(int cartId);

	int getCartItemCount(int cartId);

}