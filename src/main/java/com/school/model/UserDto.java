package com.school.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDto {
	
	private String userName;
	private String password;
	private Role role;
	private List<Permission> listOfPermissions;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Permission> getListOfPermissions() {
		return listOfPermissions;
	}
	public void setListOfPermissions(List<Permission> listOfPermissions) {
		this.listOfPermissions = listOfPermissions;
	}
	
		
}
