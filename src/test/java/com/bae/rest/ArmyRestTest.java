package com.bae.rest;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.ArmyServiceImplementation;

@RunWith(MockitoJUnitRunner.class)
public class ArmyRestTest {
		
	@InjectMocks
	public ArmyController control;
		
	@Mock
	private ArmyServiceImplementation service;
		
	private static final String MOCK_DATA_ARRAY1 ="[{\"id\":1,\"name\":\"Seraphon\",\"allegiance\":\"Order\"}]";
	private static final String MOCK_OBJECT2 ="[{\"id\":1,\"name\":\"Seraphon\",\"allegiance\":\"Order\"}]";
		
	@Before
	public void setup() {
			
	}
		
	@Test
	public void createArmy() {
		Mockito.when(service.createArmy(MOCK_OBJECT2)).thenReturn("{\"message\": \"Army has been created\"}");
		Assert.assertEquals("{\"message\": \"Army has been created\"}", control.createArmy(MOCK_OBJECT2));		
	}
	
	@Test
	public void findAllUsers() {
		Mockito.when(service.getAllArmy()).thenReturn("{\"message\": \"Army has been created\"}");
		Assert.assertEquals("{\"message\": \"Army has been created\"}", control.getAllArmy());

	}
		
	@Test
	public void findAnArmyId() {		
		Mockito.when(service.getAnArmy(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getAnArmy(1));
		
	}
		
	@Test
	public void updateArmy() {
		Mockito.when(service.updateArmy(1, MOCK_OBJECT2)).thenReturn("{\"message\": \"Army has been created\"}");
		Assert.assertEquals("{\"message\": \"Army has been created\"}", control.updateArmy(1, MOCK_OBJECT2));
		
	}
		
	@Test
	public void deleteArmy() {
		Mockito.when(service.deleteArmy(1)).thenReturn("{\"message\": \"Army has been removed\"}");
		Assert.assertEquals("{\"message\": \"Army has been removed\"}", control.deleteArmy(1));
		
	}
}
