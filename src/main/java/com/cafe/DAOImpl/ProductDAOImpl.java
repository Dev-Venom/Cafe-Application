package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cafe.DAO.ProductDAO;
import com.cafe.Model.Product;
import com.cafe.utility.DBConnection;

public class ProductDAOImpl implements ProductDAO {

	private static final String INSERT_QUERY = "INSERT INTO product(categoryId, productName, description, price, stock, image, rating, isAvailable) VALUES(?,?,?,?,?,?,?,?)";

	private static final String GET_QUERY = "SELECT * FROM product WHERE productId=?";

	private static final String GET_ALL_QUERY = "SELECT * FROM product";

	private static final String UPDATE_QUERY = "UPDATE product SET categoryId=?, productName=?, description=?, price=?, stock=?, image=?, rating=?, isAvailable=? WHERE productId=?";

	private static final String DELETE_QUERY = "DELETE FROM product WHERE productId=?";
	
	private static final String GET_RELATED_PRODUCTS_QUERY =
	        "SELECT * FROM product WHERE categoryId=? AND productId<>? LIMIT 4";
	
	private static final String UPDATE_STOCK_QUERY =
	        "UPDATE product SET stock = stock - ? WHERE productId=?";

	@Override
	public boolean addProduct(Product product) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

			pstmt.setInt(1, product.getCategoryId());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getDescription());
			pstmt.setDouble(4, product.getPrice());
			pstmt.setInt(5, product.getStock());
			pstmt.setString(6, product.getImage());
			pstmt.setDouble(7, product.getRating());
			pstmt.setBoolean(8, product.isAvailable());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Product getProduct(int productId) {

		Product product = null;

		try (Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_QUERY)) {

			pstmt.setInt(1, productId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				product = new Product();

				product.setProductId(rs.getInt("productId"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setProductName(rs.getString("productName"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setImage(rs.getString("image"));
				product.setRating(rs.getDouble("rating"));
				product.setAvailable(rs.getBoolean("isAvailable"));

				Timestamp ts = rs.getTimestamp("createdAt");
				if (ts != null) {
					product.setCreatedAt(ts.toLocalDateTime());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ALL_QUERY)) {

			while (rs.next()) {

				Product product = new Product();

				product.setProductId(rs.getInt("productId"));
				product.setCategoryId(rs.getInt("categoryId"));
				product.setProductName(rs.getString("productName"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setImage(rs.getString("image"));
				product.setRating(rs.getDouble("rating"));
				product.setAvailable(rs.getBoolean("isAvailable"));

				Timestamp ts = rs.getTimestamp("createdAt");
				if (ts != null) {
					product.setCreatedAt(ts.toLocalDateTime());
				}

				products.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public boolean updateProduct(Product product) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

			pstmt.setInt(1, product.getCategoryId());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getDescription());
			pstmt.setDouble(4, product.getPrice());
			pstmt.setInt(5, product.getStock());
			pstmt.setString(6, product.getImage());
			pstmt.setDouble(7, product.getRating());
			pstmt.setBoolean(8, product.isAvailable());
			pstmt.setInt(9, product.getProductId());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

			pstmt.setInt(1, productId);

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@Override
	public List<Product> getProductsByCategory(int categoryId, int productId) {

	    List<Product> products = new ArrayList<>();

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt =
	                 con.prepareStatement(GET_RELATED_PRODUCTS_QUERY)) {

	        pstmt.setInt(1, categoryId);
	        pstmt.setInt(2, productId);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {

	            Product product = new Product();

	            product.setProductId(rs.getInt("productId"));
	            product.setCategoryId(rs.getInt("categoryId"));
	            product.setProductName(rs.getString("productName"));
	            product.setDescription(rs.getString("description"));
	            product.setPrice(rs.getDouble("price"));
	            product.setStock(rs.getInt("stock"));
	            product.setImage(rs.getString("image"));
	            product.setRating(rs.getDouble("rating"));
	            product.setAvailable(rs.getBoolean("isAvailable"));

	            products.add(product);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return products;
	}
	
	@Override
	public boolean updateStock(int productId, int quantity) {

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement pstmt =
	                 con.prepareStatement(UPDATE_STOCK_QUERY)) {

	        pstmt.setInt(1, quantity);
	        pstmt.setInt(2, productId);

	        return pstmt.executeUpdate() > 0;

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	    return false;
	}
}