package com.school.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.school.model.Student;

@Component
public class StudentRepositoryImpl{

	
	public void update(String who, String whatUpdate, String value) {
		
		  EntityManagerFactory emf= Persistence.createEntityManagerFactory("persistence"); 
		  EntityManager  entitymanager = emf.createEntityManager( ); 
		  CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
		  CriteriaUpdate<Student> update = cb.createCriteriaUpdate(Student.class);
		  Root<Student> root = update.from(Student.class);

		  
		  update.set(root.get(whatUpdate), value).where(cb.equal(root.get("name"), who));
	}

	
}

	


