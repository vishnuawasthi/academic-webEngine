package com.academic.application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.academic.application.entity.Assignment;

public interface AssignmentRepository extends PagingAndSortingRepository<Assignment, Long> {

}
