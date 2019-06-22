package com.bae.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.bae.persistence.repository.UnitDatabaseRepo;

@RunWith(MockitoJUnitRunner.class)
public class UnitServiceTest {
	
	@InjectMocks
	private UnitServiceImplementation service;

	@Mock
	private UnitDatabaseRepo repo;

	private static final String MOCK_DATA_ARRAY1 ="[{\"id\":1,\"name\":\"joe\",\"score\":\"0\"}]";
	private static final String MOCK_OBJECT2 ="{\"id\":2,\"name\":\"joe\",\"score\":\"0\"}";

	@Before
	public void setup() {

	}

	@Test
	public void createUnit() {
		Mockito.when(repo.createUnit(MOCK_OBJECT2)).thenReturn("{\"message\": \"Unit has been created\"}");
		Assert.assertEquals("{\"message\": \"Unit has been created\"}", service.createUnit(MOCK_OBJECT2));
	}

	@Test
	public void findAllUnits() {
		Mockito.when(repo.getAllUnit()).thenReturn("{\"message\": \"Unit Field is empty\"}");
		Assert.assertEquals("{\"message\": \"Unit Field is empty\"}", service.getAllUnit());
	}

	@Test
	public void findAUnitId() {
		Mockito.when(repo.getAUnit(1)).thenReturn(MOCK_DATA_ARRAY1);
		Assert.assertEquals(MOCK_DATA_ARRAY1, service.getAUnit(1));
	}

	@Test
	public void updateUnit() {
		Mockito.when(repo.updateUnit(1, MOCK_OBJECT2)).thenReturn("{\"message\": \"Unit has been updated\"}");
		Assert.assertEquals("{\"message\": \"Unit has been updated\"}", service.updateUnit(1, MOCK_OBJECT2));
	}

	@Test
	public void deleteUnit() {
		Mockito.when(repo.deleteUnit(1)).thenReturn("{\"message\": \"Unit has been deleted\"}");
		Assert.assertEquals("{\"message\": \"Unit has been deleted\"}", service.deleteUnit(1));
	}

}