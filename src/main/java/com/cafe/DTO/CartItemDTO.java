package com.cafe.DTO;

public class CartItemDTO {

    private int cartItemId;
    private int cartId;
    private int productId;

    private String productName;
    private String description;
    private double price;
    private String image;
    private double rating;

    private int quantity;
    private double itemTotal;

    public CartItemDTO() {
    }

    public CartItemDTO(int cartItemId, int cartId, int productId,
            String productName, String description,
            double price, String image, double rating,
            int quantity, double itemTotal) {

        this.cartItemId = cartItemId;
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.rating = rating;
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
}