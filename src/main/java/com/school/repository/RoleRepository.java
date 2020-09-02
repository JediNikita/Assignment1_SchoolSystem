package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Query("select r from Role r where r.roleName=?1")
	public Role findRole(@Param("rolename")String rolename);
}
