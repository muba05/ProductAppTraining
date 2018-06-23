package com.maveric.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.maveric.dao.ProductDAO;
import com.maveric.model.ProductModel;
import com.maveric.model.UsersModel;

public class ProductBean {
	
	private static String ADMIN = "admin";
	private static String YES = "y";
	private static String NO = "n";
	
	public Date dateFormat(String date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = null;
		try {
			date2 = dateFormat.parse(date);
		} catch (ParseException e) {
			date2 = null;
			e.printStackTrace();
		}
		return date2;
	}
	public String creatingUser(UsersModel users){
		System.out.println("*************************");
		System.out.println("Users Details saving ");
		System.out.println("*************************");
		String valid = "";
		if(users.getDepartmentCode().equalsIgnoreCase(ADMIN)) {
			users.setUserActive(YES);
			Date date = new Date();
			if(date.getTime() >= users.getDateOfJoining().getTime()) {
				System.out.println("Date has been correct");
				ProductDAO dao = new ProductDAO();
				int checkInsertDB = dao.userToDB(users);
				if(checkInsertDB > 0) {
					System.out.println("Added in DB");
					valid = "success";
				}else {
					valid = "DBError";
				}
			}else {
				valid = "DateError";
			}
		}else {
			valid = "DepError";
		}
		return valid;
	}
	
	public boolean userLogin(String username, String pwd) {
		ProductDAO productDAO = new ProductDAO();
		String pwdDB = productDAO.checkPasswordToDB(username);
		if(pwdDB.equalsIgnoreCase(pwd)) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<ProductModel> productsList(){
		ProductDAO productDAO = new ProductDAO();
		return productDAO.productList();
	}
	
	public String creatingProduct(ProductModel productModel){
		System.out.println("*************************");
		System.out.println("Product Details saving ");
		System.out.println("*************************");
		String valid = "";
		
		ProductDAO dao = new ProductDAO();
		
		int checkInsertDB = dao.productCreation(productModel);
		if(checkInsertDB > 0) {
			System.out.println("Added in DB");
			valid = "success";
		}else {
			valid = "DBError";
		}
		
		return valid;
	}

}
