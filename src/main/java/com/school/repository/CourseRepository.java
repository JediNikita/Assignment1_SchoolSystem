package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Override
	List<Course> findAll();
	
	@Query("select c from Course c where c.name=?1")
	Course findCourseByName(String courseName);
	

}
