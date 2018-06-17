package siw.fullstack.repository;

import javax.persistence.EntityManager;

import siw.fullstack.model.*;

public class ActivityRepository extends CrudRepositoryJPA<Activity> {

	public ActivityRepository(EntityManager em)  {
		super(em, Activity.class);
	}
	
}
