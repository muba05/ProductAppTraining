package com.maveric.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.maveric.model.ProductModel;
import com.maveric.model.UsersModel;
import com.maveric.service.ProductBean;

public class ProductDAO {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/product";
	
	static final String USER = "root";
	static final String PASS = "";
	
	public static Connection connectToDB() {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL, USER, PASS);
		}catch (Exception e) {
			
		}
		return conn;
	}
	
	public static int executeQuery(Connection conn, String query) {
		Statement stmt = null;
		int result= 0;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			System.out.println("Querexecuted"+result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			try{
		         if(stmt!=null)
		            stmt.close();
		     }catch(SQLException se){
		     }
		     try{
		        if(conn!=null)
		           conn.close();
		     }catch(SQLException se){
		        se.printStackTrace();
		     }
		}
		return result;
	}
	
	public int userToDB(UsersModel users){
		
			Connection connection = this.connectToDB();
			int result = 0;
			java.sql.Date date = new java.sql.Date(users.getDateOfJoining().getTime());
			System.out.println(date.getTime());
			String query = "INSERT INTO userdetails "
				+ "(empId, empName, deptCode, doj, active, password) "
				+ " VALUES ('"+users.getEmpId()+"', '"
				+ users.getEmpName()+"','"
				+ users.getDepartmentCode()+"', '"
				+ date+"', '"
				+ users.getUserActive()+"', '"
				+ users.getPassword() +"')";
			
			System.out.println("Query"+query);
			result = executeQuery(connection, query);
			return result;
	}
	
	public List<ProductModel> productList(){
		
		Connection conn = null;
		Statement stmt = null;
		List<ProductModel> productModels = new ArrayList<ProductModel>();
		ProductModel productModel = new ProductModel();
		try {
			Class.forName(JDBC_DRIVER);
			conn=DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			
			String query = "select * from productdetails ";
			
			ResultSet resultSet = stmt.executeQuery(query);
			
			while(resultSet.next()) {
				productModel = new ProductModel();
				productModel.setProdId(resultSet.getString("prodId"));
				productModel.setProdName(resultSet.getString("prodName"));
				productModel.setProdDescp(resultSet.getString("prodDescp"));
				ProductBean productBean = new ProductBean();
				Date startDate = productBean.dateFormat(resultSet.getString("startDate"));
				productModel.setStartDate(startDate);
				Date endDate = productBean.dateFormat(resultSet.getString("endDate"));
				productModel.setEndDate(endDate);
				productModel.setQty(Integer.valueOf(resultSet.getString("qty")));
				productModels.add(productModel);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			try{
		         if(stmt!=null)
		            stmt.close();
		     }catch(SQLException se){
		     }
		     try{
		        if(conn!=null)
		           conn.close();
		     }catch(SQLException se){
		        se.printStackTrace();
		     }
		}
		return productModels;
	}
	
	
	public String checkPasswordToDB(String username){
		
		Connection conn = null;
		Statement stmt = null;
		String result= "";
		try {
			conn=ProductDAO.connectToDB();
			stmt = conn.createStatement();
			
			String query = "select * from userdetails where empId = '"+username+"'";
			
			System.out.println("Query "+query);
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				result = rs.getString("password");
			}
			
			System.out.println("Querexecuted"+result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			try{
		         if(stmt!=null)
		            stmt.close();
		     }catch(SQLException se){
		     }
		     try{
		        if(conn!=null)
		           conn.close();
		     }catch(SQLException se){
		        se.printStackTrace();
		     }
		}
		return result;
		
	}
	
	
	public int productCreation(ProductModel productModel){
		
			Connection connection = this.connectToDB();
			int result = 0;
			
			java.sql.Date startdate = new java.sql.Date(productModel.getStartDate().getTime());
			java.sql.Date enddate = new java.sql.Date(productModel.getEndDate().getTime());
			
			String query = "INSERT INTO productdetails "
				+ "(prodId, prodName, prodDescp, startDate, endDate, qty) "
				+ " VALUES ('"+productModel.getProdId()+"', '"
				+ productModel.getProdName()+"','"
				+ productModel.getProdDescp()+"', '"
				+ startdate+"', '"
				+ enddate+"', '"
				+ productModel.getQty()+"')";
			
			System.out.println("Query"+query);
			result = this.executeQuery(connection, query);
			System.out.println("Querexecuted"+result);
		
			return result;
	}

}
