package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.Category;

public interface CategoryDAO {

	boolean addCategory(Category category);

	Category getCategory(int categoryId);

	List<Category> getAllCategories();

	boolean updateCategory(Category category);

	boolean deleteCategory(int categoryId);

	boolean isCartExists(int userId);

}
