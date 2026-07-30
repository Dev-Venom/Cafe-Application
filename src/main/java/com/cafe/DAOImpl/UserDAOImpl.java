package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cafe.DAO.UserDAO;
import com.cafe.Model.User;
import com.cafe.utility.DBConnection;

public class UserDAOImpl implements UserDAO {

	public static String INSERT_QUERY = "INSERT into user(userName, email, password, phone, role, createdAt)"
			+ "VALUES(?, ?, ?, ?, ?, ?)";

	public static String SELECT_QUERY = "SELECT * FROM user WHERE userId = ?";

	public static String UPDATE_QUERY = "UPDATE user SET userName = ?,  email = ?, password = ?, phone = ? WHERE userId = ?";

	public static String DELETE_QUERY = "DELETE FROM user WHERE userId = ?";

	public static String RETURN_QUERY = "SELECT * FROM user";

	private static final String LOGIN_QUERY = "SELECT * FROM user WHERE email = ? AND password = ?";

	private static final String GET_USER_BY_EMAIL =
	        "SELECT * FROM user WHERE email=?";
	
	@Override
	public boolean addUser(User user) {

	    Connection con = DBConnection.getConnection();

	    if (con == null) {
	        System.out.println("Database Connection Failed!");
	        return false;
	    }

	    try {

	        PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

	        pstmt.setString(1, user.getUserName());
	        pstmt.setString(2, user.getEmail());
	        pstmt.setString(3, user.getPassword());
	        pstmt.setString(4, user.getPhone());
	        pstmt.setString(5, user.getRole());
	        pstmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));

	        int rows = pstmt.executeUpdate();

	        return rows > 0;

	    } catch (SQLException e) {

	        e.printStackTrace();
	    }

	    return false;
	}

	@Override
	public User getUser(int userId) {

		Connection con = DBConnection.getConnection();

		User user = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);

			pstmt.setInt(1, userId);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int id = res.getInt("userId");
				String name = res.getString("userName");
				String email = res.getString("email");
				String password = res.getString("password");
				String role = res.getString("role");
				Timestamp createdAt = res.getTimestamp("createdAt");

				user = new User(id, name, email, password, role, role, createdAt);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;

	}

	@Override
	public void updateUser(User user) {

		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getPhone());
			pstmt.setInt(5, user.getUserId());

			int i = pstmt.executeUpdate();
			System.err.println(i + " " + "Rows affected  ");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int userId) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, userId);

			int i = pstmt.executeUpdate();
			System.out.println(i + "User is deleted" + i + "Rows are affected");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public List<User> getAllUsers() {

		ArrayList<User> list = new ArrayList<User>();

		Connection connection = DBConnection.getConnection();
		try {
			Statement statement = connection.createStatement();

			ResultSet res = statement.executeQuery(RETURN_QUERY);

			while (res.next()) {

				int userId = res.getInt("userId");
				String name = res.getString("userName");
				String email = res.getString("email");
				String password = res.getString("password");
				String phone = res.getString("phone");
				String role = res.getString("role");
				Timestamp createdAt = res.getTimestamp("createdAt");

				User user = new User(userId, name, password, email, phone, role, createdAt);

				list.add(user);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User login(String email, String password) {

		Connection con = DBConnection.getConnection();

		User user = null;

		try {

			PreparedStatement pstmt = con.prepareStatement(LOGIN_QUERY);

			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				user = new User();

				user.setUserId(res.getInt("userId"));
				user.setUserName(res.getString("userName"));
				user.setEmail(res.getString("email"));
				user.setPassword(res.getString("password"));
				user.setPhone(res.getString("phone"));
				user.setRole(res.getString("role"));
				user.setCreatedAt(res.getTimestamp("createdAt"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	@Override
	public User getUserByEmail(String email) {

	    User user = null;

	    Connection con = DBConnection.getConnection();

	    try {

	        PreparedStatement pstmt = con.prepareStatement(GET_USER_BY_EMAIL);

	        pstmt.setString(1, email);

	        ResultSet rs = pstmt.executeQuery();

	        if(rs.next()) {

	            user = new User();

	            user.setUserId(rs.getInt("userId"));
	            user.setUserName(rs.getString("userName"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            user.setPhone(rs.getString("phone"));
	            user.setRole(rs.getString("role"));
	            user.setCreatedAt(rs.getTimestamp("createdAt"));

	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}

}
