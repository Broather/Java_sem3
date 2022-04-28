package com.example.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.services.ICRUDProductService;
import com.example.demo.services.IFilterProductService;

@Service
public class FilterProductServiceImpl implements IFilterProductService{
	
	@Autowired
	private ICRUDProductService prodCRUDService;
	/**
	 * Returns list of products with price more than "price"
	 */
	@Override
	public ArrayList<Product> filterByPriceLargerThan(float price) {
		ArrayList<Product> filteredList = new ArrayList<>();
		for(Product prod: prodCRUDService.readAll()) {
			if(prod.getPrice() > price) {
				filteredList.add(prod);
			}
		}
		return filteredList;
	}
	/**
	 * Returns list of products with price less than "amount"
	 */
	@Override
	public ArrayList<Product> filterByAmountLessThan(int amount) {
		ArrayList<Product> filteredList = new ArrayList<>();
		for(Product prod: prodCRUDService.readAll()) {
			if(prod.getAmount() < amount) {
				filteredList.add(prod);
			}
		}
		return filteredList;
	}

	@Override
	public ArrayList<Product> discountAllPrices(int percent) throws Exception {
		if(percent >= 0 && percent <= 100) {
			ArrayList<Product> list = prodCRUDService.readAll();
			for(Product prod: prodCRUDService.readAll()) {
				float oldPrice = prod.getPrice();
				prod.setPrice(oldPrice - oldPrice * (percent/100f));
			}
			return list;
		}
		throw new Exception("Discount jābūt intervālā [0; 100], Jūs ievadījāt "+percent);
		
		
	}

}
