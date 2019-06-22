package com.bae.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.UserDatabaseRepo;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserServiceImplementation service;

	@Mock
	private UserDatabaseRepo repo;

	private static final String MOCK_DATA_ARRAY1 ="[{\"id\":1,\"name\":\"joe\",\"score\":\"0\"}]";
	private static final String MOCK_OBJECT2 ="{\"id\":2,\"name\":\"joe\",\"score\":\"0\"}";

	@Before
	public void setup() {

	}

	@Test
	public void createUser() {
		Mockito.when(repo.createUser(MOCK_OBJECT2)).thenReturn("{\"message\": \"User has been created\"}");
		Assert.assertEquals("{\"message\": \"User has been created\"}", service.createUser(MOCK_OBJECT2));
	}

	@Test
	public void findAllUsers() {
		Mockito.when(repo.getAllUser()).thenReturn("{\"message\": \"User Field is empty\"}");
		Assert.assertEquals("{\"message\": \"User Field is empty\"}", service.getAllUser());
	}

	@Test
	public void findAUserId() {
		Mockito.when(repo.getAUser(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, service.getAUser(1));
	}

	@Test
	public void updateUser() {
		Mockito.when(repo.updateUser(1, MOCK_OBJECT2)).thenReturn("{\"message\": \"User has been updated\"}");
		Assert.assertEquals("{\"message\": \"User has been updated\"}", service.updateUser(1, MOCK_OBJECT2));
	}

	@Test
	public void deleteUser() {
		Mockito.when(repo.deleteUser(1)).thenReturn("{\"message\": \"User has been deleted\"}");
		Assert.assertEquals("{\"message\": \"User has been deleted\"}", service.deleteUser(1));
	}

}
