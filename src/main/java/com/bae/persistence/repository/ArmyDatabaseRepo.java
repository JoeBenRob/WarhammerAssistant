package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.Army;
import com.bae.persistence.domain.Unit;
import com.bae.persistence.domain.Army;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class ArmyDatabaseRepo implements ArmyRepo {

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
	
	public String getAllArmy() {
		Query query = manager.createQuery("Select a FROM Army a");
		Collection<Army> army = (Collection<Army>) query.getResultList();
		if (army.isEmpty()) {
			return "{\"message\": \"Army Field is empty\"}";
		} else {
		return util.getJSONForObject(army);
		}
	}

	@Transactional(REQUIRED)
	public String createArmy(String army) {
		Army anArmy = util.getObjectForJSON(army, Army.class);
		manager.persist(anArmy);
		return "{\"message\": \"Army has been created\"}";
	}

	@Transactional(REQUIRED)
	public String deleteArmy(int id) {
		Army army = manager.find(Army.class, id);
		if (army != null) {
			manager.remove(army);
			return "{\"message\": \"Army has been removed\"}";
		} else {
			return "{\"message\": \"id doesn't exist\"}";
		}
	}

	@Transactional(REQUIRED)
	public String updateArmy(int id, String army) {
		Army transArmy = util.getObjectForJSON(army, Army.class);
		Army oldArmy = manager.find(Army.class, id);
		if (oldArmy != null) {
			oldArmy.setName(transArmy.getName());
			manager.persist(oldArmy);
			return "{\"message\": \"Army has been updated\"}";
		} else {
			return "{\"message\": \"Army does not exist\"}";
		}
	}

	public String getAnArmy(int id) {
		Army army = manager.find(Army.class, id);
		
		if (army != null) {
			return util.getJSONForObject(army);
		} else {
			return "{\"message\": \"Army doesn't exist\"}";
		}
	}

}
