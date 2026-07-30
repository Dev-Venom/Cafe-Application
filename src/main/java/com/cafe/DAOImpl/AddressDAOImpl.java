package com.cafe.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cafe.DAO.AddressDAO;
import com.cafe.Model.Address;
import com.cafe.utility.DBConnection;

public class AddressDAOImpl implements AddressDAO {

	private static final String INSERT_QUERY = "INSERT into address(userId, houseNo, street, city, state, pincode)"
			+ "VALUES(?, ?, ?, ?, ?, ?)";

	private static final String GET_QUERY = "SELECT * FROM address WHERE addressId = ?";

	private static final String UPDATE_QUERY = "UPDATE address SET houseNo = ?, street = ?, city = ?, state = ?, pincode = ? WHERE addressId = ?";

	private static final String DELETE_QUERY = "DELETE FROM address WHERE addressId = ?";

	private static final String GET_ALL_QUERY = "SELECT * FROM address";

	private static final String GET_BY_USER_QUERY = "SELECT * FROM address WHERE userId = ?";

	@Override
	public boolean addAddress(Address address) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

			pstmt.setInt(1, address.getUserId());
			pstmt.setString(2, address.getHouseNo());
			pstmt.setString(3, address.getStreet());
			pstmt.setString(4, address.getCity());
			pstmt.setString(5, address.getState());
			pstmt.setString(6, address.getPincode());

			int rows = pstmt.executeUpdate();

			System.out.println(rows + " " + "Rows Affected");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Address getAddress(int addressId) {

		Connection con = DBConnection.getConnection();

		Address address = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(GET_QUERY);

			pstmt.setInt(1, addressId);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				System.out.println("Data Found");

				int id = res.getInt("addressId");
				int uid = res.getInt("userId");
				String houseno = res.getString("houseNo");
				String street = res.getString("street");
				String city = res.getString("city");
				String state = res.getString("city");
				String pincode = res.getString("pincode");

				address = new Address(id, uid, houseno, street, city, state, pincode);

			} else {
				System.out.println("Data Not Found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return address;
	}

	@Override
	public List<Address> getAddressByUser(int userId) {

		ArrayList<Address> list = new ArrayList<Address>();

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = con.prepareStatement(GET_BY_USER_QUERY);

			pstmt.setInt(1, userId);

			ResultSet res = pstmt.executeQuery();

			if (res.next()) {

				System.out.println("Data Found");

				int id = res.getInt("addressId");
				int uid = res.getInt("userId");
				String houseno = res.getString("houseNo");
				String street = res.getString("street");
				String city = res.getString("city");
				String state = res.getString("city");
				String pincode = res.getString("pincode");

				Address address = new Address(id, uid, houseno, street, city, state, pincode);

				list.add(address);

			} else {
				System.out.println("Data Not Found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean updateAddress(Address address) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, address.getHouseNo());
			pstmt.setString(2, address.getStreet());
			pstmt.setString(3, address.getCity());
			pstmt.setString(4, address.getState());
			pstmt.setString(5, address.getPincode());
			pstmt.setInt(6, address.getAddressId());

			int i = pstmt.executeUpdate();
			System.out.println(i + " " + "Rows affected");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteAddress(int addressId) {

		Connection con = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, addressId);

			int i = pstmt.executeUpdate();
			System.out.println(i + " " + "Rows affected");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Address> getAllAddress() {

		ArrayList<Address> list = new ArrayList<Address>();

		Connection con = DBConnection.getConnection();

		try {

			Statement statement = con.createStatement();

			ResultSet res = statement.executeQuery(GET_ALL_QUERY);

			while (res.next()) {

				int addressId = res.getInt("addressId");
				int userId = res.getInt("userId");
				String houseNo = res.getString("houseNo");
				String street = res.getString("street");
				String city = res.getString("city");
				String state = res.getString("state");
				String pincode = res.getString("pincode");

				Address address = new Address(addressId, userId, houseNo, street, city, state, pincode);

				list.add(address);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
