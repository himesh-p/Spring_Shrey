package com.himesh.core.ioc;

public class FoodItem {
	private int id;
	private String name;
	private double price;
	private boolean isAvailable;
	
	public FoodItem(){
		id = 110;
		name = "Khichadi";
		price = 50;
		isAvailable = true;
	}
	
	public FoodItem(int id, String name, double price , boolean isAvailable) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.isAvailable = isAvailable;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", name=" + name + ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}
		
}
