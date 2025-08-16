package com.quiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.quiz.entity.QuizEntity;
import com.quiz.repository.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{
	
	private final QuizRepository repository;
	private final QuestionClient client;
	
	@Override
	public QuizEntity add(QuizEntity entity) {
		return repository.save(entity);
	}

	@Override
	public List<QuizEntity> get() {
		List<QuizEntity> quizzes = repository.findAll();
		
		List<QuizEntity> newQuiz =  quizzes.stream().map( quiz -> {
				quiz.setQuestions(client.getQuestionsOfQuiz(quiz.getId()));
				return quiz;
		}).collect(Collectors.toList());
		
		return newQuiz; 
	}

	@Override
	public QuizEntity get(Long id) {
		QuizEntity quiz = repository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found!!!"));
		quiz.setQuestions(client.getQuestionsOfQuiz(quiz.getId()));
		return quiz;
	}
}
