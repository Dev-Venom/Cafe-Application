package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.Product;

public interface ProductDAO {

	boolean addProduct(Product product);

	Product getProduct(int productId);

	List<Product> getAllProducts();

	boolean updateProduct(Product product);

	boolean deleteProduct(int productId);
	
	List<Product> getProductsByCategory(int categoryId, int productId);
	
	boolean updateStock(int productId, int quantity);
}
