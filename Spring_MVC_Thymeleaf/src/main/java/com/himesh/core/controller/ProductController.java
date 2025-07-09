package com.himesh.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.himesh.core.entity.Product;
import com.himesh.core.service.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public String list(Model model){
		model.addAttribute("products", productService.getAll());
		return "product/list";
	}
	 
	@GetMapping("/add")
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "product/form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@Valid @ModelAttribute("product") Product product , BindingResult result){
		if(result.hasErrors()) {
			return "product/form";
		}
		productService.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("edit/{id}")
	public String editProduct(@PathVariable int id,Model model){
		Product product = productService.getById(id);
		if(product == null){
			return "error/404";
		}
		model.addAttribute("product",product);
		return "product/form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id){
		productService.delete(id);
		return "redirect:/products";
	}
	
	@GetMapping("/{id}")
	public String viewProduct(@PathVariable int id , Model model) {
		Product product = productService.getById(id);
		if(product == null) {
			return "error/404";
		}
		model.addAttribute("product", product);
		return "product/details";
	}
	
}
