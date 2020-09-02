package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	@Query("update student s set s.?1=?2")
	void update(String whatUpdate, String value);

}
