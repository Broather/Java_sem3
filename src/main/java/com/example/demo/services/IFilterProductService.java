package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.Product;

public interface IFilterProductService {
public abstract ArrayList<Product> filterByPriceLargerThan(float price);
public abstract ArrayList<Product> filterByAmountLessThan(int amount);
public abstract ArrayList<Product> discountAllPrices(int percent) throws Exception;
}
