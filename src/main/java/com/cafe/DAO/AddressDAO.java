package com.cafe.DAO;

import java.util.List;

import com.cafe.Model.Address;

public interface AddressDAO {

	boolean addAddress(Address address);

	Address getAddress(int addressId);

	List<Address> getAddressByUser(int userId);

	boolean updateAddress(Address address);

	boolean deleteAddress(int addressId);

	List<Address> getAllAddress();

}