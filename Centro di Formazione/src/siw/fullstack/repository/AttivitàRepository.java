package siw.fullstack.repository;

import javax.persistence.EntityManager;

import siw.fullstack.model.*;

public class Attivit‡Repository extends CrudRepositoryJPA<Attivit‡> {

	public Attivit‡Repository(EntityManager em)  {
		super(em, Attivit‡.class);
	}
	
}
