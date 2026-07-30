package com.cafe.Model;

public class OrderItem {

	private int orderItemId;
	private int orderId;
	private int productId;
	private int quantity;
	private double itemTotal;

	public OrderItem() {

	}

	public OrderItem(int orderId, int productId, int quantity, double itemTotal) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public OrderItem(int orderItemId, int orderId, int productId, int quantity, double itemTotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", itemTotal=" + itemTotal + "]";
	}

}
