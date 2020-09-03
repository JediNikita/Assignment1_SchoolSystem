package com.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.model.Course;
import com.school.repository.CourseRepository;
import com.school.repository.StudentRepository;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private CourseRepository cr;
	
	@Autowired
	private StudentRepository sr;
	
	@Override
	public List<Course> findAllCourses() {
		
		return cr.findAll();
	}
	
	public List<String> findAllCourseNames(){
		
		List<String> courseNames= new ArrayList<String>();
		for(Course course:findAllCourses()) {
			courseNames.add(course.getName());
		}
		
		return courseNames;
	}
	
	@Override
	public void update(String who, String whatUpdate, String value) {
		sr.update(who, whatUpdate, value);
	}
}
