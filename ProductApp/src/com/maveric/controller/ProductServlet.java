package com.maveric.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maveric.model.ProductModel;
import com.maveric.service.ProductBean;

/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductBean productBean = new ProductBean();
		List<ProductModel> productBeans = productBean.productsList();
		request.setAttribute("productslist", productBeans);
		request.getRequestDispatcher("ProductResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prodId = request.getParameter("prodId");
		String prodName = request.getParameter("prodName");
		String prodDescp = request.getParameter("prodDescp");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String qty = request.getParameter("qty");
		ProductBean productBean = new ProductBean();
		
		if(prodId != null) {
			if(prodId.length() > 1 && prodName.length() > 1 && prodDescp.length() > 1
					&& startDate.length() > 1 && endDate.length() > 1 && qty.length() >= 1 ) {
				ProductModel productModel = new ProductModel();
				productModel.setProdId(prodId);
				productModel.setProdName(prodName);
				productModel.setProdDescp(prodDescp);
				
				Date dateStart = productBean.dateFormat(startDate);
				productModel.setStartDate(dateStart);
				Date dateEnd = productBean.dateFormat(endDate);
				productModel.setEndDate(dateEnd);
				
				productModel.setQty(Integer.valueOf(qty));			
				String valueInsert =  productBean.creatingProduct(productModel);
				
				if(valueInsert.equalsIgnoreCase("success")) {
					doGet(request, response);
				}else {
					request.setAttribute("DBError", "error");
					request.getRequestDispatcher("ProductCreation.jsp").forward(request, response);
					return;
				}
			}else {
				request.getRequestDispatcher("ProductCreation.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("ProductCreation.jsp").forward(request, response);
		}
		
		
		
	}

}
