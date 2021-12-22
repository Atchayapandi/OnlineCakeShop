package com.cakeshop.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.cakeshop.dao.AdminDao;
import com.cakeshop.dao.CartDao;
import com.cakeshop.dao.ProductDao;
import com.cakeshop.dao.UserDao;
import com.cakeshop.model.Cart;
import com.cakeshop.model.Products;
import com.cakeshop.model.User;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner scan = new Scanner(System.in);
		System.out.println("\tWelcome to Online Cake Shop");
		System.out.println("\n1.Register\n2.Login\nEnter your Choice :");
		int choice = Integer.parseInt(scan.nextLine());
		UserDao userDao = null;
		int flag = 1;
//Register
		switch (choice) {
		case 1:
			String user_name = null;
			String Email_id = null;
			String password = null;
			String address = null;

			userDao = new UserDao();
//user name validation			
			do {
				System.out.println("Enter user Name:");
				user_name = scan.nextLine();
				if (user_name.matches("[A-Za-z]{3,}")) {
					flag = 1;
					break;
				} else {
					flag = 0;
					System.err.println("please enter the valid User name: ");
				}
			} while (flag == 0);
//email id validation
			do {
				System.out.println("Enter email ID:");
				Email_id = scan.nextLine();
				if (Email_id.matches("[a-z]+[0-9]*[@][a-z]+[.][a-z]+")) {
					flag = 1;
					break;
				} else {
					flag = 0;
					System.err.println("Please Enter the valid Email id: ");
				}
			} while (flag == 0);
//password validation
			do {
				System.out.println("Enter password:");
				password = scan.nextLine();
				if (password.matches("[A-Za-z]{8,15}")) {
					flag = 1;
				} else {
					flag = 0;
					System.err.println("Please Enter The Valid Password ");
				}
			} while (flag == 0);
//confire password validation
			do {
				System.out.println("Confirm_password");
				String Confirm_password = scan.nextLine();
				if (Confirm_password.equals(password)) {
					flag = 1;
					break;
				} else {
					System.err.println("Please Re-enter the Correct password: ");
					flag = 0;
				}

			} while (flag == 0);
//address validation
			do {
				System.out.println("Enter address detail:");
				address = scan.nextLine();
				if (address.matches("[A-Za-z0-9]{4,}+[,][A-Za-z]{4,}+[,][0-9]{6}+{25,}")) {
					flag = 1;
				} else {
					flag = 0;
					System.err.println("Please Enter The Valid address");
				}
			} while (flag == 0);

			User user = new User(user_name, Email_id, password, address);
			userDao.insertUser(user);
//login details
		case 2:
			userDao = new UserDao();
			do {
				System.out.println("User Login");
				System.out.println("Enter the registered Email_id: ");
				Email_id = scan.nextLine();
				if (Email_id.matches("[a-z]+[0-9]*[@][a-z]+[.][a-z]+")) {
					flag = 1;
					break;
				} else {
					System.err.println("please enter the valid Email-id: ");
					flag = 0;

				}
			} while (flag == 0);
//password validation
			do {
				System.out.println("enter your registered password: ");
				password = scan.nextLine();
				if (password.matches("[A-Za-z]{8,15}")) {
					System.out.println("");
					flag = 1;
					break;
				} else {
					flag = 0;
					System.err.println("WRONG PASSWORD");
				}
			} while (flag == 0);

			User currentUser = UserDao.validateUser(Email_id, password);
//Admin login
			if (currentUser == null) {
				User adminuser = AdminDao.validateAdmin(Email_id, password);
				System.out.println("Welcome!!\t" + adminuser.getUserName() + "\tas Admin");
				System.out.println("\n1.List Users \n2.find user\n3.update product\n4.delete Product");
				System.out.println("Enter Your choice");
				choice = Integer.parseInt(scan.nextLine());

				switch (choice) {
// list user				
				case 1:

					System.out.println("List All User");
					List<User> userList = UserDao.showAllUser();
					for (int i = 0; i < userList.size(); i++) {
						System.out.println("\n" + userList.get(i));
					}
// find user id
//				case 2:
//
//					userDao = new UserDao();
//					System.out.println("enter email_Id:\n");
//					Email_id = scan.nextLine();
//					int userId = UserDao.findUserId(ad);
//					System.out.println("User Id:" + userId);
//					break;
// update product
				case 3:

					System.out.println("enter your new cake name and your cake id using comma:");
					String updateProduct = scan.nextLine();
					ProductDao.updateProduct(updateProduct);
					break;
// delete Product
				case 4:

					System.out.println("enter your cake id for delete:");
					String delete = scan.nextLine();
					ProductDao.deleteProduct(delete);
				}
//User Login				

			} else {
				System.out.println("welcome !!\t" + currentUser.getUserName());

				System.out.println("\n1.show products\n2.show invoice");
				choice = Integer.parseInt(scan.nextLine());

//show products
				switch (choice) {
				case 1:
					ProductDao proDao = new ProductDao();
					CartDao order = new CartDao();

					List<Products> productsList = (List<Products>) proDao.showProduct();
					for (int i = 0; i < productsList.size(); i++) {
						System.out.println(productsList.get(i));

					}

					System.out.println("\n1.insert cart\n2.View cart\n3.update cart\n4.Cancel cart");

					int orderChoice = Integer.parseInt(scan.nextLine());
                    CartDao cartDao=null;
					Products product = null;
					String userFlag = null;				

					switch (orderChoice) {

					// insert cart
					case 1:
						String userName=currentUser.getUserName();
						int id1=userDao.findUserId(userName);
						System.out.println("user"+id1);
						System.out.println("view Produce List");
						List<Products> productsList1 = (List<Products>) proDao.showProduct();
						for (int i = 0; i < productsList1.size(); i++) {
							System.out.println(productsList1.get(i));

						}
						System.out.println("Enter Product name");
						String productName=scan.nextLine();
						int id2=ProductDao.findProductId1(productName);
						System.out.println("product"+id2);
						int price=proDao.findPrice(id2);
						
						System.out.println("Enter your Number of Products");
						int quantity=Integer.parseInt(scan.nextLine());
						
						double totalPrice=(double)(quantity*price);
					     Cart cart1=new Cart(id2,id1,quantity,totalPrice);
					     cartDao=new CartDao();
						cartDao.insertCart(cart1);
						
						
						
						System.out.println("Thank you !!");
						break;
//view cart items
					case 2:
						System.out.println("view Orders in cart");
						List<Cart> userCartList = order.viewCart(currentUser);
						System.out.println(userCartList);
						break;
//update cart						

					case 3:

						System.out.println("enter your new quantity and your cart id using comma:");
						String updateProduct = scan.nextLine();
						ProductDao.updateProduct(updateProduct);
						break;
//delete cart					

					case 4:
						System.out.println("enter your cart id for delete:");
						String delete = scan.nextLine();
						ProductDao.deleteProduct(delete);
					}

					while (choice < 5)
						break;
// invoice					
				case 2:
                    
					System.out.println("Enter your invoice details: ");
					
					
					break;
				}
			}
		}
	}
}
