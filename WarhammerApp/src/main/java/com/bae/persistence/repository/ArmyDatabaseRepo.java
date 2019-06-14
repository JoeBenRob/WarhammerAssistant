package com.bae.persistence.repository;

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
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class ArmyDatabaseRepo implements ArmyRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllArmy() {
		Query query = manager.createQuery("Select a FROM Army a");
		Collection<Army> army = (Collection<Army>) query.getResultList();
		return util.getJSONForObject(army);
	}

	@Override
	public String createArmy(String army) {
		Army anArmy = util.getObjectForJSON(army, Army.class);
		manager.persist(anArmy);
		return "{\"message\": \"Army has been created\"}";
	}

	@Override
	public String deleteArmy(int id) {
		Army anArmy = util.getObjectForJSON(getAnArmy(id), Army.class);
		if (manager.contains(manager.find(Army.class, id))) {
			manager.remove(manager.find(Army.class, id));
		}
		return "{\"message\": \"Army has been removed\"}";
	}

	@Override
	public String updateArmy(int id, String army) {
		Army transArmy = util.getObjectForJSON(army, Army.class);
		Army oldArmy = manager.find(Army.class, id);
		if (oldArmy != null) {
			oldArmy.setName(transArmy.getName());
			manager.persist(oldArmy);
		}
		return "{\"message\": \"Unit has been updated\"}";
	}

	@Override
	public String getAnArmy(int id) {
		return util.getJSONForObject(manager.find(Army.class, id));
	}

}
