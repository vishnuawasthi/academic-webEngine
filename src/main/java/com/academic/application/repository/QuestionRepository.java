package com.academic.application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.academic.application.entity.Question;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

}
