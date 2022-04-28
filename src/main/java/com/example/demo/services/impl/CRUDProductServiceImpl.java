package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repo.IProductRepo;
import com.example.demo.services.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService{
	@Autowired
	private IProductRepo prodRepo;
	
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
		allProducts.add(newProduct);
		return newProduct;
	}

	@Override
	public ArrayList<Product> readAll() {
		return (ArrayList<Product>) prodRepo.findAll();
	}

	@Override
	public Product readById(int id) throws Exception {
		if(prodRepo.existsById(id)) {
			return prodRepo.findById(id).get();
		}else {
			throw new Exception("Produkts ar id: " +id+ " neeksistē");			
		}

	}

	@Override
	public void updateById(int id, Product temp) throws Exception {
		boolean isFound = false;
		for(Product prod: allProducts) {
			if(prod.getId() == id) {
				isFound = true;
				if(temp.getTitle() != null){
					prod.setTitle(temp.getTitle());
				}
				if(temp.getPrice() != 0){
					prod.setPrice(temp.getPrice());
				}
				if(temp.getAmount() != 0){
					prod.setAmount(temp.getAmount());
				}
			}
		}
		if(!isFound) throw new Exception("Produkts ar id: " +id+ " neeksistē");
		
	}

	@Override
	public void deleteById(int id) throws Exception {
		if(prodRepo.existsById(id)) {
			prodRepo.deleteById(id);
		}else {
			throw new Exception("Produkts ar id: " +id+ " neeksistē");			
		}

		
	}

}
