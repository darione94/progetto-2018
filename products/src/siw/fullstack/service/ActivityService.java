package siw.fullstack.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;

import siw.fullstack.model.Activity;
import siw.fullstack.model.Student;
import siw.fullstack.repository.ActivityRepository;

public class ActivityService {
	private EntityManager em;

	public Activity insertProduct(Activity p) {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		ActivityRepository pr = new ActivityRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.save(p);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public Activity addSupplier(Activity p, Student s){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		ActivityRepository pr = new ActivityRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		
		if(p.getSuppliers()!=null)
			p.getSuppliers().add(s);
		else {
			ArrayList<Student> suppliers = new ArrayList<>();
		    suppliers.add(s);
		    p.setSuppliers(suppliers);
		}
		pr.save(p);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public Activity removeSupplier(Activity p, Student s){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		ActivityRepository pr = new ActivityRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		
		if(p.getSuppliers()!=null)
			p.getSuppliers().remove(s);
		pr.save(p);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}

	public List<Activity> getAllProducts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		ActivityRepository pr = new ActivityRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		List<Activity> products = pr.findAll();
		tx.commit();
		em.close();
		emf.close();
		return products;
	}

	public Activity getOneProduct(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		ActivityRepository pr = new ActivityRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		Activity p = pr.findOne(id);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public void deleteProduct(Activity p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		ActivityRepository pr = new ActivityRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.delete(p);
		tx.commit();
		em.close();
		emf.close();
	}
	
	public void deleteAllProducts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		ActivityRepository pr = new ActivityRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.deleteAll();
		tx.commit();
		em.close();
		emf.close();
	}
}