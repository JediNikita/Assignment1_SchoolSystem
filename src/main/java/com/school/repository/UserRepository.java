package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.model.User;

 
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

	//void registerUser(String userName, String password, String role);
	
}
