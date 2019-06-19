package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.bae.persistence.domain.Allegiance;
import com.bae.util.JSONUtil;

public class AllegianceDatabaseRepo implements AllegianceRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	public String getAllAllegiance() {
		Query query = manager.createQuery("Select a FROM Allegiance a");
		Collection<Allegiance> allegiance = (Collection<Allegiance>) query.getResultList();
		return util.getJSONForObject(allegiance);
	}

	@Transactional(REQUIRED)
	public String createAllegiance(String user) {
		Allegiance anAllegiance = util.getObjectForJSON(user, Allegiance.class);
		manager.persist(anAllegiance);
		return "{\"message\": \"Allegiance has been created\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAllegiance(int id) {
		Allegiance anAllegiance = util.getObjectForJSON(getAnAllegiance(id), Allegiance.class);
		if (manager.contains(manager.find(Allegiance.class, id))) {
			manager.remove(manager.find(Allegiance.class, id));
		}
		return "{\"message\": \"Allegiance has been removed\"}";
	}

	@Transactional(REQUIRED)
	public String updateAllegiance(int id, String allegiance) {
		Allegiance transAllegiance = util.getObjectForJSON(allegiance, Allegiance.class);
		Allegiance oldAllegiance = manager.find(Allegiance.class, id);
		if (oldAllegiance != null) {
			oldAllegiance.setAllegiance(transAllegiance.getAllegiance());
			manager.persist(oldAllegiance);
		}
		return "{\"message\": \"Allegiance has been updated\"}";
	}

	public String getAnAllegiance(int id) {
		return util.getJSONForObject(manager.find(Allegiance.class, id));
	}
}
