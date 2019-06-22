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

import com.bae.persistence.domain.Army;
import com.bae.persistence.repository.ArmyDatabaseRepo;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ArmyDBTest {
	
	@InjectMocks
	private ArmyDatabaseRepo repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;
	
	private static final String MOCK_DATA_ARRAY1 = "[{\"id\":1,\"name\":\"Seraphon\",\"allegiance\":\"Order\"}]";
	private static final String MOCK_OBJECT1 = "{\"id\":1,\"name\":\"Seraphon\",\"allegiance\":\"Order\"}";
	
	private static final String MOCK_DATA_ARRAY2 = "[{\"id\":2,\"name\":\"Free Peoples\",\"allegiance\":\"Order\"}]";
	private static final String MOCK_OBJECT2 = "{\"id\":2,\"name\":\"Free Peoples\",\"allegiance\":\"Order\"}";
	
	private static final String MOCK_DATA_ARRAY3 = "[{\"id\":3,\"name\":\"Dispossessed\",\"allegiance\":\"Order\"}]";
	private static final String MOCK_OBJECT3 = "{\"id\":3,\"name\":\"Dispossessed\",\"allegiance\":\"Order\"}";
	
	private static final Army army1 = new Army(1, "Seraphon", "Order");
	private static final Army army2 = new Army(2, "Free Peoples", "Order");
	private static final Army army3 = new Army(3, "Dispossessed", "Order");

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		
	}
	
	@Test
	public void getAllArmys() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Army> armys = new ArrayList<>();
		armys.add(army1);
		Mockito.when(query.getResultList()).thenReturn(armys);
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.getAllArmy());

	}
	
	@Test
	public void getEmptyArmys() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Army> armys = new ArrayList<>();
		Assert.assertEquals(0, armys.size());
		Assert.assertEquals("{\"message\": \"Army Field is empty\"}", repo.getAllArmy());

	}
	
	@Test
	public void getIdExist() {
		
		List<Army> armys = new ArrayList<>();
		armys.add(army1);
		armys.add(army2);
		Mockito.when(manager.find(Army.class, 2)).thenReturn(army2);
		Assert.assertEquals(2, armys.size());
		Assert.assertEquals(MOCK_OBJECT2, repo.getAnArmy(2));
	
	}
	
	@Test
	public void getIdFail() {
		
		List<Army> armys = new ArrayList<>();
		armys.add(army1);
		armys.add(army2);
		Mockito.when(manager.find(Army.class, 2)).thenReturn(army3);
		Assert.assertEquals(2, armys.size());
		Assert.assertEquals("{\"message\": \"Army doesn't exist\"}", repo.getAnArmy(3));

	}
	
	@Test
	public void createArmy() {

		Assert.assertEquals("{\"message\": \"Army has been created\"}", repo.createArmy(MOCK_OBJECT2));
		
	}
	
	@Test
	public void deleteArmy() {
		
		List<Army> armys = new ArrayList<>();
		armys.add(army1);
		armys.add(army2);
		Mockito.when(manager.find(Army.class, 2)).thenReturn(army2);
		Assert.assertEquals(2, armys.size());
		Assert.assertEquals("{\"message\": \"Army has been removed\"}", repo.deleteArmy(2));

	}

	@Test
	public void deleteFail() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Army> armys = new ArrayList<>();
		armys.add(army1);
		armys.add(army2);
		Mockito.when(manager.find(Army.class, 2)).thenReturn(army2);
		Mockito.when(query.getResultList()).thenReturn(armys);
		Assert.assertEquals(2, armys.size());
		Assert.assertEquals("{\"message\": \"id doesn't exist\"}", repo.deleteArmy(3));
	}
	
	@Test
	public void updateArmy() {
		List<Army> armys = new ArrayList<>();
		armys.add(army1);
		armys.add(army2);
		Mockito.when(manager.find(Army.class, 2)).thenReturn(army2);
		Assert.assertEquals(2, armys.size());
		Assert.assertEquals("{\"message\": \"Army has been updated\"}", repo.updateArmy(2, MOCK_OBJECT3));
		Assert.assertEquals("{\"id\":2,\"name\":\"Dispossessed\",\"allegiance\":\"Order\"}", repo.getAnArmy(2));

	}
	
	@Test
	public void updateFail() {
		List<Army> armys = new ArrayList<>();
		armys.add(army1);
		armys.add(army2);
		Mockito.when(manager.find(Army.class, 2)).thenReturn(army2);
		Assert.assertEquals(2, armys.size());
		Assert.assertEquals("{\"message\": \"Army does not exist\"}", repo.updateArmy(3, MOCK_OBJECT3));
	}

	
}
