package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Permission;
import com.school.model.Student;
import com.school.model.User;
import com.school.model.UserDto;
import com.school.repository.CourseRepository;
import com.school.repository.RoleRepository;
import com.school.repository.StudentRepository;
import com.school.repository.UserRepository;

@Service
public class UserService implements IUserService{
	
	@Autowired
    private UserRepository repository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private CourseRepository courseRepository;
	
	@Autowired
    private StudentRepository studentRepository;
	
	@Autowired
	private UserDto dto;
	
	@Override
	public User registerNewUserAccount(String userName, String password, String role) {
		User user = new User();    
		user.setUserName(userName);
		user.setPassword(password);
		user.setRole(roleRepository.findRole(role));
		System.out.println(roleRepository.findRole(role));
		repository.save(user);
		
        return user;   
	}
	
	
	@Override
	public UserDto searchUser(String username) {
		User user= repository.findByUsername(username);
		dto.setUserName(user.getUserName());
		dto.setRole(user.getRole());
		dto.setListOfPermissions((List<Permission>) user.getRole().getPermissions());
		return dto;
	}


	@Override
	public User registerNewStudentAccount(String userName, String password, String role, String course, String address) {
		User user = new User();    
		user.setUserName(userName);
		user.setPassword(password);
		user.setRole(roleRepository.findRole(role));
		Student student = new Student();
		student.setName(userName);
		student.setCourse(courseRepository.findCourseByName(course));
		student.setAddress(address);
		student.setUser(user);
		repository.save(user);
		studentRepository.save(student);
		
        return user; 
	}


	
}
