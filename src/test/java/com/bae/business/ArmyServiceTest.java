package com.bae.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bae.persistence.repository.ArmyDatabaseRepo;

@RunWith(MockitoJUnitRunner.class)
public class ArmyServiceTest {
	
	@InjectMocks
	private ArmyServiceImplementation service;

	@Mock
	private ArmyDatabaseRepo repo;

	private static final String MOCK_DATA_ARRAY1 ="[{\"id\":1,\"name\":\"joe\",\"score\":\"0\"}]";
	private static final String MOCK_OBJECT2 ="{\"id\":2,\"name\":\"joe\",\"score\":\"0\"}";

	@Before
	public void setup() {

	}

	@Test
	public void createArmy() {
		Mockito.when(repo.createArmy(MOCK_OBJECT2)).thenReturn("{\"message\": \"Army has been created\"}");
		Assert.assertEquals("{\"message\": \"Army has been created\"}", service.createArmy(MOCK_OBJECT2));
	}

	@Test
	public void findAllArmys() {
		Mockito.when(repo.getAllArmy()).thenReturn("{\"message\": \"Army Field is empty\"}");
		Assert.assertEquals("{\"message\": \"Army Field is empty\"}", service.getAllArmy());
	}

	@Test
	public void findAArmyId() {
		Mockito.when(repo.getAnArmy(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, service.getAnArmy(1));
	}

	@Test
	public void updateArmy() {
		Mockito.when(repo.updateArmy(1, MOCK_OBJECT2)).thenReturn("{\"message\": \"Army has been updated\"}");
		Assert.assertEquals("{\"message\": \"Army has been updated\"}", service.updateArmy(1, MOCK_OBJECT2));
	}

	@Test
	public void deleteArmy() {
		Mockito.when(repo.deleteArmy(1)).thenReturn("{\"message\": \"Army has been deleted\"}");
		Assert.assertEquals("{\"message\": \"Army has been deleted\"}", service.deleteArmy(1));
	}

}