package com.academic.application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.academic.application.entity.Course;

public interface CourseRepository  extends PagingAndSortingRepository<Course, Long>{

}
