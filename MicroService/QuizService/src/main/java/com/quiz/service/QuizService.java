package com.quiz.service;

import java.util.List;

import com.quiz.entity.QuizEntity;

public interface QuizService {
	QuizEntity add(QuizEntity entity);
	List<QuizEntity> get();
    QuizEntity get(Long id);
}
