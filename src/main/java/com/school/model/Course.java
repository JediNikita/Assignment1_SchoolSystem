package com.school.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	@Id
	private long id;
	private String name;
	private String description;
	
	@OneToOne(mappedBy = "course")
	 @JoinTable( 
		        name = "courses_students", 
		        joinColumns = @JoinColumn(
		          name = "course_id", referencedColumnName = "id"), 
		        inverseJoinColumns = @JoinColumn(
		          name = "student_id", referencedColumnName = "id")) 
	private Student student;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
