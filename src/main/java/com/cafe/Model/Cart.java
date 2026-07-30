package com.cafe.Model;

import java.time.LocalDateTime;

public class Cart {

	private int cartId;
	private int userId;
	private LocalDateTime createdAt;

	public Cart() {

	}

	public Cart(int userId, LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.createdAt = createdAt;
	}

	public Cart(int cartId, int userId, LocalDateTime createdAt) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.createdAt = createdAt;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", createdAt=" + createdAt + "]";
	}

}
