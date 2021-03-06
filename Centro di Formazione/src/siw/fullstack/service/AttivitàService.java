package siw.fullstack.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;

import siw.fullstack.model.AttivitÓ;
import siw.fullstack.model.Allievo;
import siw.fullstack.repository.AttivitÓRepository;

public class AttivitÓService {
	private EntityManager em;

	public AttivitÓ insertProduct(AttivitÓ p) {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AttivitÓRepository pr = new AttivitÓRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.save(p);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public AttivitÓ addSupplier(AttivitÓ p, Allievo s){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AttivitÓRepository pr = new AttivitÓRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		
		if(p.getSuppliers()!=null)
			p.getSuppliers().add(s);
		else {
			ArrayList<Allievo> suppliers = new ArrayList<>();
		    suppliers.add(s);
		    p.setSuppliers(suppliers);
		}
		pr.save(p);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public AttivitÓ removeSupplier(AttivitÓ p, Allievo s){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AttivitÓRepository pr = new AttivitÓRepository(this.em);
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

	public List<AttivitÓ> getAllProducts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AttivitÓRepository pr = new AttivitÓRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		List<AttivitÓ> products = pr.findAll();
		tx.commit();
		em.close();
		emf.close();
		return products;
	}

	public AttivitÓ getOneProduct(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AttivitÓRepository pr = new AttivitÓRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		AttivitÓ p = pr.findOne(id);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public void deleteProduct(AttivitÓ p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AttivitÓRepository pr = new AttivitÓRepository(this.em);
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
		AttivitÓRepository pr = new AttivitÓRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.deleteAll();
		tx.commit();
		em.close();
		emf.close();
	}
}