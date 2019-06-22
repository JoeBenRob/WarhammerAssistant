package com.bae.persistance.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.domain.User;
import com.bae.persistence.repository.UserDatabaseRepo;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class UserDBTest {
	
	@InjectMocks
	private UserDatabaseRepo repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"id\":1,\"name\":\"Joe\",\"score\":0}]";
	private static final String MOCK_OBJECT1 = "{\"id\":1,\"name\":\"Joe\",\"score\":0}";
	
	private static final String MOCK_DATA_ARRAY2 = "[{\"id\":2,\"name\":\"Ben\",\"score\":0}]";
	private static final String MOCK_OBJECT2 = "{\"id\":2,\"name\":\"Ben\",\"score\":0}";
	
	private static final String MOCK_DATA_ARRAY3 = "[{\"id\":3,\"name\":\"Rob\",\"score\":0}]";
	private static final String MOCK_OBJECT3 = "{\"id\":3,\"name\":\"Rob\",\"score\":0}";
	
	private static final User user1 = new User(1, "Joe", 0);
	private static final User user2 = new User(2, "Ben", 0);
	private static final User user3 = new User(3, "Rob", 0);

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		
	}
	
	@Test
	public void getAllUsers() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();
		users.add(user1);
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.getAllUser());

	}
	
	@Test
	public void getEmptyUsers() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();
		Assert.assertEquals(0, users.size());
		Assert.assertEquals("{\"message\": \"User Field is empty\"}", repo.getAllUser());

	}
	
	@Test
	public void getIdExist() {
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		Mockito.when(manager.find(User.class, 2)).thenReturn(user2);
		Assert.assertEquals(2, users.size());
		Assert.assertEquals(MOCK_OBJECT2, repo.getAUser(2));
	
	}
	
	@Test
	public void getIdFail() {
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		Mockito.when(manager.find(User.class, 2)).thenReturn(user3);
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User doesn't exist\"}", repo.getAUser(3));

	}
	
	@Test
	public void createUser() {

		Assert.assertEquals("{\"message\": \"User has been created\"}", repo.createUser(MOCK_OBJECT2));
		
	}
	
	@Test
	public void deleteUser() {
		
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		Mockito.when(manager.find(User.class, 2)).thenReturn(user2);
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User has been removed\"}", repo.deleteUser(2));

	}

	@Test
	public void deleteFail() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		Mockito.when(manager.find(User.class, 2)).thenReturn(user2);
		Mockito.when(query.getResultList()).thenReturn(users);
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"id doesn't exist\"}", repo.deleteUser(3));
	}
	
	@Test
	public void updateUser() {
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		Mockito.when(manager.find(User.class, 2)).thenReturn(user2);
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User has been updated\"}", repo.updateUser(2, MOCK_OBJECT3));
		Assert.assertEquals("{\"id\":2,\"name\":\"Rob\",\"score\":0}", repo.getAUser(2));

	}
	
	@Test
	public void updateFail() {
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		Mockito.when(manager.find(User.class, 2)).thenReturn(user2);
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("{\"message\": \"User does not exist\"}", repo.updateUser(3, MOCK_OBJECT3));
	}

	
}
