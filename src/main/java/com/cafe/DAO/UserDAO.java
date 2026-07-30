package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.User;

public interface UserDAO {

	boolean addUser(User user);

	User getUser(int userId);

	void updateUser(User user);

	void deleteUser(int userId);

	List<User> getAllUsers();

	User login(String email, String password);
	
	User getUserByEmail(String email);
}
