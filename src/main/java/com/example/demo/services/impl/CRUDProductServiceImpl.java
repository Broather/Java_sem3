package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService{
	private ArrayList<Product> allProducts = new ArrayList<>(
			Arrays.asList(	new Product("Maize", 1.45f, 20),
							new Product("Piens", 2.30f, 100),
							new Product("Cepumi", 0.35f, 1000)));
	@Override
	public Product createProduct(Product temp) {
//		ja jau eksistē produkts ar tādu pašu nosaukumu un cenu, tad update amount
		for(Product prod : allProducts) {
			if(prod.getTitle().equals(temp.getTitle()) && prod.getPrice() == temp.getPrice()){
				int newAmount = prod.getAmount() + temp.getAmount();
				prod.setAmount(newAmount);
				return prod;
			}
		}
		Product newProduct = new Product(temp.getTitle(), temp.getPrice(), temp.getAmount());
		return null;
	}

	@Override
	public ArrayList<Product> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product readById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateById(int id, Product temp) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
