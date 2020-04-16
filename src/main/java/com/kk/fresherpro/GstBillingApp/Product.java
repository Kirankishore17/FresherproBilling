package com.kk.fresherpro.GstBillingApp;

public class Product {

	private int id;
	
	private String code;
	
	private String name;
	
	private double price;
	
	private double gst;

	public Product() {
		
	}
	public Product(int id, String code, String name, double price, double gst) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
		this.gst = gst;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	
	
	
}
