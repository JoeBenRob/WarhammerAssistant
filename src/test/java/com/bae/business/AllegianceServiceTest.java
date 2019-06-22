package com.bae.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.AllegianceDatabaseRepo;

@RunWith(MockitoJUnitRunner.class)
public class AllegianceServiceTest {
	
	@InjectMocks
	private AllegianceServiceImplementation service;

	@Mock
	private AllegianceDatabaseRepo repo;

	private static final String MOCK_DATA_ARRAY1 ="[{\"id\":1,\"name\":\"joe\",\"score\":\"0\"}]";
	private static final String MOCK_OBJECT2 ="{\"id\":2,\"name\":\"joe\",\"score\":\"0\"}";

	@Before
	public void setup() {

	}

	@Test
	public void createAllegiance() {
		Mockito.when(repo.createAllegiance(MOCK_OBJECT2)).thenReturn("{\"message\": \"Allegiance has been created\"}");
		Assert.assertEquals("{\"message\": \"Allegiance has been created\"}", service.createAllegiance(MOCK_OBJECT2));
	}

	@Test
	public void findAllAllegiances() {
		Mockito.when(repo.getAllAllegiance()).thenReturn("{\"message\": \"Allegiance Field is empty\"}");
		Assert.assertEquals("{\"message\": \"Allegiance Field is empty\"}", service.getAllAllegiance());
	}

	@Test
	public void findAAllegianceId() {
		Mockito.when(repo.getAnAllegiance(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, service.getAnAllegiance(1));
	}

	@Test
	public void updateAllegiance() {
		Mockito.when(repo.updateAllegiance(1, MOCK_OBJECT2)).thenReturn("{\"message\": \"Allegiance has been updated\"}");
		Assert.assertEquals("{\"message\": \"Allegiance has been updated\"}", service.updateAllegiance(1, MOCK_OBJECT2));
	}

	@Test
	public void deleteAllegiance() {
		Mockito.when(repo.deleteAllegiance(1)).thenReturn("{\"message\": \"Allegiance has been deleted\"}");
		Assert.assertEquals("{\"message\": \"Allegiance has been deleted\"}", service.deleteAllegiance(1));
	}

}