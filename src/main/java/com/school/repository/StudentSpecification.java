
package com.school.repository;

import javax.persistence.criteria.CriteriaBuilder;
import
javax.persistence.criteria.CriteriaQuery;
import
javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.school.model.Student;

public class StudentSpecification implements Specification<Student> {

	private String whatUpdate; private String value;



	public StudentSpecification(String whatUpdate, String value) {
		super();
		this.whatUpdate = whatUpdate; 
		this.value = value; }


	public static Specification<Student> byColumnNameAndValue(String whatUpdate, String value) {
	    return new Specification<Student>() {
	        @Override
	        public Predicate toPredicate(Root<Student> root,
	                CriteriaQuery<?> query, CriteriaBuilder builder) {
	            return builder.equal(root.<String>get(whatUpdate), value);
	        }
	    };
	}
	
	@Override public Predicate toPredicate(Root<Student> root, CriteriaQuery<?>
	query, CriteriaBuilder criteriaBuilder) {

		return
				criteriaBuilder.and(criteriaBuilder.equal(root.<String>get(this.whatUpdate),
						this.value)); }

	
	  public static Specification<Student> getStudentByNameSpec(String who){ //return
	  //(root, query, criteriaBuilder) -> { //Predicate
	  //equalPredicate=criteriaBuilder.equal(root.get(Student_.name), who); return
	  //equalPredicate; }; 
		  return null;
		  }
	  
	 
	  public static Specification<Student> combineSpec(String who, String
	  whatUpdate, String value) { 
	  return
	  Specification.where(getStudentByNameSpec(who).and(byColumnNameAndValue(whatUpdate,
	  value)));
	  
	  
	  }
	 



}
