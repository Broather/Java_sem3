package com.example.demo.controllers;


import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Product;
import com.example.demo.services.ICRUDProductService;

@Controller
@RequestMapping("/product") //localhost:8080/product
public class CRUDController{
	
	@Autowired
	private ICRUDProductService prodService;
	
	@GetMapping("/all") //localhost:8080/product/all
	public String listAllProducts(Model model) {
		ArrayList<Product> list = prodService.readAll();
		model.addAttribute("package", list);
		
		System.out.println("all funkcija nostrādāja");
		return "list-page";
	}
	@GetMapping("/one") //localhost:8080/product/one?id=1
	public String getOneProduct(@RequestParam(name = "id") int id, Model model) {
		Product tempProd;
		try {
			tempProd = prodService.readById(id);
		} catch (Exception e) {
			
			model.addAttribute("errorMessage", e.getMessage());
			return "error-page";
		}
		model.addAttribute("package", tempProd);
		
		return "object-page";
	}
	@GetMapping("/one/{id}") //localhost:8080/one/<vērtība>
	public String getProductById(@PathVariable(name = "id") int id, Model model) {
		Product tempProd;
		try {
			tempProd = prodService.readById(id);
		} catch (Exception e) {
			
			model.addAttribute("errorMessage", e.getMessage());
			return "error-page";
		}
		model.addAttribute("package", tempProd);
		
		return "object-page";
	}
	@GetMapping("/add")  //localhost:8080/product/add
	public String getProductAdd(Product product) { // padod tukšu produktu html lapai
		
		return "add-prod-page";
	}
	@PostMapping("/add")  //localhost:8080/product/add
	public String postProductAdd(@Valid Product product, BindingResult result) { // saņem aizpildīt produktu no html lapas
//		ja validācijai nav kļūdas
		if(!result.hasErrors()) {
			Product prod = prodService.createProduct(product);
//			return "redirect:/product/one";
			return "redirect:/product/one/"+prod.getId();
		}else {
			return "add-prod-page";
		}
		
		
	}
	
	@GetMapping("/update/{id}")
	public String getProductUpdate(@PathVariable(name= "id") int id, Model model) {
		Product prod;
		try {
			prod = prodService.readById(id);
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "error-page";
		}
		model.addAttribute("product", prod);
		return "update-prod-page";
		
	}
	@PostMapping("/update/{id}")
	public String postProductUpdate(@PathVariable(name= "id") int id,@Valid Product product, BindingResult result, Model model) {
		if(!result.hasErrors()) {
			
		
		try {
			prodService.updateById(id, product);
		} catch (Exception e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "error-page";
		}
		return "redirect:/product/one/"+id;
		}else {
			return "update-prod-page";
		}
	}
	@GetMapping("/delete/{id}")
	public String getProductDelete(@PathVariable(name = "id") int id, Model model) {
		try {
			prodService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());
			return "error-page";
		}
		model.addAttribute("package", prodService.readAll());
		return "list-page";
	}
}
