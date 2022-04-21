package com.example.demo.models;

public class Product {
private static int idCounter = 0;
private int id;
private String title;
private float price;
private int amount;

private void setId() {
	id = idCounter;
}
public int getId() {
	return id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}

public Product() {}

public Product(String title, float price, int amount) {
	setId();
	setTitle(title);
	setPrice(price);
	setAmount(amount);
}
public String toString() {
	return title;
}




}
