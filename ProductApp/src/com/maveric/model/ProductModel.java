package com.maveric.model;

import java.util.Date;

public class ProductModel {
	
	private String prodId;
	private String prodName;
	private String prodDescp;
	private Date startDate;
	private Date endDate;
	private int qty;
	
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDescp() {
		return prodDescp;
	}
	public void setProdDescp(String prodDescp) {
		this.prodDescp = prodDescp;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	

}
