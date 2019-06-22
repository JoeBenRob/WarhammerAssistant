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

import com.bae.persistence.domain.Unit;
import com.bae.persistence.domain.Unit;
import com.bae.persistence.repository.UnitDatabaseRepo;
import com.bae.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class UnitDBTest {
	
	@InjectMocks
	private UnitDatabaseRepo repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;
	
	private static final String MOCK_DATA_ARRAY1 = 	"[{\"id\":1,\"name\":\"Saurus Warrior\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"Battleline\",\"min\":10,\"max\":40,\"points\":100}]";
	private static final String MOCK_OBJECT1 = 		"{\"id\":1,\"name\":\"Saurus Warrior\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"Battleline\",\"min\":10,\"max\":40,\"points\":100}";

	private static final String MOCK_DATA_ARRAY2 = 	"[{\"id\":2,\"name\":\"Saurus Guard\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"-\",\"min\":5,\"max\":20,\"points\":100}]";
	private static final String MOCK_OBJECT2 = 		"{\"id\":2,\"name\":\"Saurus Guard\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"-\",\"min\":5,\"max\":20,\"points\":100}";

	private static final String MOCK_DATA_ARRAY3 = 	"[{\"id\":3,\"name\":\"Saurus Knight\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"-\",\"min\":5,\"max\":20,\"points\":120}]";
	private static final String MOCK_OBJECT3 = 		"{\"id\":3,\"name\":\"Saurus Knight\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"-\",\"min\":5,\"max\":20,\"points\":120}";
	
	private static final Unit unit1 = new Unit(1, "Saurus Warrior", "Order", "Seraphon", "Battleline", 10, 40, 100);
	private static final Unit unit2 = new Unit(2, "Saurus Guard", "Order", "Seraphon", "-", 5, 20, 100);
	private static final Unit unit3 = new Unit(3, "Saurus Knight", "Order", "Seraphon", "-", 5, 20, 120);

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
		
	}
	
	@Test
	public void getAllUnits() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> units = new ArrayList<>();
		units.add(unit1);
		Mockito.when(query.getResultList()).thenReturn(units);
		Assert.assertEquals(MOCK_DATA_ARRAY1, repo.getAllUnit());

	}
	
	@Test
	public void getEmptyUnits() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> units = new ArrayList<>();
		Assert.assertEquals(0, units.size());
		Assert.assertEquals("{\"message\": \"Unit Field is empty\"}", repo.getAllUnit());

	}
	
	@Test
	public void getIdExist() {
		
		List<Unit> units = new ArrayList<>();
		units.add(unit1);
		units.add(unit2);
		Mockito.when(manager.find(Unit.class, 2)).thenReturn(unit2);
		Assert.assertEquals(2, units.size());
		Assert.assertEquals(MOCK_OBJECT2, repo.getAUnit(2));
	
	}
	
	@Test
	public void getIdFail() {
		
		List<Unit> units = new ArrayList<>();
		units.add(unit1);
		units.add(unit2);
		Mockito.when(manager.find(Unit.class, 2)).thenReturn(unit3);
		Assert.assertEquals(2, units.size());
		Assert.assertEquals("{\"message\": \"Unit doesn't exist\"}", repo.getAUnit(3));

	}
	
	@Test
	public void createUnit() {

		Assert.assertEquals("{\"message\": \"Unit has been created\"}", repo.createUnit(MOCK_OBJECT2));
		
	}
	
	@Test
	public void deleteUnit() {
		
		List<Unit> units = new ArrayList<>();
		units.add(unit1);
		units.add(unit2);
		Mockito.when(manager.find(Unit.class, 2)).thenReturn(unit2);
		Assert.assertEquals(2, units.size());
		Assert.assertEquals("{\"message\": \"Unit has been removed\"}", repo.deleteUnit(2));

	}

	@Test
	public void deleteFail() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Unit> units = new ArrayList<>();
		units.add(unit1);
		units.add(unit2);
		Mockito.when(manager.find(Unit.class, 2)).thenReturn(unit2);
		Mockito.when(query.getResultList()).thenReturn(units);
		Assert.assertEquals(2, units.size());
		Assert.assertEquals("{\"message\": \"id doesn't exist\"}", repo.deleteUnit(3));
	}
	
	@Test
	public void updateUnit() {
		List<Unit> units = new ArrayList<>();
		units.add(unit1);
		units.add(unit2);
		Mockito.when(manager.find(Unit.class, 2)).thenReturn(unit2);
		Assert.assertEquals(2, units.size());
		Assert.assertEquals("{\"message\": \"Unit has been updated\"}", repo.updateUnit(2, MOCK_OBJECT3));
		Assert.assertEquals("{\"id\":2,\"name\":\"Saurus Knight\",\"allegiance\":\"Order\",\"army\":\"Seraphon\",\"role\":\"-\",\"min\":5,\"max\":20,\"points\":120}", repo.getAUnit(2));

	}
	
	@Test
	public void updateFail() {
		List<Unit> units = new ArrayList<>();
		units.add(unit1);
		units.add(unit2);
		Mockito.when(manager.find(Unit.class, 2)).thenReturn(unit2);
		Assert.assertEquals(2, units.size());
		Assert.assertEquals("{\"message\": \"Unit does not exist\"}", repo.updateUnit(3, MOCK_OBJECT3));
	}

	
}