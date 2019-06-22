package com.bae.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.business.AllegianceServiceImplementation;

@RunWith(MockitoJUnitRunner.class)
public class AllegianceRestTest {
		
	@InjectMocks
	public AllegianceController control;
		
	@Mock
	private AllegianceServiceImplementation service;
		
	private static final String MOCK_DATA_ARRAY1 ="[{\"allegianceId\":1,\"allegiance\":\"Order\"}]";
	private static final String MOCK_OBJECT2 ="{\"allegianceId\":1,\"allegiance\":\"Order\"}";;
		
	@Before
	public void setup() {
			
	}
		
	@Test
	public void createAllegiance() {
		Mockito.when(service.createAllegiance(MOCK_OBJECT2)).thenReturn("{\"message\": \"Allegiance has been created\"}");
		Assert.assertEquals("{\"message\": \"Allegiance has been created\"}", control.createAllegiance(MOCK_OBJECT2));		
	}
	
	@Test
	public void findAllUsers() {
		Mockito.when(service.getAllAllegiance()).thenReturn("{\"message\": \"Allegiance has been created\"}");
		Assert.assertEquals("{\"message\": \"Allegiance has been created\"}", control.getAllAllegiance());

	}
		
	@Test
	public void findAnAllegianceId() {		
		Mockito.when(service.getAnAllegiance(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, control.getAnAllegiance(1));
		
	}
		
	@Test
	public void updateAllegiance() {
		Mockito.when(service.updateAllegiance(1, MOCK_OBJECT2)).thenReturn("{\"message\": \"Allegiance has been created\"}");
		Assert.assertEquals("{\"message\": \"Allegiance has been created\"}", control.updateAllegiance(1, MOCK_OBJECT2));
		
	}
		
	@Test
	public void deleteAllegiance() {
		Mockito.when(service.deleteAllegiance(1)).thenReturn("{\"message\": \"Allegiance has been removed\"}");
		Assert.assertEquals("{\"message\": \"Allegiance has been removed\"}", control.deleteAllegiance(1));
		
	}
}

