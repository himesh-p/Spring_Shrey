package com.himesh.core.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class AppConfig {
	
	@Bean(name="foodItem1")
	public FoodItem foodItem1() {
		return new FoodItem(1001, "Pav Bhaji" , 100 , false);
	}
	
	@Bean(name="foodItem2")
	public FoodItem foodItem2() {
		return new FoodItem();
	}
	
	@Bean(name="iceCream1")
	public IceCream iceCream1() {
		return new IceCream("Hocco" , "ButterScotch" , 120);
	}
	
	@Bean(name="iceCream2")
	public IceCream iceCream2() { 
		return new IceCream();
	}
}
