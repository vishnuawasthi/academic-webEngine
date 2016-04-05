package com.academic.application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.academic.application.entity.UserRole;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {
	public UserRole findByRoleName(String roleName);
}
