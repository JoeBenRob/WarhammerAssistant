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

import com.bae.persistence.domain.Unit;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class UnitDatabaseRepo implements UnitRepo {

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

	public String getAllUnit() {
		Query query = manager.createQuery("Select a FROM Unit a");
		Collection<Unit> unit = (Collection<Unit>) query.getResultList();
		if (unit.isEmpty()) {
			return "{\"message\": \"Unit Field is empty\"}";
		} else {
		return util.getJSONForObject(unit);
		}
	}

	@Transactional(REQUIRED)
	public String createUnit(String unit) {
		Unit aUnit = util.getObjectForJSON(unit, Unit.class);
		manager.persist(aUnit);
		return "{\"message\": \"Unit has been created\"}";
	}

	@Transactional(REQUIRED)
	public String deleteUnit(int id) {
		Unit unit = manager.find(Unit.class, id);
		if (unit != null) {
			manager.remove(unit);
			return "{\"message\": \"Unit has been removed\"}";
		} else {
			return "{\"message\": \"id doesn't exist\"}";
		}
	}

	@Transactional(REQUIRED)
	public String updateUnit(int id, String unit) {
		Unit transUnit = util.getObjectForJSON(unit, Unit.class);
		Unit oldUnit = manager.find(Unit.class, id);
		if (oldUnit != null) {
			oldUnit.setName(transUnit.getName());
			oldUnit.setArmy(transUnit.getArmy());
			oldUnit.setAllegiance(transUnit.getAllegiance());
			oldUnit.setMin(transUnit.getMin());
			oldUnit.setMax(transUnit.getMax());
			oldUnit.setPoints(transUnit.getPoints());
			manager.persist(oldUnit);
			return "{\"message\": \"Unit has been updated\"}";
		} else {
			return "{\"message\": \"Unit does not exist\"}";
		}
	}

	public String getAUnit(int id) {
		Unit unit = manager.find(Unit.class, id);
		
		if (unit != null) {
			return util.getJSONForObject(unit);
		} else {
			return "{\"message\": \"Unit doesn't exist\"}";
		}
	}
}

