package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.UnitRepo;

public class UnitServiceImplementation implements UnitService {

	@Inject
	UnitRepo unitRepo;
	
	@Override
	public String addUnit(String unit) {
		return unitRepo.createUnit(unit);
	}

	@Override
	public String getAllUnit() {
		return unitRepo.getAllUnit();
	}
	@Override
	public String getAUnit(int id) {
		return unitRepo.getAUnit(id);
	}

	@Override
	public String updateUnit(int id, String unit) {
		return unitRepo.updateUnit(id, unit);
	}

	@Override
	public String deleteUnit(int id) {
		return unitRepo.deleteUnit(id);
	}
	
}
