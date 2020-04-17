package com.kk.fresherpro.GstBillingApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@Column(name="productcode")
	private Integer code;

	@Column(name="productname")	
	private String name;
	
	@Column(name="productprice")
	private Double price;
	
	@Column(name="productgst")
	private Double gst;

	public Product() {
		
	}
	public Product(Integer code, String name, Double price, Double gst) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.gst = gst;
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
	
	
	
}
