package com.quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entity.QuizEntity;
import com.quiz.service.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {
		
	private final QuizService service;
	
	@GetMapping("/all")
	public List<QuizEntity> getQuiz(){
		return service.get();
	}
	
	@PostMapping
    public QuizEntity create(@RequestBody QuizEntity quiz) {
        return service.add(quiz);
    }
	
	@GetMapping("/{id}")
    public QuizEntity getOne(@PathVariable Long id) {
        return service.get(id);
    }
}
