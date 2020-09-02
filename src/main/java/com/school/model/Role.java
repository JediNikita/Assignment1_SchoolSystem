package com.school.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="roles") 
public class Role {
	
	@Id
	private int id;
	private String roleName;
	@OneToOne(mappedBy = "role")
    private User user;
	@ManyToMany
    @JoinTable(
        name = "roles_permissions", 
        joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "permission_id", referencedColumnName = "id"))
    private Collection<Permission> permissions;  
	
	
	public Collection<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}
	public int getRoleId() {
		return id;
	}
	public void setRoleId(int roleId) {
		this.id = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
