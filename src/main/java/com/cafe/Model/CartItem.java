package com.cafe.Model;

public class CartItem {

	private int cartItemId;
	private int cartId;
	private int productId;
	private int quantity;
	private double itemTotal;

	public CartItem() {

	}

	public CartItem(int cartId, int productId, int quantity, double itemTotal) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public CartItem(int cartItemId, int cartId, int productId, int quantity, double itemTotal) {
		super();
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cartId=" + cartId + ", productId=" + productId + ", quantity="
				+ quantity + ", itemTotal=" + itemTotal + "]";
	}

}
