package com.example.demo.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Product;
import com.example.demo.services.ICRUDProductService;

@Controller
@RequestMapping("/product") //localhost:8080/product
public class CRUDController{
	
	@Autowired
	private ICRUDProductService prodCRUDService;
	
	@GetMapping("/all") //localhost:8080/product/all
	public String listAllProducts(Model model) {
		ArrayList<Product> list = prodCRUDService.readAll();
		model.addAttribute("package", list);
		
		System.out.println("all funkcija nostrādāja");
		return "list-page";
	}
	@GetMapping("/one") //localhost:8080/product/one?id=1
	public String getOneProduct(@RequestParam(name = "id") int id, Model model) {
		Product tempProd;
		try {
			tempProd = prodCRUDService.readById(id);
		} catch (Exception e) {
			
			model.addAttribute("errorMessage", e.getMessage());
			return "error-page";
		}
		model.addAttribute("package", tempProd);
		
		return "object-page";
	}
}
