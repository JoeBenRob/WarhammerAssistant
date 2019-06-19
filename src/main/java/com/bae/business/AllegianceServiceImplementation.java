package com.bae.business;

import javax.inject.Inject;

import com.bae.persistence.repository.AllegianceRepo;


public class AllegianceServiceImplementation implements AllegianceService {

	@Inject
	AllegianceRepo AllegianceRepo;
	
	@Override
	public String addAllegiance(String allegiance) {
		return AllegianceRepo.createAllegiance(allegiance);
	}

	@Override
	public String getAllAllegiance() {
		return AllegianceRepo.getAllAllegiance();
	}
	@Override
	public String getAnAllegiance(int id) {
		return AllegianceRepo.getAnAllegiance(id);
	}

	@Override
	public String updateAllegiance(int id, String allegiance) {
		return AllegianceRepo.updateAllegiance(id, allegiance);
	}

	@Override
	public String deleteAllegiance(int id) {
		return AllegianceRepo.deleteAllegiance(id);
	}
	
}
