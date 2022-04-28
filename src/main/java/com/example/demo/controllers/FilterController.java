package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.IFilterProductService;

@Controller
@RequestMapping("/product/filter")
public class FilterController {
	
	@Autowired
	private IFilterProductService filterService;
	
	@GetMapping("/price/{price}")
	public String getFilterByPriceLargerThan(@PathVariable(name = "price")float price, Model model) {
		
		model.addAttribute("package", filterService.filterByPriceLargerThan(price));
		return "list-page";
	}
	@GetMapping("/amount/{amount}")
	public String getFilterByAmountLessThan(@PathVariable(name = "amount")int amount, Model model) {
		model.addAttribute("package", filterService.filterByAmountLessThan(amount));
		return "list-page";
	}
	@GetMapping("/discount/{percent}")
	public String getDiscountAllPrices(@PathVariable(name = "percent")int percent, Model model) {
		try {
			model.addAttribute("package", filterService.discountAllPrices(percent));
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());
			return "error-page";
		}
		return "list-page";
	}
}
