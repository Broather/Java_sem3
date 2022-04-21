package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Product;

public interface ICRUDProductService {
	// visas funkcijas interfeisā ir abstraktras, tikai ar header (līdzīgi kā .hpp faili cpp)
	public abstract Product createProduct(Product temp);
	public abstract ArrayList<Product> readAll();
	public abstract Product readById(int id) throws Exception;
//	temp produkts var būs pus aizpildīts lai update notiek parametriem kuriem ir vērtība
	public abstract void updateById(int id, Product temp) throws Exception;
	public abstract void deleteById(int id) throws Exception;
}
