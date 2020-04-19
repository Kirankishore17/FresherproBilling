package com.kk.fresherpro.GstBillingApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
	
	@Autowired
	private ProductDAO dao;
	
	List<BillProduct> billList = new ArrayList<BillProduct>();
		
	Double total;
		
	public DemoController() {
			this.total = 0.0;
	}
	
	@RequestMapping("/")
	public String homepage(Model theModel) {
		List<Product> productList = dao.findAll();
		theModel.addAttribute("list",productList);
		return "home";
	}

	@RequestMapping("/bill")
	public String billingPage(Model theModel) {
		theModel.addAttribute("billList", billList);
		theModel.addAttribute("total", total);
		return "billing";
	}
	
	
	@PostMapping("/addtobillId")
	public String billingPageSearchById(@RequestParam("id") Integer id, @RequestParam("qty") Integer qty) {
		Product product = dao.searchById(id);
		if(product != null) {
			BillProduct billProduct = new BillProduct(product);
			billProduct.setAmount(product.getPrice() * qty * (100 + product.getGst()) / 100);
			billProduct.setQty(qty);
			total = total + billProduct.getAmount();
			billList.add(billProduct);
		}else {
			return "redirect:/";

		}

		// System.out.println("\n\n\n" + product.getName() + " ---- " + total);
		return "redirect:/bill";
	}
	
	@PostMapping("/addtobillName")
	public String billingPageSearchByName(@RequestParam("name") String name, @RequestParam("qty") Integer qty) {
		Product product = dao.searchByName(name);
		if(product != null) {
			BillProduct billProduct = new BillProduct(product);
			billProduct.setAmount(product.getPrice() * qty * (100 + product.getGst()) / 100);
			billProduct.setQty(qty);
			total = total + billProduct.getAmount();
			billList.add(billProduct);
		}else {
			return "redirect:/";

		}
		// System.out.println("\n\n\n" + product.getName() + " ---- " + total);
		return "redirect:/bill";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteEntry(@PathVariable("id") int id) {
		dao.deleteById(id);
		return "redirect:/";
	}
	
	@PostMapping("/clear")
	public String resetBillList() {
		billList.clear();
		return "redirect:/bill";
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
		dao.addProduct(product);
		return "redirect:/";
	}
}
