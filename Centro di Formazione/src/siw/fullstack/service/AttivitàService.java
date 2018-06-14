package siw.fullstack.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;

import siw.fullstack.model.Attivit‡;
import siw.fullstack.model.Allievo;
import siw.fullstack.repository.Attivit‡Repository;

public class Attivit‡Service {
	private EntityManager em;

	public Attivit‡ insertProduct(Attivit‡ p) {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		Attivit‡Repository pr = new Attivit‡Repository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.save(p);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public Attivit‡ addSupplier(Attivit‡ p, Allievo s){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		Attivit‡Repository pr = new Attivit‡Repository(this.em);
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
	
	public Attivit‡ removeSupplier(Attivit‡ p, Allievo s){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		Attivit‡Repository pr = new Attivit‡Repository(this.em);
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

	public List<Attivit‡> getAllProducts() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		Attivit‡Repository pr = new Attivit‡Repository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		List<Attivit‡> products = pr.findAll();
		tx.commit();
		em.close();
		emf.close();
		return products;
	}

	public Attivit‡ getOneProduct(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		Attivit‡Repository pr = new Attivit‡Repository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		Attivit‡ p = pr.findOne(id);
		tx.commit();
		em.close();
		emf.close();
		return p;
	}
	
	public void deleteProduct(Attivit‡ p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		Attivit‡Repository pr = new Attivit‡Repository(this.em);
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
		Attivit‡Repository pr = new Attivit‡Repository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.deleteAll();
		tx.commit();
		em.close();
		emf.close();
	}
}