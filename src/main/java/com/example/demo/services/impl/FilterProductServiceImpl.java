package com.example.demo.services.impl;

import java.util.ArrayList;

import com.example.demo.models.Product;
import com.example.demo.services.IFilterProductService;

public class FilterProductServiceImpl implements IFilterProductService{

	@Override
	/**
	 * Returns list of products with price more than "price"
	 */
	public ArrayList<Product> filterByPriceLargerThan(float price) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Returns list of products with price less than "amount"
	 */
	@Override
	public ArrayList<Product> filterByAmountLessThan(int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void discountAllPrices(float percent) {
		// TODO Auto-generated method stub
		
	}

}
