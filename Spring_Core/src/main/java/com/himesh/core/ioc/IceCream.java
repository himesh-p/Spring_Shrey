package com.himesh.core.ioc;

public class IceCream {
	private String name;
	private String flavour;
	private double price;
	
	public IceCream(){
		name = "Vadilal";
		flavour = "Vanila";
		price = 79;
	}

	public IceCream(String name, String flavour, double price) {
		this.name = name;
		this.flavour = flavour;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "IceCream [name=" + name + ", flavour=" + flavour + ", price=" + price + "]";
	}
	
	
}
