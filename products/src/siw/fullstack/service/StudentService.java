package siw.fullstack.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import siw.fullstack.model.Student;
import siw.fullstack.repository.StudentRepository;

public class StudentService {
	private EntityManager em;

	public Student insertSupplier(Student s) {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		StudentRepository pr = new StudentRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.save(s);
		tx.commit();
		em.close();
		emf.close();
		return s;
	}

	public List<Student> getAllSuppliers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		StudentRepository su = new StudentRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		List<Student> suppliers = su.findAll();
		tx.commit();
		em.close();
		emf.close();
		return suppliers;
	}

	public Student getOneSupplier(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		StudentRepository su = new StudentRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		Student s = su.findOne(id);
		tx.commit();
		em.close();
		emf.close();
		return s;
	}
	
	public void deleteSupplier(Student s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		StudentRepository su = new StudentRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		su.delete(s);
		tx.commit();
		em.close();
		emf.close();
	}
	
	public void deleteAllSuppliers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		StudentRepository su = new StudentRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		su.deleteAll();
		tx.commit();
		em.close();
		emf.close();
	}
}