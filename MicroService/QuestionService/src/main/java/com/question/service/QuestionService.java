package com.question.service;

import java.util.List;

import com.question.entity.QuestionEntity;

public interface QuestionService {
	QuestionEntity add(QuestionEntity question);
    List<QuestionEntity> get();
    QuestionEntity getOne(Long id);
    List<QuestionEntity> getQuestionsOfQuiz(Long quizId);
}
