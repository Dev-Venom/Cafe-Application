package com.cafe.Model;

import java.time.LocalDateTime;

public class Orders {

	private int orderId;
	private int userId;
	private int addressId;
	private LocalDateTime orderDate;
	private double totalAmount;
	private String paymentMethod;
	private String orderStatus;
	
	
	public Orders() {
		super();
	}


	public Orders(int userId, int addressId, LocalDateTime orderDate, double totalAmount, String paymentMethod,
			String orderStatus) {
		super();
		this.userId = userId;
		this.addressId = addressId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
	}


	public Orders(int orderId, int userId, int addressId, LocalDateTime orderDate, double totalAmount,
			String paymentMethod, String orderStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.addressId = addressId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", userId=" + userId + ", addressId=" + addressId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", paymentMethod=" + paymentMethod + ", orderStatus="
				+ orderStatus + "]";
	}
	
	

}
