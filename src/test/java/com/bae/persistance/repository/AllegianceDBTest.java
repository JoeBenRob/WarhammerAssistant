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

import com.bae.persistence.domain.Allegiance;
import com.bae.persistence.repository.AllegianceDatabaseRepo;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AllegianceDBTest {
	
	@InjectMocks
	private AllegianceDatabaseRepo repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"allegianceId\":1,\"allegiance\":\"Order\"}]";
	private static final String MOCK_OBJECT1 = "{\"allegianceId\":1,\"allegiance\":\"Order\"}";
	
	private static final String MOCK_DATA_ARRAY2 = "[{\"allegianceId\":2,\"allegiance\":\"Chaos\"}]";
	private static final String MOCK_OBJECT2 = "{\"allegianceId\":2,\"allegiance\":\"Chaos\"}";
	
	private static final String MOCK_DATA_ARRAY3 = "[{\"allegianceId\":3,\"allegiance\":\"Death\"}]";
	private static final String MOCK_OBJECT3 = "{\"allegianceId\":3,\"allegiance\":\"Death\"}";
	
	private static final Allegiance allegiance1 = new Allegiance(1, "Order");
	private static final Allegiance allegiance2 = new Allegiance(2, "Chaos");
	private static final Allegiance allegiance3 = new Allegiance(3, "Death");

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		
	}
	
	@Test
	public void getAllAllegiances() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Allegiance> allegiances = new ArrayList<>();
		allegiances.add(allegiance1);
		Mockito.when(query.getResultList()).thenReturn(allegiances);
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.getAllAllegiance());

	}
	
	@Test
	public void getEmptyAllegiances() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Allegiance> allegiances = new ArrayList<>();
		Assert.assertEquals(0, allegiances.size());
		Assert.assertEquals("{\"message\": \"Allegiance Field is empty\"}", repo.getAllAllegiance());

	}
	
	@Test
	public void getIdExist() {
		
		List<Allegiance> allegiances = new ArrayList<>();
		allegiances.add(allegiance1);
		allegiances.add(allegiance2);
		Mockito.when(manager.find(Allegiance.class, 2)).thenReturn(allegiance2);
		Assert.assertEquals(2, allegiances.size());
		Assert.assertEquals(MOCK_OBJECT2, repo.getAnAllegiance(2));
	
	}
	
	@Test
	public void getIdFail() {
		
		List<Allegiance> allegiances = new ArrayList<>();
		allegiances.add(allegiance1);
		allegiances.add(allegiance2);
		Mockito.when(manager.find(Allegiance.class, 2)).thenReturn(allegiance3);
		Assert.assertEquals(2, allegiances.size());
		Assert.assertEquals("{\"message\": \"Allegiance doesn't exist\"}", repo.getAnAllegiance(3));

	}
	
	@Test
	public void createAllegiance() {

		Assert.assertEquals("{\"message\": \"Allegiance has been created\"}", repo.createAllegiance(MOCK_OBJECT2));
		
	}
	
	@Test
	public void deleteAllegiance() {
		
		List<Allegiance> allegiances = new ArrayList<>();
		allegiances.add(allegiance1);
		allegiances.add(allegiance2);
		Mockito.when(manager.find(Allegiance.class, 2)).thenReturn(allegiance2);
		Assert.assertEquals(2, allegiances.size());
		Assert.assertEquals("{\"message\": \"Allegiance has been removed\"}", repo.deleteAllegiance(2));

	}

	@Test
	public void deleteFail() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Allegiance> allegiances = new ArrayList<>();
		allegiances.add(allegiance1);
		allegiances.add(allegiance2);
		Mockito.when(manager.find(Allegiance.class, 2)).thenReturn(allegiance2);
		Mockito.when(query.getResultList()).thenReturn(allegiances);
		Assert.assertEquals(2, allegiances.size());
		Assert.assertEquals("{\"message\": \"id doesn't exist\"}", repo.deleteAllegiance(3));
	}
	
	@Test
	public void updateAllegiance() {
		List<Allegiance> allegiances = new ArrayList<>();
		allegiances.add(allegiance1);
		allegiances.add(allegiance2);
		Mockito.when(manager.find(Allegiance.class, 2)).thenReturn(allegiance2);
		Assert.assertEquals(2, allegiances.size());
		Assert.assertEquals("{\"message\": \"Allegiance has been updated\"}", repo.updateAllegiance(2, MOCK_OBJECT3));
		Assert.assertEquals("{\"allegianceId\":2,\"allegiance\":\"Death\"}", repo.getAnAllegiance(2));

	}
	
	@Test
	public void updateFail() {
		List<Allegiance> allegiances = new ArrayList<>();
		allegiances.add(allegiance1);
		allegiances.add(allegiance2);
		Mockito.when(manager.find(Allegiance.class, 2)).thenReturn(allegiance2);
		Assert.assertEquals(2, allegiances.size());
		Assert.assertEquals("{\"message\": \"Allegiance does not exist\"}", repo.updateAllegiance(3, MOCK_OBJECT3));
	}

	
}
