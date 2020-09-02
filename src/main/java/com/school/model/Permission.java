package com.school.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="permissions")
public class Permission {

	@Id
	private int id;
	private String permission;
	@ManyToMany(mappedBy = "permissions")
	private Collection<Role> roles;

	public int getPermissionId() {
		return id;
	}
	public void setPermissionId(int permissionId) {
		this.id = permissionId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	


}
