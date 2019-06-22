package com.bae.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.UnitServiceImplementation;


@RunWith(MockitoJUnitRunner.class)
public class UnitRestTest {
		
	@InjectMocks
	public UnitController control;
		
	@Mock
	private UnitServiceImplementation service;
		
	private static final String MOCK_DATA_ARRAY1 ="[{\"id\":1,\"name\":\"Saurus Warrior\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"Battleline\",\"min\":10,\"max\":40,\"points\":100}]";
	private static final String MOCK_OBJECT2 ="{\"id\":1,\"name\":\"Saurus Warrior\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"Battleline\",\"min\":10,\"max\":40,\"points\":100}";
		
	@Before
	public void setup() {
			
	}
		
	@Test
	public void createUnit() {
		Mockito.when(service.createUnit(MOCK_OBJECT2)).thenReturn("{\"message\": \"Unit has been created\"}");
		Assert.assertEquals("{\"message\": \"Unit has been created\"}", control.createUnit(MOCK_OBJECT2));		
	}
	
	@Test
	public void findAllUsers() {
		Mockito.when(service.getAllUnit()).thenReturn("{\"message\": \"Unit has been created\"}");
		Assert.assertEquals("{\"message\": \"Unit has been created\"}", control.getAllUnit());

	}
		
	@Test
	public void findAUserId() {		
		Mockito.when(service.getAUnit(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getAUnit(1));
		
	}
		
	@Test
	public void updateUser() {
		Mockito.when(service.updateUnit(1, MOCK_OBJECT2)).thenReturn("{\"message\": \"Unit has been created\"}");
		Assert.assertEquals("{\"message\": \"Unit has been created\"}", control.updateUnit(1, MOCK_OBJECT2));
		
	}
		
	@Test
	public void deleteUser() {
		Mockito.when(service.deleteUnit(1)).thenReturn("{\"message\": \"Unit has been removed\"}");
		Assert.assertEquals("{\"message\": \"Unit has been removed\"}", control.deleteUnit(1));
		
	}
}


