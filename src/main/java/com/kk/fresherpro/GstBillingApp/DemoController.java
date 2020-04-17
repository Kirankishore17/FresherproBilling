package com.kk.fresherpro.GstBillingApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
	
	@Autowired
	private ProductDAO dao;
	
	@RequestMapping("/")
	public String homepage(Model theModel) {
		List<Product> productList = dao.findAll();
		theModel.addAttribute("list",productList);
		return "home";
	}

	@RequestMapping("/bill")
	public String billingPage() {
		return "billing";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteEntry(@PathVariable("id") int id) {
		System.out.println("\nID===="+id);
		dao.deleteById(id);
		return "redirect:/";
	}
	
	@RequestMapping("/entry")
	public String mainpage() {
		return "productentry";
	}
	
	@ModelAttribute("product")
	public Product productModel() {
		return new Product();
	}
	
	@RequestMapping(value="/formSubmit")
	public String newEntry(@ModelAttribute("product") Product product) {
		System.out.println("\n\n____________\n\n" + product.getName());
		dao.addProduct(product);
		return "redirect:/";
	}
}
