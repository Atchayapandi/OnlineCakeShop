package com.cakeshop.test;

import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import com.cakeshop.dao.AdminDao;
import com.cakeshop.dao.CartDao;
import com.cakeshop.dao.PaymentDao;
import com.cakeshop.dao.ProductDao;
import com.cakeshop.dao.UserDao;
import com.cakeshop.model.Cart;
import com.cakeshop.model.Payment;
import com.cakeshop.model.Products;
import com.cakeshop.model.User;
import java.util.Date;

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
			String userName = null;
			String EmailId = null;
			String password = null;
			String address = null;

			userDao = new UserDao();
//user name validation			
			do {
				System.out.println("Enter user Name:");
				userName = scan.nextLine();
				if (userName.matches("[A-Za-z]{3,}")) {
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
				EmailId = scan.nextLine();
				if (EmailId.matches("[a-z]+[0-9]*[@][a-z]+[.][a-z]+")) {
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
				if (password.matches("[A-Za-z0-9]{8,15}")) {
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

			User user = new User(userName, EmailId, password, address);

			userDao.insertUser(user);
//login details
		case 2:
			userDao = new UserDao();
			do {
				System.out.println("Please Login");
				System.out.println("Enter the registered Email_id: ");
				EmailId = scan.nextLine();
				if (EmailId.matches("[a-z]+[0-9]*[@][a-z]+[.][a-z]+")) {
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

			User currentUser = UserDao.validateUser(EmailId, password);
//Admin login
			if (currentUser == null) {
				User adminuser = AdminDao.validateAdmin(EmailId, password);
				
				System.out.println("Welcome!!\t" + adminuser.getUserName() + "\tas Admin");			
					
				
				System.out.println("\n1.List Users \n2.Add products \n3.update product\n4.delete Product");
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
					//break;
//add a new product
				case 2:
					ProductDao productDao=new ProductDao();
					System.out.println("Enter your product name:");
					String proName=scan.nextLine();
					System.out.println("Enter Your product description: ");
					String description=scan.nextLine();
					System.out.println("Enter your product price:");
				    int price=scan.nextInt();
				    System.out.println("Enter your category name: ");
				    String category=scan.nextLine();
				    
				    Products product = new Products(proName,description,price,category);

					productDao.insertProduct(product);
					
//update product					
				case 3:

					System.out.println("enter your new cake name and your cake id using comma:");
					String updateProduct = scan.nextLine();
					ProductDao.updateProduct(updateProduct);
					//break;
// delete Product
				case 4:

					System.out.println("enter your cake id for delete:");
					String delete = scan.nextLine();
					ProductDao.deleteProduct(delete);
				}
//User Login				

			} else {
				System.out.println("welcome !!\t" + currentUser.getUserName());

				System.out.println("\n1.show products");
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

					System.out.println("\nplease enter your choice for order:");
					System.out.println("\n1.Orders from you\n2.View Order Items\n3.update Order\n4.Cancel order");

					int orderChoice = Integer.parseInt(scan.nextLine());
					CartDao cartDao = null;
					Products product = null;
					String userFlag = null;

					switch (orderChoice) {

// insert cart
					case 1:
						String userName1 = currentUser.getUserName();
						int id1 = userDao.findUserId(userName1);

						System.out.println("view hole product list\n");
						List<Products> productsList1 = (List<Products>) proDao.showProduct();
						for (int i = 0; i < productsList1.size(); i++) {
							System.out.println(productsList1.get(i));

						}
						System.out.println("\nEnter Product name: ");
						String productName = scan.nextLine();
						int id2 = ProductDao.findProductId1(productName);

						int price = proDao.findPrice(id2);

						System.out.println("\nEnter your Number of Products");
						int quantity = Integer.parseInt(scan.nextLine());

						System.out.println("\nEnter your Order date: ");
						SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
						Date orderDate = null;
						try {
							orderDate = sdf.parse(scan.nextLine());
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						double totalPrice = (double) (quantity * price);
						System.out.println("\nyour total amount is: " + totalPrice);
						
						Cart cart1 = new Cart(id2, id1, quantity, totalPrice, orderDate);
						
						cartDao = new CartDao();
						cartDao.insertCart(cart1);
						System.out.println("Thank you !!");
//payment method 
						System.out.println("\nYour Payment Page is open!!");

						PaymentDao paymentDao = new PaymentDao();
						long cardNo1 = 0;
						int cardCvv1 = 0;
						Date expireDate1 = null;
						int paidAmount = 0;
//card num validation
						String cardNo=null;
						do {
							System.out.println("Please enter your card Number");
							 cardNo = scan.nextLine();
							

							if (cardNo.matches("[0-9]{16}")) {
								flag = 1;
								break;
							} else {
								flag = 0;
								System.err.println("Please Enter the valid card number! ");
							}
							
							
						} while (flag == 0);
						cardNo1 = Long.parseLong(cardNo);
// cvv  number validation
						do {
							System.out.println("Please enter your card CVV number");
							String cardCvv = scan.nextLine();
							cardCvv1 = Integer.parseInt(cardCvv);

							if (cardCvv.matches("[0-9]{3}+")) {
								flag = 1;
								break;
							} else {
								flag = 0;
								System.err.println("Please Enter the valid card CVV number! ");
							}
						} while (flag == 0);
//expire date validation
						do {
							System.out.println("Please enter your expire date of card");
							SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");

							try {
								expireDate1 = sdf1.parse(scan.nextLine());
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						} while (flag == 0);

						System.out.println("please enter your paid amount");
						paidAmount = scan.nextInt();
						if (paidAmount == totalPrice) {
							System.out.println("your payment is succesfully completed\n your order confirmed");
						} else {
							System.out.println("your payment amount is invalid for your purchase");
						}

						PaymentDao paymentdao=new PaymentDao();
						Payment payment = new Payment(cardNo1, cardCvv1, expireDate1, paidAmount);
						
						paymentDao.insertPayment(payment);
						
						break;
//view cart items
					case 2:

						System.out.println("view Orders in cart");
						List<Cart> userCartList = order.viewCart(currentUser);
						System.out.println(userCartList);
						break;
//update cart						

					case 3:
						System.out.println("This is your cart Items: ");
//						List<Cart> userCartList1 = order.viewCart(currentUser);
//						System.out.println(userCartList1);
						System.out.println("enter your new quantity and your cart id using comma:");
						String updateCart = scan.nextLine();
						CartDao.updateCart(updateCart);
						break;
//delete cart				

					case 4:
						System.out.println("enter your cart id for delete:");
						String delete = scan.nextLine();
						CartDao.deleteCart(delete);
					}
					while (choice < 5)
						break;

				}
			}
		}
	}
}
