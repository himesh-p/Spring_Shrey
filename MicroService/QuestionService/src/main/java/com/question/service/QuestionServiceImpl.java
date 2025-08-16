package com.question.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entity.QuestionEntity;
import com.question.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

	private final QuestionRepository repository;
	
	@Override
	public QuestionEntity add(QuestionEntity question) {
		return repository.save(question);
	}

	@Override
	public List<QuestionEntity> get() {
		return repository.findAll();
	}

	@Override
	public QuestionEntity getOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Question not found!"));
	}

	@Override
	public List<QuestionEntity> getQuestionsOfQuiz(Long quizId) {
		return repository.findByQuizId(quizId);
	}
	
}
