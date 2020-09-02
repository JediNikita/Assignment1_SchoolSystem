package com.school.service;

import com.school.model.User;
import com.school.model.UserDto;

public interface IUserService {
	User registerNewUserAccount(String userName, String password, String role);    
	public UserDto searchUser(String username);
	public User registerNewStudentAccount(String userName, String password, String role, String course, String address);
}
