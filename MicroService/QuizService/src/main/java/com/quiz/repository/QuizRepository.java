package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.entity.QuizEntity;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long>{
	
}
