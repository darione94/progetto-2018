package siw.fullstack.repository;

import javax.persistence.EntityManager;

import siw.fullstack.model.*;

public class AttivitÓRepository extends CrudRepositoryJPA<AttivitÓ> {

	public AttivitÓRepository(EntityManager em)  {
		super(em, AttivitÓ.class);
	}
	
}
