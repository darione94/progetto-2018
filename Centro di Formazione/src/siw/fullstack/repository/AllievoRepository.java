package siw.fullstack.repository;

import javax.persistence.EntityManager;

import siw.fullstack.model.Allievo;

public class AllievoRepository extends CrudRepositoryJPA<Allievo> {

	public AllievoRepository(EntityManager em)  {
		super(em, Allievo.class);
	}
	
}
