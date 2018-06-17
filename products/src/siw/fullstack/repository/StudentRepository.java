package siw.fullstack.repository;

import javax.persistence.EntityManager;

import siw.fullstack.model.Student;

public class StudentRepository extends CrudRepositoryJPA<Student> {

	public StudentRepository(EntityManager em)  {
		super(em, Student.class);
	}
	
}
