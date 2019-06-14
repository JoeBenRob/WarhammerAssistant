package com.bae.business;

public interface AllegianceService {
	
	String addAllegiance(String allegiance);
	String getAllAllegiance();
	String getAnAllegiance(int id);
	String updateAllegiance(int id, String allegiance);
	String deleteAllegiance(int id);

}
