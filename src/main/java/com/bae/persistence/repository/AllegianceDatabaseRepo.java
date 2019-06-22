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
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public JSONUtil getUtil() {
		return util;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}
	
	public String getAllAllegiance() {
		Query query = manager.createQuery("Select a FROM Allegiance a");
		Collection<Allegiance> allegiance = (Collection<Allegiance>) query.getResultList();
		if (allegiance.isEmpty()) {
			return "{\"message\": \"Allegiance Field is empty\"}";
		} else {
		return util.getJSONForObject(allegiance);
		}
	}

	@Transactional(REQUIRED)
	public String createAllegiance(String allegiance) {
		Allegiance anAllegiance = util.getObjectForJSON(allegiance, Allegiance.class);
		manager.persist(anAllegiance);
		return "{\"message\": \"Allegiance has been created\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAllegiance(int id) {
		Allegiance allegiance = manager.find(Allegiance.class, id);
		if (allegiance != null) {
			manager.remove(allegiance);
			return "{\"message\": \"Allegiance has been removed\"}";
		} else {
			return "{\"message\": \"id doesn't exist\"}";
		}
	}

	@Transactional(REQUIRED)
	public String updateAllegiance(int id, String allegiance) {
		Allegiance transAllegiance = util.getObjectForJSON(allegiance, Allegiance.class);
		Allegiance oldAllegiance = manager.find(Allegiance.class, id);
		if (oldAllegiance != null) {
			oldAllegiance.setAllegiance(transAllegiance.getAllegiance());
			manager.persist(oldAllegiance);
			return "{\"message\": \"Allegiance has been updated\"}";
		} else {
			return "{\"message\": \"Allegiance does not exist\"}";
		}
	}

	public String getAnAllegiance(int id) {
		Allegiance allegiance = manager.find(Allegiance.class, id);
		
		if (allegiance != null) {
			return util.getJSONForObject(allegiance);
		} else {
			return "{\"message\": \"Allegiance doesn't exist\"}";
		}
	}
}

