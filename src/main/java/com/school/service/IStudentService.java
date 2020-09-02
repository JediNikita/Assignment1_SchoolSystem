package com.school.service;

import java.util.List;

import com.school.model.Course;

public interface IStudentService {
	public List<Course> findAllCourses();

	void update(String whatUpdate, String value);
}
