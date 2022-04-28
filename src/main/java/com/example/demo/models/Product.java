package com.example.demo.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Product {
private static int idCounter = 0;
private int id;
@Size(min = 3, max = 30)
@Pattern(regexp = "[A-Z]{1}[a-z]+")
private String title;

@Min(value = 0, message = "Cenai jābūt lielākai vai vienādai par 0")
@Max(value = 1000, message = "Cenai jābūt mazākai vai vienādai par 1000")
private float price;

@Min(value = 0, message = "Skaits jābūt lielākai vai vienādai par 0")
@Max(value = 1000, message = "Skaits jābūt mazākai vai vienādai par 10000")
private int amount;

private void setId() {
	id = idCounter++;
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
