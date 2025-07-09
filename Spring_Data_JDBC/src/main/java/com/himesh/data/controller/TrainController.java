package com.himesh.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.himesh.data.entity.TrainEntity;
import com.himesh.data.service.TrainService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/trains")
public class TrainController {
	private final TrainService trainService;
	
	public TrainController(TrainService trainService) {
		this.trainService = trainService;
	}
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("trains", trainService.getAll());
		return "trains";
	}
	
	@GetMapping("/add")
	public String createForm(Model model) {
		model.addAttribute("add", new TrainEntity());
		return "train_form";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute TrainEntity trainEntity){
		trainService.save(trainEntity);
		return "redirect:/trains";
	}
	
	@GetMapping("/edit/{id}")
	public String editForm(Model model ,@PathVariable int id) {
		model.addAttribute("add", trainService.getById(id));
		return "train_form";
	}
	
	@PostMapping("/update") 
	public String update(@ModelAttribute TrainEntity trainEntity){
		trainService.update(trainEntity);
		return "redirect:/trains";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		trainService.deleteById(id);
		return "redirect:/trains";
	}
	
}
