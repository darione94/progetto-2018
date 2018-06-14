package siw.fullstack.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import siw.fullstack.model.Allievo;
import siw.fullstack.repository.AllievoRepository;

public class AllievoService {
	private EntityManager em;

	public Allievo insertSupplier(Allievo s) {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AllievoRepository pr = new AllievoRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		pr.save(s);
		tx.commit();
		em.close();
		emf.close();
		return s;
	}

	public List<Allievo> getAllSuppliers() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AllievoRepository su = new AllievoRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		List<Allievo> suppliers = su.findAll();
		tx.commit();
		em.close();
		emf.close();
		return suppliers;
	}

	public Allievo getOneSupplier(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AllievoRepository su = new AllievoRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		Allievo s = su.findOne(id);
		tx.commit();
		em.close();
		emf.close();
		return s;
	}
	
	public void deleteSupplier(Allievo s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		this.em = emf.createEntityManager();
		AllievoRepository su = new AllievoRepository(this.em);
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
		AllievoRepository su = new AllievoRepository(this.em);
		EntityTransaction tx = this.em.getTransaction();

		tx.begin();
		su.deleteAll();
		tx.commit();
		em.close();
		emf.close();
	}
}