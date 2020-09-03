package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> , JpaSpecificationExecutor<Student>{
	
	void update(String who, String whatUpdate, String value);

}
