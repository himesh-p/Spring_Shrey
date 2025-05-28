package com.himesh.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.himesh.core.ioc.AppConfig;
import com.himesh.core.ioc.FoodItem;
import com.himesh.core.ioc.IceCream;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		FoodItem obj1 = (FoodItem) context.getBean("foodItem2");
		IceCream obj2 = (IceCream) context.getBean("iceCream2");
		 
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
	}

}
