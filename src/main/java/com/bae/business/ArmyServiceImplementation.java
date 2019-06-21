package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.ArmyRepo;
import com.bae.persistence.repository.UnitRepo;

public class ArmyServiceImplementation implements ArmyService {

	@Inject
	ArmyRepo armyRepo;

	@Override
	public String addArmy(String army) {
		return armyRepo.createArmy(army);
	}

	@Override
	public String getAllArmy() {
		return armyRepo.getAllArmy();
	}

	@Override
	public String getAnArmy(int id) {
		return armyRepo.getAnArmy(id);
	}

	@Override
	public String updateArmy(int id, String army) {
		return armyRepo.updateArmy(id, army);
	}

	@Override
	public String deleteArmy(int id) {
		return armyRepo.deleteArmy(id);
	}
	
}
