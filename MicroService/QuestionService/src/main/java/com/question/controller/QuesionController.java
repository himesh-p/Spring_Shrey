package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.QuestionEntity;
import com.question.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuesionController {
	
	private final QuestionService service;
	
	@PostMapping
    public QuestionEntity create(@RequestBody QuestionEntity question) {
        return service.add(question);
    }

    @GetMapping
    public List<QuestionEntity> getAll() {
        return service.get();
    }

    @GetMapping("/{questionId}")
    public QuestionEntity getOne(@PathVariable Long questionId) {
        return service.getOne(questionId);
    }

    @GetMapping("/quiz/{quizId}")
    public List<QuestionEntity> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return service.getQuestionsOfQuiz(quizId);
    }
}
