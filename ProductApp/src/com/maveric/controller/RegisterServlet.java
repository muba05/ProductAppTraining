package com.maveric.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maveric.model.UsersModel;
import com.maveric.service.ProductBean;

/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String pwd = request.getParameter("userpassword");
		
		if(userName != null && pwd != null) {
			if(userName.length() > 0 && pwd.length() > 0) {
				ProductBean productBean =new ProductBean();
				boolean userLogin = productBean.userLogin(userName, pwd);
				if(userLogin) {
					System.out.println("User corrected");
					request.getRequestDispatcher("Admin2.jsp").forward(request, response);
				}else {
					request.setAttribute("password", "password");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				}
			}else {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String deptCode = request.getParameter("depCode");
		String doj = request.getParameter("doj");
		System.out.println(doj);
		String password = request.getParameter("password");
		ProductBean productBean = new ProductBean();
		
		if(empId.length() > 1 && empName.length() > 1 && deptCode.length() > 1
				&& doj.length() > 1 && password.length() > 1) {
			UsersModel users = new UsersModel();
			users.setEmpId(empId);
			users.setEmpName(empName);
			users.setDepartmentCode(deptCode);
			
			Date date = productBean.dateFormat(doj);
			users.setDateOfJoining(date);
			
			users.setPassword(password);
			String valueInsert =  productBean.creatingUser(users);
			
			if(valueInsert.equalsIgnoreCase("success")) {
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}else if(valueInsert.equals("DateError")) {
				request.setAttribute("DateError", "date");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				return;
			}else if(valueInsert.equals("DepError")) {
				request.setAttribute("DepError", "admin");
				request.getRequestDispatcher("Register.jsp").forward(request, response);
				return;
			}
		}else {
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
		
		
	}

}
