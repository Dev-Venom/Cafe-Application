package com.cafe.main;

import java.util.Scanner;

import com.cafe.DAOImpl.ProductDAOImpl;
import com.cafe.Model.Product;

public class launch {

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter the name:");
//		String userName = sc.next();
//
//		System.out.println("Enter the email:");
//		String email = sc.next();
//
//		System.out.println("Enter the password:");
//		String password = sc.next();
//
//		System.out.println("Enter the phone:");
//		String phone = sc.next();
//
//		System.out.println("Enter the role:");
//		String role = sc.next();
//
//		User u = new User(userName, email, password, phone, role);
//
//		UserDAOImpl udao = new UserDAOImpl();
//
//		udao.addUser(u);
//		System.out.println("User added");
//
//		User u = udao.getUser(1);
//		System.out.println(u);
//
////		u.setPhone("8925639975");
//		u.setEmail("Prateeksha@gmail.com");
////		u.setPassword("Prateeksha");
//
//		udao.updateUser(u);
//		System.out.println("User update");

//		udao.deleteUser(2);
//		System.out.println("User Deleted");
//
//		List<User> allUser = udao.getAllUsers();
//		for (User user : allUser) {
//			System.out.println(user);
//		}

//		UserDAO dao = new UserDAOImpl();
//
//		User user = dao.login("kumaravel007650@gmail.com", "Kumaravel@007");
//
//		if (user != null) {
//			System.out.println("Login Successful");
//			System.out.println(user);
//		} else {
//			System.out.println("Invalid Email or Password");
//		}

//
//		AddressDAOImpl ad = new AddressDAOImpl();

//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter the userId :");
//		int userId = sc.nextInt();
//
//		System.out.println("Enter the houseNo :");
//		String houseNo = sc.next();
//
//		System.out.println("Enter the street: ");
//		String street = sc.next();
//
//		System.out.println("Enter the city: ");
//		String city = sc.next();
//
//		System.out.println("Enter the state: ");
//		String state = sc.next();
//
//		System.out.println("Enter the pincode");
//		String pincode = sc.next();
////
//		Address a = new Address(userId, userId, houseNo, street, city, state, pincode);
//
//		ad.addAddress(a);
//		System.out.println("Address added");

//		ad.deleteAddress(3);
//		System.out.println("Address deleted");

//		Address a = ad.getAddress(4);
//
//		System.out.println(a);
//
//		List<Address> addresses = ad.getAddressByUser(1);
//
//		for (Address address : addresses) {
//			System.out.println(address);
//		}

//		Address add = ad.getAddress(4);
//		System.out.println(add);
//
//		add.setHouseNo("50");
//		add.setCity("Erode");
//		add.setState("TamilNadu");
//
//		ad.updateAddress(add);
//		System.out.println("User Updated");

//		

//		CategoryDAOImpl d = new CategoryDAOImpl();

//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter the Name: ");
//		String name = sc.next();
//
//		Category c = new Category(name);
//
//		d.addCategory(c);
//		System.out.println("Category Added");

//		Category c = d.getCategory(2);
//		System.out.println(c);

//		List<Category> list = d.getAllCategories();
//		for (Category category : list) {
//			System.out.println(category);
//
//		}

//		Category c = d.getCategory(2);
//
//		c.setCategoryName("Tea");
//		d.updateCategory(c);
//		System.out.println("Updated");

//		d.deleteCategory(2);

		ProductDAOImpl p = new ProductDAOImpl();

//		categoryId, productName, description, price, stock, image, rating, isAvailable;

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Category ID: ");
		int cId = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Product Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Description: ");
		String des = sc.nextLine();

		System.out.print("Enter Price: ");
		double price = sc.nextDouble();

		System.out.print("Enter Stock: ");
		int stock = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Image Path: ");
		String image = sc.nextLine();

		System.out.print("Enter Rating: ");
		double rating = sc.nextDouble();

		System.out.print("Is Available (true/false): ");
		boolean avail = sc.nextBoolean();

		Product pr = new Product();

		pr.setCategoryId(cId);
		pr.setProductName(name);
		pr.setDescription(des);
		pr.setPrice(price);
		pr.setStock(stock);
		pr.setImage(image);
		pr.setRating(rating);
		pr.setAvailable(avail);

		boolean status = p.addProduct(pr);

		if (status) {
			System.out.println("✅ Product Added Successfully");
		} else {
			System.out.println("❌ Product Not Added");
		}
	}

}
