package com.bae.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.UserServiceImplementation;

@RunWith(MockitoJUnitRunner.class)
public class UserRestTest {
	
	@InjectMocks
	public UserController control;
	
	@Mock
	private UserServiceImplementation service;
	
	private static final String MOCK_DATA_ARRAY1 ="[{\"id\":1,\"name\":\"joe\",\"score\":\"0\"}]";
	private static final String MOCK_OBJECT2 ="{\"id\":2,\"name\":\"joe\",\"score\":\"0\"}";
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void createUser() {
		Mockito.when(service.createUser(MOCK_OBJECT2)).thenReturn("{\"message\": \"User has been created\"}");
		Assert.assertEquals("{\"message\": \"User has been created\"}", control.createUser(MOCK_OBJECT2));
	
	}
	
	@Test
	public void findAllUsers() {
		Mockito.when(service.getAllUser()).thenReturn("{\"message\": \"User has been created\"}");
		Assert.assertEquals("{\"message\": \"User has been created\"}", control.getAllUser());
	
	}
	
	@Test
	public void findAUserId() {
		Mockito.when(service.getAUser(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getAUser(1));
	
	}
	
	@Test
	public void updateUser() {
		Mockito.when(service.updateUser(1, MOCK_OBJECT2)).thenReturn("{\"message\": \"User has been created\"}");
		Assert.assertEquals("{\"message\": \"User has been created\"}", control.updateUser(1, MOCK_OBJECT2));
	
	}
	
	@Test
	public void deleteUser() {
		Mockito.when(service.deleteUser(1)).thenReturn("{\"message\": \"User has been removed\"}");
		Assert.assertEquals("{\"message\": \"User has been removed\"}", control.deleteUser(1));
	
	}
}
