package com.kk.fresherpro.GstBillingApp;


public class BillProduct {

	private Integer code;
	private String name;
	private Double price;
	private Double gst;
	private Integer qty;
	private Double amount;
	
	public BillProduct() {}
	
	public BillProduct(Product p) {
		this.code = p.getCode();
		this.name = p.getName();
		this.price = p.getPrice();
		this.gst = p.getGst();
		this.qty = 1;
		this.amount = 0.0;
	}
	
	public BillProduct(Integer code, String name, Double price, Double gst, Integer qty, Double amount) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.gst = gst;
		this.qty = qty;
		this.amount = amount;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getGst() {
		return gst;
	}
	public void setGst(Double gst) {
		this.gst = gst;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}
