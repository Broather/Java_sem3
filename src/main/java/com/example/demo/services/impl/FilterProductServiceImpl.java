package com.example.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.Product;
import com.example.demo.services.ICRUDProductService;
import com.example.demo.services.IFilterProductService;

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
			if(prod.getPrice() < amount) {
				filteredList.add(prod);
			}
		}
		return filteredList;
	}

	@Override
	public void discountAllPrices(float percent) {
		if(percent >= 0 && percent <= 1) {
		for(Product prod: prodCRUDService.readAll()) {
			float oldPrice = prod.getPrice();
			prod.setPrice(oldPrice - oldPrice * percent);
			}
		}
		
	}

}
