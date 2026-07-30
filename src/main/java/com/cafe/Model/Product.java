package com.cafe.Model;

import java.time.LocalDateTime;

public class Product {

	private int productId;
	private int categoryId;
	private String productName;
	private String description;
	private double price;
	private int stock;
	private String image;
	private double rating;
	private boolean isAvailable;
	private LocalDateTime createdAt;

	public Product() {

	}

	public Product(int categoryId, String productName, String description, double price, int stock, String image,
			double rating, boolean isAvailable, LocalDateTime createdAt) {
		super();
		this.categoryId = categoryId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.createdAt = createdAt;
	}

	public Product(int productId, int categoryId, String productName, String description, double price, int stock,
			String image, double rating, boolean isAvailable, LocalDateTime createdAt) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.image = image;
		this.rating = rating;
		this.isAvailable = isAvailable;
		this.createdAt = createdAt;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", categoryId=" + categoryId + ", productName=" + productName
				+ ", description=" + description + ", price=" + price + ", stock=" + stock + ", image=" + image
				+ ", rating=" + rating + ", isAvailable=" + isAvailable + ", createdAt=" + createdAt + "]";
	}

}
