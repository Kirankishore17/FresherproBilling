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
			
			int index=-1;
			for(int i = 0; i< billList.size(); i++) {
				BillProduct temp = billList.get(i);
				if(temp.getCode().equals(product.getCode())) {
					index = i;
					break;
				}
			}
			if(index != -1) {
				BillProduct temp = billList.get(index);
				qty = qty + temp.getQty();
				total = total - temp.getAmount();
				billList.remove(index);		
			}
			
			billProduct.setAmount(product.getPrice() * qty * (100 + product.getGst()) / 100);
			billProduct.setQty(qty);
			total = total + billProduct.getAmount();
			billList.add(billProduct);
		}else {
			return "redirect:/";

		}
		return "redirect:/bill";
	}
	
	@PostMapping("/addtobillName")
	public String billingPageSearchByName(@RequestParam("name") String name, @RequestParam("qty") Integer qty) {
		name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		Product product = dao.searchByName(name);
		if(product != null) {
			BillProduct billProduct = new BillProduct(product);
			int index=-1;
			for(int i = 0; i< billList.size(); i++) {
				BillProduct temp = billList.get(i);
				if(temp.getCode().equals(product.getCode())) {
					index = i;
					break;
				}
			}
			if(index != -1) {
				BillProduct temp = billList.get(index);
				qty = qty + temp.getQty();
				total = total - temp.getAmount();
				billList.remove(index);		
			}
			billProduct.setAmount(product.getPrice() * qty * (100 + product.getGst()) / 100);
			billProduct.setQty(qty);
			total = total + billProduct.getAmount();		
			billList.add(billProduct);
		}else {
			return "redirect:/";

		}
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
		total = 0.0;
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
		String name  = product.getName(); 
		product.setName(name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase());
		if(dao.checkId(product.getCode())) {
			return "redirect:/error";
		}
		dao.addProduct(product);
		return "redirect:/";
	}
	
	@PostMapping("/update/{id}")
	public String updateProduct(@PathVariable("id") int id, Model model) {
		Product product = dao.searchById(id);
		model.addAttribute("code", product.getCode());
		model.addAttribute("name", product.getName());
		model.addAttribute("gst", product.getGst());
		model.addAttribute("price", product.getPrice());
		
		return "update";
	}

	@PostMapping(value="/update/product")
	public String updateProduct(@RequestParam("code") Integer code, @RequestParam("name") String name,
								@RequestParam("gst") Double gst, @RequestParam("price") Double price) {
		Product product = dao.searchById(code);
		try {
		product.setGst(gst);
		product.setPrice(price);
		product.setName(name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase());
		}catch(Exception e) {
			return "redirect:/error";
		}
		dao.addProduct(product);
		return "redirect:/";	}
}
