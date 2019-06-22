package com.bae.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.bae.persistence.domain.User;
import com.bae.util.JSONUtil;

@Transactional(TxType.SUPPORTS)
@Default
public class UserDatabaseRepo implements UserRepo {
	
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
	
	public String getAllUser() {
		Query query = manager.createQuery("Select a FROM User a");
		Collection<User> user = (Collection<User>) query.getResultList();
		if (user.isEmpty()) {
			return "{\"message\": \"User Field is empty\"}";
		} else {
			return util.getJSONForObject(user);
		}
	}

	@Transactional(REQUIRED)
	public String createUser(String user) {
		User aUser = util.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"message\": \"User has been created\"}";
	}

	@Transactional(REQUIRED)
	public String deleteUser(int id) {
		User user = manager.find(User.class, id);
		if (user != null) {
			manager.remove(user);
			return "{\"message\": \"User has been removed\"}";
		} else {
			return "{\"message\": \"id doesn't exist\"}";
		}
	}

	@Transactional(REQUIRED)
	public String updateUser(int id, String user) {
		User transUser = util.getObjectForJSON(user, User.class);
		User oldUser = manager.find(User.class, id);
		if (oldUser != null) {
			oldUser.setName(transUser.getName());
			oldUser.setScore(transUser.getScore());
			manager.persist(oldUser);
			return "{\"message\": \"User has been updated\"}";
		} else {
			return "{\"message\": \"User does not exist\"}";
		}
	}

	public String getAUser(int id) {
		User user = manager.find(User.class, id);
		
		if (user != null) {
			return util.getJSONForObject(user);
		} else {
			return "{\"message\": \"User doesn't exist\"}";
		}
	}
}
