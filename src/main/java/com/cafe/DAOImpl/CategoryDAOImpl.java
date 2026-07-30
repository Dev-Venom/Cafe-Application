package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.cafe.DAO.CategoryDAO;
import com.cafe.Model.Category;
import com.cafe.utility.DBConnection;

public class CategoryDAOImpl implements CategoryDAO {

	private static final String INSERT_QUERY = "INSERT INTO category(categoryName) VALUES(?)";

	private static final String GET_QUERY = "SELECT * FROM category WHERE categoryId=?";

	private static final String GET_ALL_QUERY = "SELECT * FROM category";

	private static final String UPDATE_QUERY = "UPDATE category SET categoryName=? WHERE categoryId=?";

	private static final String DELETE_QUERY = "DELETE FROM category WHERE categoryId=?";

	private static final String CHECK_CART_EXISTS_QUERY = "SELECT 1 FROM cart WHERE userId = ?";

	@Override
	public boolean addCategory(Category category) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY)) {

			pstmt.setString(1, category.getCategoryName());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Category getCategory(int categoryId) {

		Category category = null;

		try (Connection con = DBConnection.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_QUERY)) {

			pstmt.setInt(1, categoryId);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				category = new Category();

				category.setCategoryId(res.getInt("categoryId"));
				category.setCategoryName(res.getString("categoryName"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return category;
	}

	@Override
	public ArrayList<Category> getAllCategories() {

		ArrayList<Category> categories = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(GET_ALL_QUERY)) {

			while (res.next()) {

				Category category = new Category();

				category.setCategoryId(res.getInt("categoryId"));
				category.setCategoryName(res.getString("categoryName"));

				categories.add(category);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}

	@Override
	public boolean updateCategory(Category category) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY)) {

			pstmt.setString(1, category.getCategoryName());
			pstmt.setInt(2, category.getCategoryId());

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteCategory(int categoryId) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY)) {

			pstmt.setInt(1, categoryId);

			return pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean isCartExists(int userId) {

		try (Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(CHECK_CART_EXISTS_QUERY)) {

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			return rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}