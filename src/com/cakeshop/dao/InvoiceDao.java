package com.cakeshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cakeshop.model.Cart;
import com.cakeshop.model.Invoice;
import com.cakeshop.model.Products;
import com.cakeshop.model.User;

public class InvoiceDao {
	public void insertInvoice(Invoice invoice)
	{
		ProductDao proDao=new ProductDao();
		UserDao userDao=new UserDao();
		int userId=userDao.findUserId(invoice.getUser());				
		int ProId=proDao.findProductId1(invoice.getProduct());
		int cartId=CartDao.findCartId(invoice.getCart());
		String insert="INSERT INTO INVOICE_DETAILS(cake_id,user_id,cart_id,final_price,order_date) VALUES(?,?,?,?,?)";
		
		ConnectionUtil conUtil = new ConnectionUtil();
		Connection con = conUtil.getDbConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement(insert);
			pst.setInt(1, ProId);
			pst.setInt(2, userId);
			pst.setInt(3, cartId);
			pst.setDouble(4, invoice.getFinalPrice());
			pst.setTimestamp(5,invoice.getOrderDate() );
			pst.executeUpdate();
			System.out.println("Value inserted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Value not inserted in the table");
		}

		
	}
	
//view cart items
	
	public List<Cart> viewCart(User currentUser) {
		
		
		List<Cart> userCartList = new ArrayList<Cart>();
		String query = "select * from cart_items";
		Connection con = ConnectionUtil.getDbConnection();	
		ProductDao productDao = new ProductDao();		
		
		UserDao userDao = new UserDao();				
		int  userId = UserDao.findUserId(currentUser);	 
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Products products=productDao.findProduct(rs.getInt(2));
				
				Cart cart=new Cart(products,currentUser,rs.getInt(3),rs.getDouble(4));
			userCartList.add(cart);
			
		    //Products product=ProductDao.findProductId1(rs.getObject(2));
		    
			//Cart cart = new Cart(product, userId, rs.getInt(4), rs.getDouble(5));
			//cartList.add(cart);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userCartList;
	}
	
	//update cart	
		public static void updateCart(String updateCart) throws ClassNotFoundException, SQLException {
			String updateQuery = "update cart_items set quantity =? where cart_id=?";

			Connection con = ConnectionUtil.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1, Integer.parseInt(updateCart.split(",")[0]));
			pstmt.setInt(2, Integer.parseInt(updateCart.split(",")[1]));
			int i = pstmt.executeUpdate();
			System.out.println(i + "row updated");
			pstmt.close();
			con.close();
		}

	//delete cart
		
		public static void deleteCart(String delete) throws ClassNotFoundException, SQLException {
			String deleteQuery = "delete from cart_items where cart_id=?";

			Connection con = ConnectionUtil.getDbConnection();			
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, Integer.parseInt(delete));
			int i = pstmt.executeUpdate();
			System.out.println(i + "row deleted");
			pstmt.close();
			con.close();
		}

}
