package com.kk.fresherpro.GstBillingApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
	
	@RequestMapping("/")
	public String homepage(Model theModel) {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1,"code1","kk",200,10));
		productList.add(new Product(2,"code2","csk",2020,3));

		theModel.addAttribute("list",productList);
		return "home";
	}

	@RequestMapping("/bill")
	public String billingpage() {
		return "billing";
	}
	
	@RequestMapping("/entry")
	public String mainpage() {
		return "productentry";
	}
}
