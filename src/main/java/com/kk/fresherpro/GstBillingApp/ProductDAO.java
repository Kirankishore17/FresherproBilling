package com.kk.fresherpro.GstBillingApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ProductDAO")
public class ProductDAO {
	
	@Autowired
	ProductRepo repo;
	
	public List<Product> findAll(){
		System.out.println("\n\nReturns full list");
		/*
		List<Product> productList = new ArrayList<Product>() {{
		add(new Product(1,"kk",200.0,10.0));
		add(new Product(2,"csk",2020.0,3.0));
		}};
		*/
		List<Product> productList = repo.findAll();
		System.out.print(productList);
		
		
		return 	productList;
	}
	
	public void addProduct(Product product) {
		repo.save(product);
		System.out.println("\n\nSaves: " + product);
	}

	public void deleteById(int id) {
		repo.deleteById(id);
	}

}
