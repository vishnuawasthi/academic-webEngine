package com.academic.application.repository;

import org.springframework.data.repository.CrudRepository;

import com.academic.application.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findUserByUsername(String username);

}
